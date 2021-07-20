<%@page import="Models.UserEntity"%>
<%

    UserEntity user = null;
    if (session.getAttribute("UserObject") != null) {
        user = (UserEntity) session.getAttribute("UserObject");
    }

%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <%if (user != null) {

        %>
        <title>Actualizar el empleado :<%out.print(user.getNombre()); %></title>

        <%
        } else {

        %>
        <title>Agregar un empleado</title>

        <%}%>

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
                        },
                        Role: {
                            required: true
                        },
                        UserName: {
                            required: true
                        }
                    },
                    errorPlacement: function (error, element) {
                        return true;
                    }
                });

            });

            function SendForm() {
                if ($('#Confirmpassword').val() != '' && $('#password').val() == $('#Confirmpassword').val()) {
                    $("#FormUser").submit();

                }
                else {
                    $("#password").css("border-color", "red");
                    $("#Confirmpassword").focus();
                    $("#Confirmpassword").css("border-color", "red");
                }

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
                <form  class="col s12" id="FormUser" method="post" action="../UserServlet">
                    <input type="hidden" value="2" name="BtnNewUser">
                    <input type="hidden" value="<%if (user != null) {
                            out.print(user.getIdUsuario());
                        }%>" name="idUser">
                    <div class="row">
                        <%if (user != null) {

                        %>
                        <h3 class="title">Actualizar Empleado</h3>

                        <%        } else {

                        %>
                        <h3 class="title">Registrar Empleado</h3>

                        <%}%>

                        <br>
                        <div class="input-field col s6">
                            <input id="Name" name="Name" type="text" class="validate" value="<%if (user != null) {
                                    out.print(user.getNombre());
                                }%>" required>
                            <label for="Name">Nombre</label>
                        </div>
                        <div class="input-field col s6">
                            <input id="Apellidos" name="Apellidos" type="text" value="<%if (user != null) {
                                    out.print(user.getApellidos());
                                }%>" class="validate" required>
                            <label for="Apellidos">Apellido</label>
                        </div>
                        <div class="input-field col s6">
                            <input id="NoDocumento" name="NoDocumento" type="text" value="<%if (user != null) {
                                    out.print(user.getNoDocumento());
                                }%>" class="validate" required>
                            <label for="NoDocumento">Documento</label>
                        </div>
                        <div class="input-field col s6">
                            <input id="Phone" type="text" name="Phone" value="<%if (user != null) {
                                    out.print(user.getTelefono());
                                }%>" class="validate" required>
                            <label for="Phone">Telefono</label>
                        </div>

                        <div class="input-field col s6">
                            <input id="Email" name="Email" type="text" value="<%if (user != null) {
                                    out.print(user.getEmail());
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

                    <div class="row">
                        <div class="input-field col s12">
                            <select class="icons" name="Role" required>
                                <option value="" disabled selected>Elige un rol</option>
                                <option value="1" data-icon="../Img/icon2.jpg" class="circle">Administrador</option>
                                <option value="2" data-icon="../Img/icon1.jpg" class="circle">Técnico</option>

                            </select>
                        </div>

                        <div class="input-field col s12">
                            <input  id="UserName" type="text" name="UserName" value="<%if (user != null) {
                                    out.print(user.getUserName());
                                }%>" class="validate" required/>
                            <label for="UserName">Usuario</label>
                        </div>
                        <div class="input-field col s12">
                            <input id="password" type="password" class="validate" required/>
                            <label for="password">Contraseña</label>
                        </div>
                        <div class="input-field col s12">
                            <input id="Confirmpassword" type="password" name="Password" class="validate" required>
                            <label for="Confirmpassword">Confirmar Contraseña</label>
                        </div>
                        <div class="switch">
                            <label>
                                Inactivo
                                <input type="checkbox" name="State">
                                <span class="lever"></span>
                                Activo
                            </label>
                        </div>
                    </div>

                    <div style="margin-right:120px;" class="button-row">
                         <%if (user != null) {
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