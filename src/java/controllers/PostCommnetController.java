/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tblComment.CommentDAO;

/**
 *
 * @author lehuuhieu
 */
@WebServlet(name = "PostCommnetController", urlPatterns = {"/PostCommnetController"})
public class PostCommnetController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String NOT_AUTHENTICATED = "LogoutController";
    private static final String SUCCESS = "DetailArticleController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String comment = request.getParameter("txtDescriptionComment");
        int id = Integer.parseInt(request.getParameter("articleId"));
        String url = ERROR;

        try {
            HttpSession session = request.getSession();
            String email = (String) session.getAttribute("email");
            if (email == null) {
                url = NOT_AUTHENTICATED;
            } else {
                CommentDAO dao = new CommentDAO();
                boolean check = dao.create(comment, email, id);
                if (check) {
                    url = SUCCESS + "?id=" + id;
                }
            }
        } catch (Exception e) {
            log("ERROR at PostCommentController: " + e.getMessage());
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
