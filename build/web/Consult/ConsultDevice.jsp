<%-- 
    Document   : ConsultDevice
    Created on : 04-sep-2017, 1:02:01
    Author     : Matthew
--%>

<%@page import="Models.Client"%>
<%@page import="Models.Repair"%>
<%@page import="Models.UserEntity"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">

    <head>
        <meta charset=utf-8>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>DONDUR</title>
        <!-- Load Roboto font -->
        <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,700&amp;subset=latin,latin-ext' rel='stylesheet' type='text/css'>
        <!-- Load css styles -->
        <link rel="stylesheet" type="text/css" href="../Css/bootstrap.css" />
        <link rel="stylesheet" type="text/css" href="../Css/bootstrap-responsive.css" />
        <link rel="stylesheet" type="text/css" href="../Css/style2.css" />
        <link rel="stylesheet" type="text/css" href="../Css/pluton.css" />
        <!--[if IE 7]>
            <link rel="stylesheet" type="text/css" href="css/pluton-ie7.css" />
        <![endif]-->
        <link rel="stylesheet" type="text/css" href="../Css/jquery.cslider.css" />
        <link rel="stylesheet" type="text/css" href="../Css/jquery.bxslider.css" />
        <link rel="stylesheet" type="text/css" href="../Css/animate.css" />
        <!-- Fav and touch icons -->
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../images/ico/apple-touch-icon-144.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../images/ico/apple-touch-icon-114.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../images/apple-touch-icon-72.png">
        <link rel="apple-touch-icon-precomposed" href="../images/ico/apple-touch-icon-57.png">
        <link rel="shortcut icon" href="../images/ico/favicon.ico">
    </head>

    <body style="color: black;">
        <div class="navbar">
            <div class="navbar-inner">
                <div class="container">
                    <a href="#" class="brand">
                        <img src="../images/logo.png" width="120" height="40" alt="Logo" />

                    </a>

                    <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <i class="icon-menu"></i>
                    </button>

                    <div class="nav-collapse collapse pull-right">
                        <ul class="nav" id="top-navigation">
                            <li class="active"><a href="../index.jsp">Inicio</a></li>
                        </ul>
                    </div>

                </div>
            </div>
        </div>
        <div class="container">
            <jsp:useBean id="RepairController"  scope="page"  class="Controller.RepairController"/>
            <%if (request.getParameter("UserId") != null && !"".equals(request.getParameter("UserId"))) {
                    Long parameter = Long.parseLong(request.getParameter("UserId"));
                    if (RepairController.getRepairListByClient(parameter) != null && RepairController.getRepairListByClient(parameter).size() > 0) {
                        Client user = RepairController.getRepairListByClient(parameter).get(0).getClient();
            %>
            <center>
                <div class="title">
                    <h1 style="color: black;">Tus Dispositivos</h1>
                    <p style="color: black;">Los Equipos Consultados se Encuentran En lista Miralos YA!.</p>
                    <h4><%out.print(user.getNombres() + " " + user.getApellidos() + " - " + user.getNumeroDocumento());%>.</h4>
                </div>
            </center>

            <%
                int cont = 1;
                boolean isActive = true;
                int contGeneral = 1;
                int size = RepairController.getRepairListByClient(parameter).size();
                for (Repair repair : RepairController.getRepairListByClient(parameter)) {

            %>
            <%if (cont == 3 || isActive) {
                    cont = 1;

            %>
            <div class="content"></div>
            <div class="price-table row-fluid">

                <% } %>

                <div class="span4 price-column">
                    <h3><%out.print(repair.getDevice().getBrand().getNombreMarcas());%></h3>
                    <ul class="list">
                        <li><strong>IMEI: </strong><%out.print(repair.getDevice().getIMEI());%></li>
                        <li><strong>Modelo: </strong><%out.print(repair.getDevice().getModel().getNombreModelos());%></li>
                        <li><strong>Código: </strong><%out.print(repair.getDevice().getIdDispositivos());%></li>
                    </ul>
                    <a class="button button-ps"><%out.print(repair.getState().getNombreEstado());%></a>
                </div>
                <%
                    cont++;
                    if (cont == 3 || contGeneral == size) {
                        isActive = false;
                        cont=1;
                %>
            </div>

            <%                    }
                contGeneral++;
                }%>
            

            <%                  } else {

            %>

            <center>
                <div class="title">
                    <h1 style="color: black;">No encontramos tu dispositivo :(</h1>
                    <p style="color: black;">Por favor consulta nuevamente más tarde ó consulta al administrador.</p>
                </div>
            </center>
            <div class="content"></div>
            <div class="price-table row-fluid">
                <div class="span4 price-column">
                    <h3>:(</h3>
                    <ul class="list">
                        <li><strong>IMEI: </strong>:(</li>
                        <li><strong>Modelo: </strong>:(</li>
                        <li><strong>Refrencia: </strong>:(</li>
                    </ul>
                    <a class="button button-ps">:(</a>
                </div>
                <div class="span4 price-column">
                    <h3>:(</h3>
                    <ul class="list">
                        <li><strong>IMEI: </strong>:(</li>
                        <li><strong>Modelo: </strong>:(</li>
                        <li><strong>Refrencia: </strong>:(</li>
                    </ul>
                    <a class="button button-ps">:(</a>
                </div>
                <div class="span4 price-column">
                    <h3>:(</h3>
                    <ul class="list">
                        <li><strong>IMEI: </strong>:(</li>
                        <li><strong>Modelo: </strong>:(</li>
                        <li><strong>Refrencia: </strong>:(</li>
                    </ul>
                    <a class="button button-ps">:(</a>
                </div>
            </div>
            <%                }
            } else {

            %>

            <center>
                <div class="title">
                    <h1 style="color: black;">No encontramos tu dispositivo :(</h1>
                    <p style="color: black;">Por favor consulta nuevamente más tarde ó consulta al administrador.</p>
                </div>
            </center>
            <div class="content"></div>
            <div class="price-table row-fluid">
                <div class="span4 price-column">
                    <h3>:(</h3>
                    <ul class="list">
                        <li><strong>IMEI: </strong>:(</li>
                        <li><strong>Modelo: </strong>:(</li>
                        <li><strong>Refrencia: </strong>:(</li>
                    </ul>
                    <a class="button button-ps">:(</a>
                </div>
                <div class="span4 price-column">
                    <h3>:(</h3>
                    <ul class="list">
                        <li><strong>IMEI: </strong>:(</li>
                        <li><strong>Modelo: </strong>:(</li>
                        <li><strong>Refrencia: </strong>:(</li>
                    </ul>
                    <a class="button button-ps">:(</a>
                </div>
                <div class="span4 price-column">
                    <h3>:(</h3>
                    <ul class="list">
                        <li><strong>IMEI: </strong>:(</li>
                        <li><strong>Modelo: </strong>:(</li>
                        <li><strong>Refrencia: </strong>:(</li>
                    </ul>
                    <a class="button button-ps">:(</a>
                </div>
            </div>


            <%            }%>

        </div>

        <br>
        <br>
    </div>
        <div style="margin-top:4.9%;" class="footer">
            <p>&copy; 2017 DONDUR <a href="#">Todos Los derechos reservados. </a>  <a href="#">  2017.</a></p>
        </div>
        <!-- Footer section end -->
        <!-- ScrollUp button start -->
        <div class="scrollup">
            <a href="#">
                <i class="icon-up-open"></i>
            </a>
        </div>
        <!-- ScrollUp button end -->
        <!-- Include javascript -->
        <script src="../Js/jquery.js"></script>
        <script type="text/javascript" src="../Js/jquery.mixitup.js"></script>
        <script type="text/javascript" src="../Js/bootstrap.js"></script>
        <script type="text/javascript" src="../Js/modernizr.custom.js"></script>
        <script type="text/javascript" src="../Js/jquery.bxslider.js"></script>
        <script type="text/javascript" src="../Js/jquery.cslider.js"></script>
        <script type="text/javascript" src="../Js/jquery.placeholder.js"></script>
        <script type="text/javascript" src="../Js/jquery.inview.js"></script>
        <!-- Load google maps api and call initializeMap function defined in app.js -->
        <script async="" defer="" type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false&callback=initializeMap"></script>
        <!-- css3-mediaqueries.js for IE8 or older -->
        <!--[if lt IE 9]>
            <script src="js/respond.min.js"></script>
        <![endif]-->
        <script type="text/javascript" src="../Js/app.js"></script>
    </body>
</html>