<%@page import="Models.Brand"%>
<%@page import="Models.Model"%>
<%@page import="Models.Device"%>
<%@page import="Models.Client"%>
<%

    Device device = null;
    if (session.getAttribute("DeviceObject") != null) {
        device = (Device) session.getAttribute("DeviceObject");
    }

%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <%if (device != null) {
        %>
        <title>Actualizar el equipo No. <%out.print(device.getIdDispositivos());%></title>
        <%
        } else {
        %>
        <title>Agregar un equipo</title>

        <%
            }%>

        <!--Incio CSS-->
        <link rel="shortcut icon" href="../Img/DondurIcon.ico" type="image/vnd.microsoft.icon">
        <link rel="stylesheet" href="../Css/normalize.css">
        <link rel="stylesheet" href="../Css/materialize.min.css">    
        <link rel="stylesheet" href="../Css/material-design-iconic-font.min.css">    
        <link rel="stylesheet" href="../Css/jquery.mCustomScrollbar.css">    
        <link rel="stylesheet" href="../Css/sweetalert.css">    
        <link rel="stylesheet" href="../Css/style.css"> 
        <link rel="stylesheet" href="../Css/StyleForm.css">
        <!--Fin CSS-->
        <!--Incio JS-->
        <script src="../Js/sweetalert.min.js"></script>
        <script src="../Js/jquery-2.2.0.min.js" type="text/javascript"></script>

        <script>window.jQuery || document.write('<script src="../Js/jquery-2.2.0.min.js"><\/script>')</script>
        <script src="../Js/materialize.min.js"></script>
        <script src="../Js/jquery.mCustomScrollbar.concat.min.js"></script>
        <script src="../Js/main.js"></script> 
        <!--Fin Js-->
        <!--Inicio Style Sliter CSS-->
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="../Css/StyleHome/demo.css" />
        <link rel="stylesheet" type="text/css" href="../Css/StyleHome/style.css" />
        <script type="text/javascript" src="../Js/JsHome/modernizr.custom.53451.js"></script>
        <script type="text/javascript" src="../Js/JsHome/jquery.gallery.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('select').material_select();
                $("#FormUser").validate({
                    rules: {
                        IMEI: {
                            required: true
                        },
                        Model: {
                            required: true
                        },
                        Brand: {
                            required: true
                        }
                    },
                    errorPlacement: function (error, element) {
                        return true;
                    }
                });

            });

            function SendForm() {
                $("#FormUser").submit();

            }
        </script>
        <!--Fin Style Sliter CSS-->
    </head>
    <body>
        <jsp:include page="../Templates/GetMenu.jsp" />
        <!--Contenido Dondur-->
        <div class="container">
            <div class="Forms">
                <jsp:include page="../Templates/Messages.jsp" />
                <script src="../Js/jquery.validate.js" type="text/javascript"></script>
                <form  class="col s12" id="FormUser" method="post" action="../DeviceServlet">
                    <input type="hidden" value="2" name="BtnNewDevice">
                    <input type="hidden" value="<%if (device != null) {
                            out.print(device.getIdDispositivos());
                        }%>" name="idDevice">
                    <br>
                    <br>
                    <div class="row">
                        <%if (device != null) {
                        %>
                        <h3 class="title">Actualizar Equipo </h3>
                        <%
                        } else {
                        %>
                        <h3 class="title">Registrar Equipo</h3>

                        <%
                            }%>

                        <br>
                        <br>
                        <div class="input-field col s6">
                            <input id="IMEI" name="IMEI" type="text" class="validate" value="<%if (device != null) {
                                    out.print(device.getIMEI());
                                }%>" required>
                            <label for="IMEI">IMEI</label>
                        </div>

                        <div class="input-field col s6">
                            <jsp:useBean id="ModelController"  scope="page"  class="Controller.ModelController"/>
                            <select class="icons" name="Model" required>
                                <option value="" disabled selected>Modelo</option>
                                <%if (ModelController.getModelList() != null && ModelController.getModelList().size() > 0) {
                                        for (Model model : ModelController.getModelList()) {
                                %>
                                <option value="<%out.print(model.getIdModelo());%>" ><%out.print(model.getNombreModelos());%></option>
                                <%
                                        }
                                    }%>

                            </select>
                        </div>
                        <div class="input-field col s6">
                            <select class="icons" name="Brand" required>
                                <option value="" disabled selected>Marca</option>
                                <jsp:useBean id="BrandController"  scope="page"  class="Controller.BrandController"/>
                                 <%if (BrandController.getBrandList() != null && BrandController.getBrandList().size() > 0) {
                                        for (Brand brand : BrandController.getBrandList()) {
                                %>
                                <option value="<%out.print(brand.getIdMarca());%>" ><%out.print(brand.getNombreMarcas());%></option>
                                <%
                                        }
                                    }%>

                            </select>
                        </div>


                    </div>

                    <div style="margin-right:120px;" class="button-row">
                        <%if (device != null) {
                        %>
                        <div><a href="javascript:void(0)" onclick="SendForm()" title="Actualizar"></a></div>
                            <%
                            } else {
                            %>
                        <div><a href="javascript:void(0)" onclick="SendForm()" title="Registrar"></a></div>

                        <%
                            }%>
                        <div><a href="javascript:void(0)" onclick="history.back()" title="Cancelar"></a></div>
                    </div>
                </form>
            </div>
        </div> 
        <!--fin Contenido Dondur-->

    </body>
</html>