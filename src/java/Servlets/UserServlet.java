/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controller.UserController;
import Models.UserEntity;
import Util.MessageType;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Matthew
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {

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
        request.getSession().setAttribute("Messages", null);
        userController = new UserController();
        if (request.getParameter("idtoUpdate") != null) {
            UserEntity userEntity = new UserEntity();
            userEntity = userController.getUserById(Long.parseLong(request.getParameter("idtoUpdate")));
            request.getSession().setAttribute("UserObject", userEntity);
            request.getSession().setAttribute("Messages", userController.getListMessages());
            response.sendRedirect("Users/FormUser.jsp");
        } else if (request.getParameter("idtoDelete") != null) {
            try {
                UserEntity userEntity = new UserEntity();
                userEntity = userController.getUserById(Long.parseLong(request.getParameter("idtoDelete")));
                userEntity.setActivo(false);
                if (userController.SaveUser(userEntity)) {
                    request.getSession().setAttribute("Messages", userController.getListMessages());
                    response.sendRedirect("Users/TableUser.jsp");
                } else {
                    userController.AddMessage("Ha ocurrido un error: ", MessageType.Error);
                    request.getSession().setAttribute("Messages", userController.getListMessages());
                    response.sendRedirect("Users/TableUser.jsp");
                }

            } catch (Exception e) {
                userController.AddMessage("Ha ocurrido un error: " + e.getMessage(), MessageType.Error);
                request.getSession().setAttribute("Messages", userController.getListMessages());
                response.sendRedirect("Users/TableUser.jsp");
            }

        } else if (request.getParameter("idtoChangePass") != null && request.getParameter("code") != null) {
            UserEntity userEntity = new UserEntity();
            userEntity = userController.getUserByIdForChange(Long.parseLong(request.getParameter("idtoChangePass")));
            if (userEntity != null && userEntity.getPass().equals(request.getParameter("code"))) {
                request.getSession().setAttribute("UserObject", userEntity);
                response.sendRedirect("Login/ConfirmPassword.jsp");
            } else {
                request.getSession().setAttribute("UserObject", null);
                response.sendRedirect("index.jsp");
            }

        } else {
            request.getSession().setAttribute("UserObject", null);
            response.sendRedirect("Users/FormUser.jsp");
        }
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
        if (request.getParameter("BtnNewUser") != null) {
            try {
                userController = new UserController();
                UserEntity userEntity = new UserEntity();
                boolean isUpdate = false;
                if (request.getParameter("idUser") != null && !"".equals(request.getParameter("idUser"))) {
                    userEntity = userController.getUserById(Long.parseLong(request.getParameter("idUser")));
                    isUpdate = true;
                } else {

                    userEntity.setIdUsuario(0L);
                }

                if (!isUpdate && userController.getUserByEmailAdd(request.getParameter("Email"))) {
                    userController.AddMessage("El correo ya se encuentra registrado", MessageType.Error);
                    request.getSession().setAttribute("Messages", userController.getListMessages());
                    response.sendRedirect("Users/FormUser.jsp");

                } else {
                    String isActivo = request.getParameter("State");
                    if (isActivo == null) {
                        userEntity.setActivo(false);

                    } else {
                        userEntity.setActivo(true);
                    }

                    userEntity.setApellidos(request.getParameter("Apellidos"));
                    userEntity.setDocumentType(userEntity.getDocumentType(Integer.parseInt(request.getParameter("DocumentType"))));
                    userEntity.setEmail(request.getParameter("Email"));
                    userEntity.setNoDocumento(request.getParameter("NoDocumento"));
                    userEntity.setNombre(request.getParameter("Name"));
                    String pass = userController.GetMD5(request.getParameter("Password"));
                    userEntity.setPass(pass);
                    userEntity.setRol(userEntity.getRol(Integer.parseInt(request.getParameter("Role"))));
                    userEntity.setTelefono(Long.parseLong(request.getParameter("Phone")));
                    userEntity.setUserName(request.getParameter("UserName"));

                    if (userController.SaveUser(userEntity)) {
                        if (!isUpdate) {
                            userController.SendEmailByUser(userEntity, "Registro en el sistema.");
                        }
                        request.getSession().setAttribute("Messages", userController.getListMessages());
                        response.sendRedirect("Users/TableUser.jsp");
                    }
                }

            } catch (Exception e) {
                userController.AddMessage("Ha ocurrido un error: " + e.getMessage(), MessageType.Error);
                request.getSession().setAttribute("Messages", userController.getListMessages());
                response.sendRedirect("Users/TableUser.jsp");
            }

        } else if (request.getParameter("idUserC") != null && !"".equals(request.getParameter("idUserC"))) {
            userController = new UserController();
            UserEntity userEntity = new UserEntity();
            try {
                userEntity = userController.getUserById(Long.parseLong(request.getParameter("idUserC")));
                String pass = userController.GetMD5(request.getParameter("confirmPass"));
                userEntity.setPass(pass);
                if (userController.SaveUser(userEntity)) {
                    out.print("1");
                } else {
                    out.print("0");

                }
            } catch (Exception e) {
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
