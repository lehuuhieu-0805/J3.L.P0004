/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tblArticle.ArticleDAO;
import tblArticle.ArticleDTO;
import tblArticle.ArticleError;

/**
 *
 * @author lehuuhieu
 */
@WebServlet(name = "PostArticleController", urlPatterns = {"/PostArticleController"})
public class PostArticleController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String INVALID = "postArticle.jsp";
    private static final String SUCCESS = "articles.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String url = ERROR;
        ArticleDAO dao = new ArticleDAO();

        try {
            String title = request.getParameter("txtTitle");
            String shortDescription = request.getParameter("txtShortDescription");
            String content = request.getParameter("txtContent");

            boolean valid = true;
            ArticleError errorObj = new ArticleError();

            if (title.length() == 0) {
                url = INVALID;
                valid = false;
                errorObj.setTitleError("Title can't be blank");
            }
            if (shortDescription.length() == 0) {
                url = INVALID;
                valid = false;
                errorObj.setShortDescriptionError("Short Description can't be blank");
            }
            if (content.length() == 0) {
                url = INVALID;
                valid = false;
                errorObj.setContentError("Content can't be blank");
            }

            if (valid) {
                java.util.Date date = new java.util.Date();
                Timestamp postingDate = new Timestamp(date.getTime());
                HttpSession session = request.getSession();
                String userEmail = (String) session.getAttribute("email");
                System.out.println(userEmail);
                ArticleDTO dto = new ArticleDTO(title, shortDescription, content, "New", userEmail, postingDate);
                boolean check = dao.create(dto);
                if (check) {
                    url = SUCCESS;
                }
            } else {
                request.setAttribute("INVALID", errorObj);
            }

        } catch (Exception e) {
            log("ERROR at PostArticleController: " + e.getMessage());
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
