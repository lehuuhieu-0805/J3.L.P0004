/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tblUser.UserDAO;
import tblUser.UserDTO;
import tblUser.UserError;

/**
 *
 * @author lehuuhieu
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/RegisterController"})
public class RegisterController extends HttpServlet {
    
    private static final String ERROR = "error.jsp";
    private static final String LOGIN = "login.jsp";
    private static final String INVALID = "register.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String url = ERROR;
        UserDAO dao = new UserDAO();
        try {
            String email = request.getParameter("txtEmail");
            String name = request.getParameter("txtName");
            String password = request.getParameter("txtPassword");
            String confirmPassword = request.getParameter("txtConfirmPassword");
            
            boolean valid = true;
            
            UserError errorObj = new UserError();
            
            if (email.length() == 0) {
                url = INVALID;
                valid = false;
                errorObj.setEmailError("Email can't be blank");
            } else {
                if(!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")){
                    url = INVALID;
                    valid = false;
                    errorObj.setEmailError("Email not correct format");
                }
            }
            if (password.length() == 0) {
                url = INVALID;
                valid = false;
                errorObj.setPasswordError("Password can't be blank");
            }
            if (name.length() == 0) {
                url = INVALID;
                valid = false;
                errorObj.setNameError("Name can't be blank");
            }
            if (!password.equals(confirmPassword)) {
                url = INVALID;
                valid = false;
                errorObj.setConfirmPasswordError("Confirm password not match");
            }
            
            if (valid) {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                byte[] hash = messageDigest.digest(password.getBytes(StandardCharsets.UTF_8));
                
                String encodedPassword = String.format("%064x", new BigInteger(1, hash));
                UserDTO dto = new UserDTO(email, name, encodedPassword, "member", "New");
                if (dao.create(dto)) {
                    url = LOGIN;
                }
            } else {
                request.setAttribute("INVALID", errorObj);
            }
            
        } catch (Exception e) {
            if (e.getMessage().contains("duplicate")) {
                url = INVALID;
                UserError errorObj = new UserError();
                errorObj.setEmailError("Email has existed");
                request.setAttribute("INVALID", errorObj);
            }
            log("ERROR at RegisterController: " + e.getMessage());
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
