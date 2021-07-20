/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controller.BrandController;
import Controller.DeviceController;
import Controller.ModelController;
import Models.Device;
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
@WebServlet(name = "DeviceServlet", urlPatterns = {"/DeviceServlet"})
public class DeviceServlet extends HttpServlet {
    
    DeviceController deviceController = new DeviceController();
    ModelController modelController = new ModelController();
    BrandController brandController = new BrandController();

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
        deviceController = new DeviceController();
        if (request.getParameter("idtoUpdate") != null) {
            Device device = new Device();
            device = deviceController.getDeviceById(Long.parseLong(request.getParameter("idtoUpdate")));
            request.getSession().setAttribute("DeviceObject", device);
            request.getSession().setAttribute("Messages", deviceController.getListMessages());
            response.sendRedirect("Devices/FormDevice.jsp");
        } else if (request.getParameter("idtoDelete") != null) {
            response.sendRedirect("Devices/FormDevice.jsp");
        } else {
            request.getSession().setAttribute("DeviceObject", null);
            response.sendRedirect("Devices/FormDevice.jsp");
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
        if (request.getParameter("BtnNewDevice") != null) {
            try {
                Device device = new Device();
                boolean isUpdate = false;
                if (request.getParameter("idDevice") != null && !"".equals(request.getParameter("idDevice"))) {
                    device = deviceController.getDeviceById(Long.parseLong(request.getParameter("idDevice")));
                    isUpdate = true;
                } else {
                    device.setIdDispositivos(0L);
                }
                device.setIMEI(request.getParameter("IMEI"));
                device.setBrand(brandController.getBrandById(Long.parseLong(request.getParameter("Brand"))));
                device.setModel(modelController.getModelById(Long.parseLong(request.getParameter("Model"))));
                
                if (deviceController.SaveDevice(device)) {
                    request.getSession().setAttribute("Messages", deviceController.getListMessages());
                    response.sendRedirect("Devices/TableDevices.jsp");
                    
                } else {
                    request.getSession().setAttribute("Messages", deviceController.getListMessages());
                    response.sendRedirect("Devices/TableDevices.jsp");
                }
            } catch (Exception e) {
                deviceController.AddMessage("Ha ocurrido un error: " + e.getMessage(), MessageType.Error);
                request.getSession().setAttribute("Messages", deviceController.getListMessages());
                response.sendRedirect("Devices/TableDevices.jsp");
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
