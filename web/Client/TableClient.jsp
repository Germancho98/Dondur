

<%@page import="Models.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>Lista de Clientes</title>
        <link rel="shortcut icon" href="../Img/DondurIcon.ico" type="image/vnd.microsoft.icon">
        <!--Incio CSS-->
        <link rel="stylesheet" href="../Css/normalize.css">
        <link rel="stylesheet" href="../Css/materialize.min.css">    
        <link rel="stylesheet" href="../Css/material-design-iconic-font.min.css">    
        <link rel="stylesheet" href="../Css/jquery.mCustomScrollbar.css">    
        <link rel="stylesheet" href="../Css/sweetalert.css">    
        <link rel="stylesheet" href="../Css/style.css"> 
        <link rel="stylesheet" href="../Css/StyleForm.css">
        <link href="../assets/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="../assets/css/fresh-bootstrap-table.css" rel="stylesheet" type="text/css"/>

        <link href="../Css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
        <!--Fin CSS-->

        <!--Incio JS-->
        <script src="../Js/sweetalert.min.js"></script>
        <script src="../Js/jquery-2.2.0.min.js" type="text/javascript"></script>
        <script src="../Js/materialize.min.js"></script>
        <script src="../Js/jquery.mCustomScrollbar.concat.min.js"></script>
        <script src="../Js/main.js"></script> 
        <!--Fin Js-->
        <!--Inicio Style Sliter CSS-->

        <!--Fin Style Sliter CSS-->
        <style>
            .pagination li.active {
                background-color: #ffffff;
            }

            input:not([type]), input[type=text], input[type=password], input[type=email], input[type=url], input[type=time], input[type=date], input[type=datetime-local], input[type=tel], input[type=number], input[type=search], textarea.materialize-textarea {
                background-color: #000000;
                border: 2px solid #000000;
                border-radius: 30px;
                font-weight: 600;
                color: #666666;
                padding: 8px 16px;
                height: 40px;
                -webkit-box-shadow: none;
                box-shadow: none;
                opacity: 0.7;
                filter: alpha(opacity=70);
                font-size: 1.3rem; 
                box-sizing: inherit;
            }


            input:not([type]), input[type=text], input[type=password], input[type=email], input[type=url], input[type=time], input[type=date], input[type=datetime-local], input[type=tel], input[type=number], input[type=search], textarea.materialize-textarea:hover {
                border: 2px solid #000000;

            }

            .remove{


                color: rgba(0, 0, 0, 0.8);
            }
        </style>
    </head>
    <body>
        <jsp:include page="../Templates/GetMenu.jsp" />

        <!--Contenido Dondur-->
        <div class="content">
            <jsp:include page="../Templates/Messages.jsp" />
            <div class="fresh-table full-color-orange">
                <!--    Available colors for the full background: full-color-blue, full-color-azure, full-color-green, full-color-red, full-color-orange                  
                        Available colors only for the toolbar: toolbar-color-blue, toolbar-color-azure, toolbar-color-green, toolbar-color-red, toolbar-color-orange
                -->


                <table id="fresh-table" class="table">
                    <center><h3 style="right:">Lista de Clientes</h3></center>

                    <thead>
                    <th data-field="id">ID</th>
                    <th data-field="Nombre" data-sortable="true">Nombre</th>
                    <th data-field="Apellidos" data-sortable="true">Apellidos</th>
                    <th data-field="Correo" data-sortable="true">Correo</th>
                    <th data-field="Numero de documento">Numero de documento</th>
                    <th data-field="Acciones">Acciones</th>
                    </thead>
                    <tbody>
                        <jsp:useBean id="ClientController"  scope="page"  class="Controller.ClientController"/>
                        <%
                            if (ClientController.getClientList() != null && ClientController.getClientList().size() > 0) {
                                for (Client client : ClientController.getClientList()) {

                        %>

                        <tr>
                            <td><%out.print(client.getIdClientes());%></td>
                            <td><%out.print(client.getNombres());%></td>
                            <td><%out.print(client.getApellidos());%></td>
                            <td><%out.print(client.getCorreoElectronico());%></td>
                            <td><%out.print(client.getNumeroDocumento());%></td>
                            <td>
                                <a href="../ClientServlet?idtoUpdate=<%out.print(client.getIdClientes());%>" title="Editar" class="NavLateral-DropDown  waves-effect waves-light"><i class="zmdi zmdi-edit zmdi-hc-fw"></i></a>

                            </td>
                        </tr>

                        <%                }

                            }

                        %>
                    </tbody>
                </table>
            </div>

        </div>
        <!--fin Contenido Dondur-->

    </body>
    <script type="text/javascript" src="../assets/js/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" src="../assets/js/bootstrap.js"></script>
    <script type="text/javascript" src="../assets/js/bootstrap-table.js"></script>

    <script type="text/javascript">
        var $table = $('#fresh-table'),
                $alertBtn = $('#alertBtn'),
                full_screen = false;

        $().ready(function () {
            $table.bootstrapTable({
                toolbar: ".toolbar",
                search: true,
                pagination: true,
                striped: true,
                pageSize: 10,
                pageList: [10, 25, 50, 100],
                formatShowingRows: function (pageFrom, pageTo, totalRows) {
                    //do nothing here, we don't want to show the text "showing x of y from..." 
                },
                formatRecordsPerPage: function (pageNumber) {
                    return pageNumber + " ";
                },
                icons: {
                    refresh: 'fa fa-refresh',
                    toggle: 'fa fa-th-list',
                    columns: 'fa fa-columns',
                    detailOpen: 'fa fa-plus-circle',
                    detailClose: 'fa fa-minus-circle'
                }
            });


            $(window).resize(function () {
                $table.bootstrapTable('resetView');
            });


            window.operateEvents = {
                'click .like': function (e, value, row, index) {
                    alert('You click like icon, row: ' + JSON.stringify(row));
                    console.log(value, row, index);
                },
                'click .edit': function (e, value, row, index) {
                    alert('You click edit icon, row: ' + JSON.stringify(row));
                    console.log(value, row, index);
                },
                'click .remove': function (e, value, row, index) {
                    $table.bootstrapTable('remove', {
                        field: 'id',
                        values: [row.id]
                    });

                }
            };

            $alertBtn.click(function () {
                alert("You pressed on Alert");
            });

        });


        function operateFormatter(value, row, index) {
            return [
                '<a rel="tooltip" title="Like" class="table-action like" href="javascript:void(0)" title="Like">',
                '<i class="fa fa-heart"></i>',
                '</a>',
                '<a rel="tooltip" title="Edit" class="table-action edit" href="javascript:void(0)" title="Edit">',
                '<i class="fa fa-edit"></i>',
                '</a>',
                '<a rel="tooltip" title="Remove" class="table-action remove" href="javascript:void(0)" title="Remove">',
                '<i class="fa fa-remove"></i>',
                '</a>'
            ].join('');
        }


    </script>
</html>