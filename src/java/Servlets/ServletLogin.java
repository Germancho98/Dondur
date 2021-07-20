/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controller.LoginController;
import Controller.UserController;
import Models.UserEntity;
import Util.MessageType;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Matthew
 */
@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {

    LoginController loginController = new LoginController();
    UserController userController = new UserController();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

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
        HttpSession session = request.getSession(false);
        request.getSession().setAttribute("userSession", null);
        session.invalidate();
        request.getSession().invalidate();
        response.sendRedirect("index.jsp");

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
        PrintWriter out = response.getWriter();
        if (request.getParameter("NickName") != null && request.getParameter("PassWord") != null) {
            if (request.getParameter("NickName") != null && request.getParameter("PassWord") != null && !"".equals(request.getParameter("PassWord")) && !"".equals(request.getParameter("NickName"))) {
                try {
                    boolean isAutenthicated = false;

                    isAutenthicated = loginController.Authenticate(request.getParameter("NickName"), request.getParameter("PassWord"));

                    if (isAutenthicated) {
                        HttpSession session = request.getSession(true);

                        UserEntity user = loginController.getCurrentUser();
                        if (!user.isActivo()) {
                            request.getSession().setAttribute("userSession", null);
                            out.print("2");
                        } else {
                            loginController.SaveSession(session);
                            request.getSession().setAttribute("userSession", user);
                            out.print("1");
                        }

                    } else {

                        request.getSession().setAttribute("userSession", null);
                        out.print("3");

                    }
                } catch (Exception ex) {
                    request.getSession().setAttribute("userSession", null);
                    out.print("0");
                }

            } else {
                request.getSession().setAttribute("userSession", null);
                out.print("4");
            }
        } else if (request.getParameter("Email") != null) {
            UserEntity userEntity = new UserEntity();
            try {
                userEntity = userController.getUserByEmail(request.getParameter("Email"));
                if (userEntity != null && userEntity.getEmail()!= null) {
                    userController.SendEmailChangePass(userEntity, "Recuperar contraseña");
                    out.print("1");
                    
                } else {
                    request.getSession().setAttribute("userSession", null);
                    out.print("2");
                }

            } catch (Exception e) {
                request.getSession().setAttribute("userSession", null);
                out.print("0");

            }

        }

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
