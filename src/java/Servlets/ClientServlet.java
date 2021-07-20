/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controller.ClientController;
import Controller.UserController;
import Models.Client;
import Models.DocumentType;
import Models.Rol;
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
@WebServlet(name = "ClientServlet", urlPatterns = {"/ClientServlet"})
public class ClientServlet extends HttpServlet {

    ClientController clientController = new ClientController();

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
        clientController = new ClientController();
        if (request.getParameter("idtoUpdate") != null) {
            Client client = new Client();
            client = clientController.getClientById(Integer.parseInt(request.getParameter("idtoUpdate")));
            request.getSession().setAttribute("ClientObject", client);
            request.getSession().setAttribute("Messages", clientController.getListMessages());
            response.sendRedirect("Client/FormClient.jsp");
        } else if (request.getParameter("idtoDelete") != null) {
            response.sendRedirect("Client/FormClient.jsp");
        } else {
            request.getSession().setAttribute("ClientObject", null);
            response.sendRedirect("Client/FormClient.jsp");
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
        if (request.getParameter("BtnNewClient") != null) {
            try {
                boolean isUpdate = false;
                Client client = new Client();
                if (request.getParameter("idClient") != null && !"".equals(request.getParameter("idClient"))) {
                    client = clientController.getClientById(Integer.parseInt(request.getParameter("idClient")));
                    isUpdate = true;
                } else {

                    client.setIdClientes(0L);
                }

                if (!isUpdate && clientController.getClientByEmailAdd(request.getParameter("Email"))) {
                    clientController.AddMessage("El correo ya se encuentra registrado", MessageType.Error);
                    request.getSession().setAttribute("Messages", clientController.getListMessages());
                    response.sendRedirect("Client/FormClient.jsp");

                } else {
                    client.setApellidos(request.getParameter("Apellidos"));
                    client.setCorreoElectronico(request.getParameter("Email"));
                    client.setDocumentType(client.getDocumentType(Integer.parseInt(request.getParameter("DocumentType"))));
                    client.setNombres(request.getParameter("Name"));
                    client.setNumeroDocumento(request.getParameter("NoDocumento"));
                    client.setTelefono(Long.parseLong(request.getParameter("Phone")));
                    if (clientController.SaveClient(client)) {
                        if(!isUpdate){
                            clientController.SendEmailByUser(client, "Registro en el sistema :)");
                        }
                        request.getSession().setAttribute("Messages", clientController.getListMessages());
                        response.sendRedirect("Client/TableClient.jsp");
                    } else {
                        clientController.AddMessage("Ha ocurrido un error: ", MessageType.Error);
                        request.getSession().setAttribute("Messages", clientController.getListMessages());
                        response.sendRedirect("Client/TableClient.jsp");
                    }
                }

            } catch (Exception e) {
                clientController.AddMessage("Ha ocurrido un error: " + e.getMessage(), MessageType.Error);
                request.getSession().setAttribute("Messages", clientController.getListMessages());
                response.sendRedirect("Client/TableClient.jsp");
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
