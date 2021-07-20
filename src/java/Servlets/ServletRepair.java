/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controller.ClientController;
import Controller.DeviceController;
import Controller.RepairController;
import Controller.StateController;
import Models.Repair;
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
@WebServlet(name = "ServletRepair", urlPatterns = {"/ServletRepair"})
public class ServletRepair extends HttpServlet {

    RepairController repairController = new RepairController();
    ClientController clientController = new ClientController();
    DeviceController deviceController = new DeviceController();
    StateController stateController = new StateController();

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
            try {
                if (request.getParameter("BtnNewRepair") != null) {
                    Repair repair = new Repair();
                    boolean isUpdate = false;
                    if (request.getParameter("idRepair") != null && !"".equals(request.getParameter("idRepair"))) {

                        repair = repairController.getRepairById(Long.parseLong(request.getParameter("idRepair")));
                        isUpdate = true;
                    } else {
                        repair.setIdReparaciones(0L);

                    }
                    UserEntity CurrentUser = new UserEntity();
                    if (request.getSession().getAttribute("userSession") != null) {
                        CurrentUser = (UserEntity) request.getSession().getAttribute("userSession");
                    }

                    repair.setDescripcion(request.getParameter("Descripcion"));
                    repair.setFechaEntrega(request.getParameter("Fecha"));
                    repair.setPrecio(request.getParameter("Precio"));
                    repair.setClient(clientController.getClientById(Integer.parseInt(request.getParameter("Client"))));
                    repair.setUserEntity(CurrentUser);
                    repair.setDevice(deviceController.getDeviceById(Long.parseLong(request.getParameter("Device"))));
                    repair.setState(stateController.getStateById(Long.parseLong(request.getParameter("State"))));
                    if (repairController.SaveRepair(repair)) {
                        request.getSession().setAttribute("Messages", repairController.getListMessages());
                        response.sendRedirect("Repair/TableRepair.jsp");
                    } else {
                        repairController.AddMessage("Ha ocurrido un error ", MessageType.Error);
                        request.getSession().setAttribute("Messages", repairController.getListMessages());
                        response.sendRedirect("Repair/TableRepair.jsp");
                    }
                }
            } catch (Exception e) {
                repairController.AddMessage("Ha ocurrido un error: " + e.getMessage(), MessageType.Error);
                request.getSession().setAttribute("Messages", repairController.getListMessages());
                response.sendRedirect("Repair/TableRepair.jsp");
            }

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
        repairController = new RepairController();
        if (request.getParameter("idtoUpdate") != null) {
            Repair repair = new Repair();
            repair = repairController.getRepairById(Long.parseLong(request.getParameter("idtoUpdate")));
            request.getSession().setAttribute("RepairObject", repair);
            request.getSession().setAttribute("Messages", repairController.getListMessages());
            response.sendRedirect("Repair/FormRepair1.jsp");
        } else if (request.getParameter("idtoDelete") != null) {
            response.sendRedirect("Repair/FormRepair1.jsp");
        } else {
            request.getSession().setAttribute("RepairObject", null);
            response.sendRedirect("Repair/FormRepair1.jsp");
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
