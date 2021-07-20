

<%@page import="Models.Repair"%>
<%@page import="Models.Device"%>
<%@page import="Models.UserEntity"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>Lista de Reparaciones</title>
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

            .modal {
                background-color: transparent;
               padding: 0; 
               max-height: 100%;
               width: 100%;
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
                    <center><h3 style="right:">Lista de Reparaciones</h3></center>

                    <thead>
                    <th data-field="id">ID</th>
                    <th data-field="Cliente" data-sortable="true">Cliente</th>
                    <th data-field="Equipo" data-sortable="true">Equipo</th>
                    <th data-field="Descripcion" data-sortable="true">Descripcion</th>
                    <th data-field="Fecha de Entrega" data-sortable="true">Fecha de Entrega</th>
                    <th data-field="Estado" data-sortable="true">Estado</th>
                    <th data-field="Acciones">Acciones</th>
                    </thead>
                    <tbody>
                        <jsp:useBean id="RepairController"  scope="page"  class="Controller.RepairController"/>
                        <%
                            if (RepairController.getRepairList() != null && RepairController.getRepairList().size() > 0) {
                                for (Repair repair : RepairController.getRepairList()) {

                        %>

                        <tr>
                            <td><%out.print(repair.getIdReparaciones());%></td>
                            <td><%out.print(repair.getClient().getNombres());%></td>
                            <td><%out.print(repair.getDevice().getIMEI());%></td>
                            <td><%out.print(repair.getDescripcion());%></td>
                            <td><%out.print(repair.getFechaEntrega());%></td>
                            <td><%out.print(repair.getState().getNombreEstado());%></td>
                            <td>
                                <a href="../ServletRepair?idtoUpdate=<%out.print(repair.getIdReparaciones());%>" title="Editar" class="NavLateral-DropDown  waves-effect waves-light"><i class="zmdi zmdi-edit zmdi-hc-fw"></i></a>
                            </td>
                        </tr>

                        <%                }

                            }

                        %>
                    </tbody>
                </table>
            </div>

        </div>
    </section>
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

<div class="modal fade" id="modal-confirm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">            
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">Confirmación</h4>
            </div>            
            <div class="modal-body">
                <p>Está a punto de eliminar el elemento seleccionado. Este procedimiento es irreversible.</p>
                <p>¿Desea continuar?</p>
            </div>                
            <div class="modal-footer">
                <a class="btn btn-default boton-tabla btn-ok">Eliminar</a>
                <button type="button" class="btn btn-default boton-tabla-dos" data-dismiss="modal">Cancelar</button>

            </div>
        </div>
    </div>
</div>
</html>