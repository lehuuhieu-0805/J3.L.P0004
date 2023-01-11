/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tblArticle.ArticleDAO;
import tblArticle.ArticleDTO;

/**
 *
 * @author lehuuhieu
 */
@WebServlet(name = "SearchController", urlPatterns = {"/SearchController"})
public class SearchController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "articles.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String url = ERROR;

        try {
            String searchContent = request.getParameter("txtSearchContent");

            String pageTemp = request.getParameter("page");
            int page = 0;
            if (pageTemp != null) {
                // current page start = 1 so this value page use in offset sql and offset start = 0 so we must use page - 1
                page = Integer.parseInt(request.getParameter("page")) - 1;
            }
            if (searchContent == null) {
                searchContent = "";
            }

            ArticleDAO dao = new ArticleDAO();
            List<ArticleDTO> list = dao.searchWithPagination(searchContent, page);

            int count = dao.search(searchContent).size();
            int endPage = count / 20;
            if (count % 20 != 0) {
                endPage++;
            }

            request.setAttribute("END_PAGE", endPage);
            // this value page use in offset sql and offset start = 0 so current page must equal page + 1
            request.setAttribute("CURRENT_PAGE", page + 1);
            request.setAttribute("SEARCH_RESULT", list);
            url = SUCCESS;
        } catch (Exception e) {
            log("ERROR at SearchController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
