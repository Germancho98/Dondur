<%-- 
    Document   : GetMenu
    Created on : 01-sep-2017, 23:59:28
    Author     : Matthew
--%>
<%@page import="Models.Rol"%>
<%@page import="Controller.UserController"%>
<%@page import="Models.UserEntity"%>
<%
    if (session.getAttribute("userSession") != null) {

        UserEntity user = (UserEntity) session.getAttribute("userSession");
        UserController userController = new UserController();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../Css/sweetalert.css" rel="stylesheet" type="text/css"/>
        <script src="../Js/jquery-3.2.1.min.js" type="text/javascript"></script>
        <script src="../Js/materialize.min.js" type="text/javascript"></script>
        <script src="../Js/sweetalert.min.js" type="text/javascript"></script>
        <title>JSP Page</title>
    </head>
    <body>


        <section class="NavLateral full-width">
            <div class="NavLateral-FontMenu full-width ShowHideMenu"></div>
            <div class="NavLateral-content full-width">
                <header class="NavLateral-title full-width center-align">

                </header>
                <div>  
                    <img style="width:190px; margin-top: 15px; margin-left:18%; margin-right: 30px;" src="../Img/DondurSinFondo.gif">
                </div>
                <br>
                <div class="NavLateral-Nav">
                    <ul class="full-width">
                        <li>
                            <a href="../Home/home.jsp" class="waves-effect waves-light"><i class="zmdi zmdi-desktop-mac zmdi-hc-fw"></i> INICIO</a>
                        </li>
                        <li class="NavLateralDivider"></li>
                        <li>
                            <a href="#" class="NavLateral-DropDown  waves-effect waves-light"><i class="zmdi zmdi-account-o zmdi-hc-fw"></i> <i class="zmdi zmdi-chevron-down NavLateral-CaretDown"></i> CLIENTES</a>
                            <ul class="full-width">
                                <li><a href="../Client/TableClient.jsp" class="waves-effect waves-light">LISTA DE CLIENTES</a></li>
                                <li class="NavLateralDivider"></li>
                                <li><a href="../ClientServlet" class="waves-effect waves-light">AGREGA UN CLIENTE</a></li>
                            </ul>
                        </li>
                        <%if (user.getRol() == Rol.Administrador) {
                        %>
                        <li class="NavLateralDivider"></li>
                        <li>
                            <a href="#" class="NavLateral-DropDown  waves-effect waves-light"><i class="zmdi zmdi-accounts zmdi-hc-fw"></i> <i class="zmdi zmdi-chevron-down NavLateral-CaretDown"></i> EMPLEADOS</a>
                            <ul class="full-width">
                                <li><a href="../Users/TableUser.jsp" class="waves-effect waves-light">LISTA DE EMPLEADOS</a></li>
                                <li class="NavLateralDivider"></li>
                                <li><a href="../UserServlet" class="waves-effect waves-light">AGREGA UN EMPLEADO</a></li>
                            </ul>
                        </li>

                        <%
                            }%>

                        <li class="NavLateralDivider"></li>
                        <li>
                            <a href="#" class="NavLateral-DropDown  waves-effect waves-light"><i class="zmdi zmdi-smartphone-setup zmdi-hc-fw"></i> <i class="zmdi zmdi-chevron-down NavLateral-CaretDown"></i> DISPOSITIVOS</a>
                            <ul class="full-width">
                                <li><a href="../Devices/TableDevices.jsp" class="waves-effect waves-light">LISTA DE DISPOSITIVOS</a></li>
                                <li class="NavLateralDivider"></li>
                                <li><a href="../DeviceServlet" class="waves-effect waves-light">AGREGA UN DISPOSITIVO</a></li>
                            </ul>
                        </li>
                        <li class="NavLateralDivider"></li>
                        <li>
                            <a href="#" class="NavLateral-DropDown  waves-effect waves-light"><i class="zmdi zmdi-wrench zmdi-hc-fw"></i> <i class="zmdi zmdi-chevron-down NavLateral-CaretDown"></i> SOLICITUDES DE REPARACIÓN</a>
                            <ul class="full-width">
                                <li><a href="../Repair/TableRepair.jsp" class="waves-effect waves-light">LISTA DE REPARACIONES</a></li>
                                <li class="NavLateralDivider"></li>
                                <li><a href="../ServletRepair" class="waves-effect waves-light">AGREGA UNA REPARACIÓN</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>  
            </div>  
        </section>


        <!-- Page content -->
        <section class="ContentPage full-width">
            <!-- Nav Info -->
            <div class="ContentPage-Nav full-width">
                <ul class="full-width">
                    <li><a href="#" class="tooltipped waves-effect waves-light btn-ExitSystem" data-position="bottom" data-delay="50" data-tooltip="Logout"><i class="zmdi zmdi-power"></i></a></li>
                    <li class="btn-MobileMenu ShowHideMenu"><a href="#" class="tooltipped waves-effect waves-light" data-position="bottom" data-delay="50" data-tooltip="Menu"><i class="zmdi zmdi-more-vert"></i></a></li>
                    <li style="padding:0 5px;"><%if (user != null) {
                            out.print(user.getNombre());
                        }%></li>
                    <li><figure><img src="../Img/user.png" alt="UserImage"></figure></li>

                </ul>   
            </div>
    </body>
</html>
<%if (!userController.getBolleanByPermissions(request.getRequestURI(), user)) {

%>
<script>location.replace("../index.jsp");</script>
<%        response.sendRedirect("../index.jsp");
    }

%>
<%} else {
%>
<script>location.replace("../Login/Login.jsp");</script>
<%
        response.sendRedirect("../Login/Login.jsp");
    }

%>