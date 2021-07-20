
<%@page import="Models.UserEntity"%>
<%@page import="Models.UserEntity"%>
<%
    if (session.getAttribute("userSession") != null) {

        UserEntity user = (UserEntity) session.getAttribute("userSession");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>Bienvenido a Dondur</title>
 <link rel="shortcut icon" href="../Img/DondurIcon.ico" type="image/vnd.microsoft.icon">



        <!--Incio CSS-->
        <link rel="stylesheet" href="../Css/normalize.css">
        <link rel="stylesheet" href="../Css/materialize.min.css">    
        <link rel="stylesheet" href="../Css/material-design-iconic-font.min.css">    
        <link rel="stylesheet" href="../Css/jquery.mCustomScrollbar.css">    
        <link rel="stylesheet" href="../Css/sweetalert.css">    
        <link rel="stylesheet" href="../Css/style.css"> 
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="../Css/StyleHome/demo.css" />
        <link rel="stylesheet" type="text/css" href="../Css/StyleHome/style1.css" />
        <link href="../Css/jquery.fancybox.min.css" rel="stylesheet" type="text/css"/>
        <!--Fin CSS-->
        <!--Incio JS-->
        <script src="../Js/sweetalert.min.js"></script>
        <script src="../Js/jquery-2.2.0.min.js" type="text/javascript"></script>
        <script>window.jQuery || document.write('<script src="../Js/jquery-2.2.0.min.js"><\/script>')</script>
        <script src="../Js/materialize.min.js"></script>
        <script src="../Js/jquery.mCustomScrollbar.concat.min.js"></script>
        <script src="../Js/main.js"></script> 

        <!--Fin Js-->
    </head>
    <body>
        <jsp:include page="../Templates/GetMenu.jsp" />

        <script type="text/javascript" src="../Js/JsHome/modernizr.custom.53451.js"></script>
        <script type="text/javascript" src="../Js/JsHome/jquery.gallery.js"></script>
        <script src="../Js/jquery.fancybox.min.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(function () {
                $('#dg-container').gallery({
                    autoplay: true
                });
            });
        </script>
        <div style="margin-top: 90px;" class="container">
            <header style="">
                <h1>BIENVENIDO A DONDUR    <span> <%if (user != null) {
                            out.print(user.getNombre());
                        }%></span></h1>
            </header>
            <section id="dg-container" class="dg-container">
                <div class="dg-wrapper">
                    <a href="../Img/ImageSliterHome/1.jpg" data-fancybox><img src="../Img/ImageSliterHome/1.jpg" alt="image01"><div></div></a>
                    <a href="../Img/ImageSliterHome/2.jpg" data-fancybox><img src="../Img/ImageSliterHome/2.jpg" alt="image02"><div></div></a>
                    <a href="../Img/ImageSliterHome/3.jpg" data-fancybox><img src="../Img/ImageSliterHome/3.jpg" alt="image03"><div></div></a>
                    <a href="../Img/ImageSliterHome/4.jpg" data-fancybox><img src="../Img/ImageSliterHome/4.jpg" alt="image04"><div></div></a>
                    <a href="../Img/ImageSliterHome/5.jpg" data-fancybox><img src="../Img/ImageSliterHome/5.jpg" alt="image05"><div></div></a>
                    <a href="../Img/ImageSliterHome/6.jpg" data-fancybox><img src="../Img/ImageSliterHome/6.jpg" alt="image06"><div></div></a>
                    <a href="../Img/ImageSliterHome/7.jpg" data-fancybox><img src="../Img/ImageSliterHome/7.jpg" alt="image07"><div></div></a>
                    <a href="../Img/ImageSliterHome/8.jpg" data-fancybox><img src="../Img/ImageSliterHome/8.jpg" alt="image08"><div></div></a>
                    <a href="../Img/ImageSliterHome/9.jpg" data-fancybox><img src="../Img/ImageSliterHome/9.jpg" alt="image09"><div></div></a>
                    <a href="../Img/ImageSliterHome/10.jpg" data-fancybox><img src="../Img/ImageSliterHome/10.jpg" alt="image10"><div></div></a>
                    <a href="../Img/ImageSliterHome/11.jpg" data-fancybox><img src="../Img/ImageSliterHome/11.jpg" alt="image11"><div></div></a>
                    <a href="../Img/ImageSliterHome/12.jpg" data-fancybox><img src="../Img/ImageSliterHome/12.jpg" alt="image12"><div></div></a>
                </div>
            </section>
        </div>
    </section>
    <!--fin Contenido Dondur-->

</body>
</html>


<%
} else {
%>
<script>location.replace("../index.jsp");</script>
<%
        response.sendRedirect("../index.jsp");
    }

%>