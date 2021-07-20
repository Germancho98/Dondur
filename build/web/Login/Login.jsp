
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
    <head>
        <meta charset="UTF-8">
        <title>Login DD</title>
        <link rel="shortcut icon" href="../Img/DondurIcon.ico" type="image/vnd.microsoft.icon">
        <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
        <link href="../Css/font-awesome.css" rel="stylesheet" type="text/css"/>
        <link href="../Css/normalize.css" rel="stylesheet" type="text/css"/>
        
        <link href="../Css/StyleIndex.css" rel="stylesheet" type="text/css"/>
        <script src="../Js/prefixfree.js" type="text/javascript"></script>

    </head>
    <body>
        <div class="wrapper">
            <form class="login" method="post" id="Login">
                <img align="center" style="width: 260px; margin: 5px;" src="../Img/DondurSinFondo.gif" alt="">
                <input type="text" id="Username" name="NickName" placeholder="Usuario" autofocus required/>
                <i class="fa fa-user"></i>
                <input type="password" id="Pass" name="PassWord" placeholder="Contraseña" required/>
                <i class="fa fa-key"></i>
                <a href="../Login/Changepassword.jsp">Olvidaste tu Contraseña?</a>
                <button>
                    <i class="spinner"></i>
                    <span  class="state">Iniciar Sesión</span>
                </button>
            </form>
        </div>
        <script src="../Js/jquery-2.2.0.min.js" type="text/javascript"></script>

        <script src="../Js/JsLonginDD/LoginDD.js"></script>

    </body>
</html>
