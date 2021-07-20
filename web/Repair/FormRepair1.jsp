<%@page import="Models.State"%>
<%@page import="Models.Repair"%>
<%@page import="Models.Brand"%>
<%@page import="Models.Model"%>
<%@page import="Models.Device"%>
<%@page import="Models.Client"%>
<%

    Repair repair = null;
    if (session.getAttribute("RepairObject") != null) {
        repair = (Repair) session.getAttribute("RepairObject");
    }

%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <%if (repair != null) {
        %>
        <title>Actualizar la reparación No. <%out.print(repair.getIdReparaciones());%></title>
        <%
        } else {
        %>
        <title>Agregar una reparación</title>

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
                $('.datepicker').pickadate({
                    selectMonths: true, // Creates a dropdown to control month
                    selectYears: 15, // Creates a dropdown of 15 years to control year,
                    today: 'Today',
                    clear: 'Clear',
                    close: 'Ok',
                    closeOnSelect: false // Close upon selecting a date,
                });
                $('select').material_select();
                $("#FormUser").validate({
                    rules: {
                        Precio: {
                            required: true,
                            number: true
                        },
                        Descripcion: {
                            required: true
                        },
                        Fecha: {
                            required: true
                        },
                        Client: {
                            required: true
                        },
                        Device: {
                            required: true
                        },
                        State: {
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
                <form  class="col s12" id="FormUser" method="post" action="../ServletRepair">
                    <input type="hidden" value="2" name="BtnNewRepair">
                    <input type="hidden" value="<%if (repair != null) {
                            out.print(repair.getIdReparaciones());
                        }%>" name="idRepair">
                    <br>
                    <br>
                    <div class="row">
                        <%if (repair != null) {
                        %>
                        <h3 class="title">Actualizar Reparación </h3>
                        <%
                        } else {
                        %>
                        <h3 class="title">Registrar Reparación</h3>

                        <%
                            }%>

                        <br>
                        <br>
                        <div class="input-field col s6">
                            <input id="Precio" name="Precio" type="text" class="validate" value="<%if (repair != null) {
                                    out.print(repair.getPrecio());
                                }%>" required>
                            <label for="Precio">Precio</label>
                        </div>
                        <div class="input-field col s6">
                            <input id="Descripcion" name="Descripcion" type="text" class="validate" value="<%if (repair != null) {
                                    out.print(repair.getDescripcion());
                                }%>" required>
                            <label for="Descripcion">Descripción</label>
                        </div>
                        <div class="input-field col s6">
                            <input id="Fecha" name="Fecha" type="text" class="datepicker" value="<%if (repair != null) {
                                    out.print(repair.getFechaEntrega());
                                }%>" required>
                            <label for="Fecha">Fecha de entrega</label>
                        </div>
                        <%if (repair != null) {
                        %>
                        <input type="hidden" name="Client"  value="<%=repair.getClient().getIdClientes()%>" />
                        <div class="input-field col s6">
                            <select class="icons"   required disabled>
                                <option value=""  selected>Cliente</option>
                                <jsp:useBean id="ClientController"  scope="page"  class="Controller.ClientController"/>
                                <%if (ClientController.getClientList() != null && ClientController.getClientList().size() > 0) {
                                        for (Client client : ClientController.getClientList()) {
                                %>
                                <option value="<%out.print(client.getIdClientes());%>" <%if (client.getIdClientes() == repair.getClient().getIdClientes()) {
                                        out.print("selected");
                                    }%>><%out.print(client.getNombres() + " " + client.getApellidos());%></option>
                                <%
                                        }
                                    }%>

                            </select>
                        </div>                    

                        <%
                        } else {
                        %>
                         
                        <div class="input-field col s6">
                            <select class="icons"  name="Client" required disabled>
                                <option value=""  selected>Cliente</option>
                                <jsp:useBean id="ClientController1"  scope="page"  class="Controller.ClientController"/>
                                <%if (ClientController1.getClientList() != null && ClientController1.getClientList().size() > 0) {
                                        for (Client client : ClientController1.getClientList()) {
                                %>
                                <option value="<%out.print(client.getIdClientes());%>"><%out.print(client.getNombres() + " " + client.getApellidos());%></option>
                                <%
                                        }
                                    }%>

                            </select>
                        </div>  

                        <%
                            }%>    


                        <%if (repair != null) {
                        %>
                        <input type="hidden" name="Device" value="<%=repair.getDevice().getIdDispositivos()%>" />
                        <div class="input-field col s6">
                            <select class="icons"  required disabled>
                                <jsp:useBean id="DeviceController1"  scope="page"  class="Controller.DeviceController"/>
                                <%if (DeviceController1.getDeviceList() != null && DeviceController1.getDeviceList().size() > 0) {
                                        for (Device device : DeviceController1.getDeviceList()) {
                                %>
                                <option value="<%out.print(device.getIdDispositivos());%>" <%if (device.getIdDispositivos() == repair.getDevice().getIdDispositivos()) {
                                        out.print("selected");
                                    }%>><%out.print(device.getIMEI() + " - " + device.getBrand().getNombreMarcas());%></option>
                                <%
                                        }
                                    }%>

                            </select>
                        </div>    

                        <%
                        } else {
                        %>
                        <div class="input-field col s6">
                            <select class="icons" name="Device" required>
                                <option value="" disabled selected>Dispositivo</option>
                                <jsp:useBean id="DeviceController"  scope="page"  class="Controller.DeviceController"/>
                                <%if (DeviceController.getDeviceList2() != null && DeviceController.getDeviceList2().size() > 0) {
                                        for (Device device : DeviceController.getDeviceList2()) {
                                %>
                                <option value="<%out.print(device.getIdDispositivos());%>"><%out.print(device.getIMEI() + " - " + device.getBrand().getNombreMarcas());%></option>
                                <%
                                        }
                                    }%>

                            </select>
                        </div>                  

                        <%

                            }%>           



                    </div>


                    <%if (repair != null) {
                    %>
                    <div class="input-field col s6">
                        <jsp:useBean id="StateController"  scope="page"  class="Controller.StateController"/>
                        <select class="icons"  name="State" required>
                            <option value="" disabled selected>Estado</option>
                            <%if (StateController.getStateList() != null && StateController.getStateList().size() > 0) {
                                    for (State state : StateController.getStateList()) {
                            %>
                            <option value="<%out.print(state.getIdEstado());%>" <%if (state.getNombreEstado().equals(repair.getState().getNombreEstado())) {
                                        out.print("selected");
                                    }%>><%out.print(state.getNombreEstado());%></option>
                            <%
                                    }
                                }%>

                        </select>
                    </div>

                    <%
                    } else {
                    %>
                    <div class="input-field col s6">
                        <jsp:useBean id="StateController1"  scope="page"  class="Controller.StateController"/>
                        <select class="icons" name="State" id="State" required>
                            <option value="" disabled selected>Estado</option>
                            <%if (StateController1.getStateList() != null && StateController1.getStateList().size() > 0) {
                                    for (State state : StateController1.getStateList()) {
                            %>
                            <option value="<%out.print(state.getIdEstado());%>" ><%out.print(state.getNombreEstado());%></option>
                            <%
                                    }
                                }%>

                        </select>
                    </div>

                    <%
                        }%>    

                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <div style="margin-right:120px;" class="button-row">
                        <%if (repair != null) {
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