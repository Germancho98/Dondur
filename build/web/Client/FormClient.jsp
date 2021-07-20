<%@page import="Models.Client"%>
<%

    Client client = null;
    if (session.getAttribute("ClientObject") != null) {
        client = (Client) session.getAttribute("ClientObject");
    }

%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <%if (client != null) {
        %>
        <title>Actualizar el cliente: <%out.print(client.getNombres());%></title>
        <%
        } else {
        %>
        <title>Agregar un cliente</title>

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
                        Name: {
                            required: true
                        },
                        Apellidos: {
                            required: true
                        },
                        NoDocumento: {
                            required: true,
                            number: true
                        },
                        Phone: {
                            required: true,
                            number: true
                        },
                        Email: {
                            required: true,
                            email: true
                        },
                        DocumentType: {
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
                <form  class="col s12" id="FormUser" method="post" action="../ClientServlet">
                    <input type="hidden" value="2" name="BtnNewClient">
                    <input type="hidden" value="<%if (client != null) {
                            out.print(client.getIdClientes());
                        }%>" name="idClient">
                    <br>
                    <br>
                    <div class="row">
                        <%if (client != null) {
                        %>
                        <h3 class="title">Actualizar Cliente </h3>
                            <%
                            } else {
                            %>
                        <h3 class="title">Registrar Cliente</h3>

                        <%
                            }%>
                        
                        <br>
                        <br>
                        <div class="input-field col s6">
                            <input id="Name" name="Name" type="text" class="validate" value="<%if (client != null) {
                                    out.print(client.getNombres());
                                }%>" required>
                            <label for="Name">Nombre</label>
                        </div>
                        <div class="input-field col s6">
                            <input id="Apellidos" name="Apellidos" type="text" value="<%if (client != null) {
                                    out.print(client.getApellidos());
                                }%>" class="validate" required>
                            <label for="Apellidos">Apellido</label>
                        </div>
                        <div class="input-field col s6">
                            <input id="NoDocumento" name="NoDocumento" type="text" value="<%if (client != null) {
                                    out.print(client.getNumeroDocumento());
                                }%>" class="validate" required>
                            <label for="NoDocumento">Documento</label>
                        </div>
                        <div class="input-field col s6">
                            <input id="Phone" type="text" name="Phone" value="<%if (client != null) {
                                    out.print(client.getTelefono());
                                }%>" class="validate" required>
                            <label for="Phone">Telefono</label>
                        </div>

                        <div class="input-field col s6">
                            <input id="Email" name="Email" type="text" value="<%if (client != null) {
                                    out.print(client.getCorreoElectronico());
                                }%>" class="validate" required>
                            <label for="Email">Correo Electronico</label>
                        </div>
                        <div class="input-field col s6">
                            <select class="icons" name="DocumentType" required>
                                <option value="" disabled selected>Tipo de documento</option>
                                <option value="1" >Tarjeta de identidad</option>
                                <option value="2" >Cédula</option>

                            </select>
                        </div>


                    </div>

                    <div style="margin-right:120px;" class="button-row">
                        <%if (client != null) {
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