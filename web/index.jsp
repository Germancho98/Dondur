
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">

    <head>
        <meta charset=utf-8>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>DONDUR</title>
        <link rel="shortcut icon" href="Img/DondurIcon.ico" type="image/vnd.microsoft.icon">
        <!-- Load Roboto font -->
        <link href='http://fonts.googleapis.com/css?family=Roboto:400,300,700&amp;subset=latin,latin-ext' rel='stylesheet' type='text/css'>
        <!-- Load css styles -->
        <link rel="stylesheet" type="text/css" href="Css/bootstrap.css" />
        <link rel="stylesheet" type="text/css" href="Css/bootstrap-responsive.css" />
        <link rel="stylesheet" type="text/css" href="Css/style2.css" />
        <link rel="stylesheet" type="text/css" href="Css/pluton.css" />
        <!--[if IE 7]>
            <link rel="stylesheet" type="text/css" href="css/pluton-ie7.css" />
        <![endif]-->
        <link rel="stylesheet" type="text/css" href="Css/jquery.cslider.css" />
        <link rel="stylesheet" type="text/css" href="Css/jquery.bxslider.css" />
        <link rel="stylesheet" type="text/css" href="Css/animate.css" />
        <!-- Fav and touch icons -->
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="Img/ico/apple-touch-icon-144.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="Img/ico/apple-touch-icon-114.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="Img/apple-touch-icon-72.png">
        <link rel="apple-touch-icon-precomposed" href="Img/ico/apple-touch-icon-57.png">
    </head>

    <body>
        <div class="navbar">
            <div class="navbar-inner">
                <div class="container">
                    <a href="#" class="brand">
                        <img src="Img/logo.png" width="120" height="40" alt="Logo" />
                        <!-- This is website logo -->
                    </a>
                    <!-- Navigation button, visible on small resolution -->
                    <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <i class="icon-menu"></i>
                    </button>
                    <!-- Main navigation -->
                    <div class="nav-collapse collapse pull-right">
                        <ul class="nav" id="top-navigation">
                            <li class="active"><a href="#home">Home</a></li>
                            <li><a href="#service">Nuestros Servicios</a></li>
                            <li><a href="#portfolio">Su Equipo</a></li>
                            <li><a href="#about">Acerca de Nosotros</a></li>
                            <li><a href="#clients">Consultar Equipo</a></li>
                            <li><a href="Login/Login.jsp">Iniciar Sesión</a></li>
                        </ul>
                    </div>
                    <!-- End main navigation -->
                </div>
            </div>
        </div>
        <!-- Start home section -->
        <div id="home">
            <!-- Start cSlider -->
            <div id="da-slider" class="da-slider">
                <div class="triangle"></div>
                <!-- mask elemet use for masking background image -->
                <div class="mask"></div>
                <!-- All slides centred in container element -->
                <div class="container">
                    <div class="da-slide">
                        <h2>Seguridad</h2>
                        <h4>Satisfactorio</h4>
                        <p>Contamos con un sistema eficas y rapido en el que no nesecitas preguntar  solo consultar por el estado de tu equipo.</p>
                        <a href="#clients" class="da-link button">Consultar Equipo</a>
                        <div class="da-img">
                            <img src="Img/Slider03.png" width="320" alt="image03">
                        </div>
                    </div>
                    <!-- Start first slide -->
                    <div class="da-slide">
                        <h2 class="fittext2">Sistemas Que Nos Apoyan</h2>
                        <h4>Todo En Cuenta</h4>
                        <p>Buscamos ayuda contando con nuestros sistemas de trabajos rapido, por ello encontramos el SI de un buen trabajo y por lo tanto contar con los herramientas nesesarias para nuestro trabajo.</p>
                        <a href="#about" class="da-link button">Acerca de mi</a>
                        <div class="da-img">
                            <img src="Img/Slider01.png" alt="image01" width="320">
                        </div>
                    </div>
                    <!-- End first slide -->
                    <!-- Start second slide -->
                    <div class="da-slide">
                        <h2>Mantenimiento</h2>
                        <h4>Nievel #1</h4>
                        <p>Confianza es en donde se depocitan sus equipos trabajamos la mayor parte con nuestra manipulacion y buen trato hacia su dispositivo.</p>
                        <a href="#portfolio" class="da-link button">Su Equipo</a>
                        <div class="da-img">
                            <img src="Img/Slider02.png" width="320" alt="image02">
                        </div>
                    </div>
                    <!-- End second slide -->
                    <!-- Start third slide -->

                    <!-- Start third slide -->
                    <!-- Start cSlide navigation arrows -->
                    <div class="da-arrows">
                        <span class="da-arrows-prev"></span>
                        <span class="da-arrows-next"></span>
                    </div>
                    <!-- End cSlide navigation arrows -->
                </div>
            </div>
        </div>
        <!-- End home section -->
        <!-- Service section start -->
        <div class="section primary-section" id="service">
            <div class="container">
                <br>
                <br>
                <br>
                <!-- Start title section -->
                <div class="title">
                    <h1>Nuestros Servicios</h1>
                    <!-- Section's title goes here -->
                    <p>Calidad en nuestras entregas y normatividades de nuestro trabajo.</p>
                    <!--Simple description for section goes here. -->
                </div>
                <div class="row-fluid">
                    <div class="span4">
                        <div class="centered service">
                            <div class="circle-border zoom-in">
                                <img class="img-circle" src="Img/Service1.png" alt="service 1">
                            </div>
                            <h3>TRABAJO</h3>
                            <p>Organizar su equipo y dar buena fe a nuestro mantenimiento.</p>
                        </div>
                    </div>
                    <div class="span4">
                        <div class="centered service">
                            <div class="circle-border zoom-in">
                                <img class="img-circle" src="Img/Service2.png" alt="service 2" />
                            </div>
                            <h3>TRABAJO EN EQUIPO</h3>
                            <p>Trabajamos en conjunto por lo tanto el equipo pasa por los procesos que sean nesesarios para su reparacón.</p>
                        </div>
                    </div>
                    <div class="span4">
                        <div class="centered service">
                            <div class="circle-border zoom-in">
                                <img class="img-circle" src="Img/Service3.png" alt="service 3">
                            </div>
                            <h3>GARANTIZAMOS NUESTRO TRABAJO</h3>
                            <p>Nuestra ultima entrega sera la decisión corecta asi que su equipo estara en buenas manos..</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Service section end -->
        <!-- Portfolio section start -->
        <div class="section secondary-section " id="portfolio">
            <div class="triangle"></div>
            <div class="container">
                <div class=" title">
                    <h1>Sus Equipos</h1>
                    <p>Equipos Nuevos Con cuenta de garantia incluida apostando con mayor seguridad.</p>
                </div>
                <!-- Start details for portfolio project 1 -->
                <div id="single-project">
                    <div id="slidingDiv" class="toggleDiv row-fluid single-project">
                        <div class="span6">
                            <img src="Img/Portfolio01.png" alt="project 1" />
                        </div>
                        <div class="span6">
                            <div class="project-description">
                                <div class="project-title clearfix">
                                    <h3>Consulta de Equipos Nuevos</h3>
                                    <span class="show_hide close">
                                        <i class="icon-cancel"></i>
                                    </span>
                                </div>
                                <div class="project-info">
                                    <div>
                                        <span>Pagos</span>a Contado o credito</div>
                                    <div>
                                        <span>Creado desde</span>July 2013</div>
                                    <div>
                                        <span>Vendedores</span>Totas Familiaridad con nuestros sistemas</div>
                                </div>
                                <p>Control de venta y apoyando su interes, por supuesto dando un tiempo prolongado contra daños de su equipo.</p>
                            </div>
                        </div>
                    </div>
                    <!-- End details for portfolio project 1 -->
                    <!-- Start details for portfolio project 2 -->
                    <div id="slidingDiv1" class="toggleDiv row-fluid single-project">
                        <div class="span6">
                            <img src="Img/Portfolio02.png" alt="project 2">
                        </div>
                        <div class="span6">
                            <div class="project-description">
                                <div class="project-title clearfix">
                                    <h3>Buena Calidad</h3>
                                    <span class="show_hide close">
                                        <i class="icon-cancel"></i>
                                    </span>
                                </div>
                                <div class="project-info">
                                    <div>
                                        <span>Calificados</span>100%</div>
                                    <div>
                                        <span>Creado desde</span>July 2013</div>
                                    <div>
                                        <span>Fuerza </span>Ventas y Comentarios Positivos</div>
                                    <div>
                                        <span>Discreción</span>Equipos vendidos a buen precio.</div>
                                </div>
                                <p>Ofertas De no poder Rechazar.</p>
                            </div>
                        </div>
                    </div>
                    <!-- End details for portfolio project 2 -->
                    <!-- Start details for portfolio project 3 -->
                    <div id="slidingDiv2" class="toggleDiv row-fluid single-project">
                        <div class="span6">
                            <img src="Img/Portfolio03.png" alt="project 3">
                        </div>
                        <div class="span6">
                            <div class="project-description">
                                <div class="project-title clearfix">
                                    <h3>Conectados Todo el Tiempo</h3>
                                    <span class="show_hide close">
                                        <i class="icon-cancel"></i>
                                    </span>
                                </div>
                                <div class="project-info">
                                    <div>
                                        <span>Client</span>Some Client Name</div>
                                    <div>
                                        <span>Creado desde</span>July 2013</div>
                                    <div>
                                        <span>Apoyo</span>Contactenos a nuestras redes sociales</div>
                                    <div>
                                        <span>Ofrecer</span>Nos encontraras Cerca</div>
                                </div>
                                <p>Contamos con el personal suficiente para atender sus preguntas.</p>
                            </div>
                        </div>
                    </div>
                    <!-- End details for portfolio project 3 -->
                    <!-- Start details for portfolio project 4 -->
                    <div id="slidingDiv3" class="toggleDiv row-fluid single-project">
                        <div class="span6">
                            <img src="Img/Portfolio04.png" alt="project 4">
                        </div>
                        <div class="span6">
                            <div class="project-description">
                                <div class="project-title clearfix">
                                    <h3>Project for Some Client</h3>
                                    <span class="show_hide close">
                                        <i class="icon-cancel"></i>
                                    </span>
                                </div>
                                <div class="project-info">
                                    <div>
                                        <span>Client</span>Some Client Name</div>
                                    <div>
                                        <span>Date</span>July 2013</div>
                                    <div>
                                        <span>Skills</span>HTML5, CSS3, JavaScript</div>
                                    <div>
                                        <span>Link</span>http://examplecomp.com</div>
                                </div>
                                <p>Life's but a walking shadow, a poor player, that struts and frets his hour upon the stage, and then is heard no more; it is a tale told by an idiot, full of sound and fury, signifying nothing.</p>
                            </div>
                        </div>
                    </div>
                    <!-- End details for portfolio project 4 -->
                    <!-- Start details for portfolio project 5 -->
                    <div id="slidingDiv4" class="toggleDiv row-fluid single-project">
                        <div class="span6">
                            <img src="Img/Portfolio05.png" alt="project 5">
                        </div>
                        <div class="span6">
                            <div class="project-description">
                                <div class="project-title clearfix">
                                    <h3>Webste for Some Client</h3>
                                    <span class="show_hide close">
                                        <i class="icon-cancel"></i>
                                    </span>
                                </div>
                                <div class="project-info">
                                    <div>
                                        <span>Client</span>Some Client Name</div>
                                    <div>
                                        <span>Date</span>July 2013</div>
                                    <div>
                                        <span>Skills</span>HTML5, CSS3, JavaScript</div>
                                    <div>
                                        <span>Link</span>http://examplecomp.com</div>
                                </div>
                                <p>We need to give each other the space to grow, to be ourselves, to exercise our diversity. We need to give each other space so that we may both give and receive such beautiful things as ideas, openness, dignity, joy, healing, and inclusion.</p>
                            </div>
                        </div>
                    </div>
                    <!-- End details for portfolio project 5 -->
                    <!-- Start details for portfolio project 6 -->
                    <div id="slidingDiv5" class="toggleDiv row-fluid single-project">
                        <div class="span6">
                            <img src="Img/Portfolio06.png" alt="project 6">
                        </div>
                        <div class="span6">
                            <div class="project-description">
                                <div class="project-title clearfix">
                                    <h3>Webste for Some Client</h3>
                                    <span class="show_hide close">
                                        <i class="icon-cancel"></i>
                                    </span>
                                </div>
                                <div class="project-info">
                                    <div>
                                        <span>Client</span>Some Client Name</div>
                                    <div>
                                        <span>Date</span>July 2013</div>
                                    <div>
                                        <span>Skills</span>HTML5, CSS3, JavaScript</div>
                                    <div>
                                        <span>Link</span>http://examplecomp.com</div>
                                </div>
                                <p>I went to the woods because I wished to live deliberately, to front only the essential facts of life, and see if I could not learn what it had to teach, and not, when I came to die, discover that I had not lived.</p>
                            </div>
                        </div>
                    </div>
                    <!-- End details for portfolio project 6 -->
                    <!-- Start details for portfolio project 7 -->
                    <div id="slidingDiv6" class="toggleDiv row-fluid single-project">
                        <div class="span6">
                            <img src="Img/Portfolio07.png" alt="project 7">
                        </div>
                        <div class="span6">
                            <div class="project-description">
                                <div class="project-title clearfix">
                                    <h3>Webste for Some Client</h3>
                                    <span class="show_hide close">
                                        <i class="icon-cancel"></i>
                                    </span>
                                </div>
                                <div class="project-info">
                                    <div>
                                        <span>Client</span>Some Client Name</div>
                                    <div>
                                        <span>Date</span>July 2013</div>
                                    <div>
                                        <span>Skills</span>HTML5, CSS3, JavaScript</div>
                                    <div>
                                        <span>Link</span>http://examplecomp.com</div>
                                </div>
                                <p>Always continue the climb. It is possible for you to do whatever you choose, if you first get to know who you are and are willing to work with a power that is greater than ourselves to do it.</p>
                            </div>
                        </div>
                    </div>
                    <!-- End details for portfolio project 7 -->
                    <!-- Start details for portfolio project 8 -->
                    <div id="slidingDiv7" class="toggleDiv row-fluid single-project">
                        <div class="span6">
                            <img src="Img/Portfolio08.png" alt="project 8">
                        </div>
                        <div class="span6">
                            <div class="project-description">
                                <div class="project-title clearfix">
                                    <h3>Webste for Some Client</h3>
                                    <span class="show_hide close">
                                        <i class="icon-cancel"></i>
                                    </span>
                                </div>
                                <div class="project-info">
                                    <div>
                                        <span>Client</span>Some Client Name</div>
                                    <div>
                                        <span>Date</span>July 2013</div>
                                    <div>
                                        <span>Skills</span>HTML5, CSS3, JavaScript</div>
                                    <div>
                                        <span>Link</span>http://examplecomp.com</div>
                                </div>
                                <p>What if you gave someone a gift, and they neglected to thank you for it - would you be likely to give them another? Life is the same way. In order to attract more of the blessings that life has to offer, you must truly appreciate what you already have.</p>
                            </div>
                        </div>
                    </div>
                    <!-- End details for portfolio project 8 -->
                    <!-- Start details for portfolio project 9 -->
                    <div id="slidingDiv8" class="toggleDiv row-fluid single-project">
                        <div class="span6">
                            <img src="Img/Portfolio09.png" alt="project 9">
                        </div>
                        <div class="span6">
                            <div class="project-description">
                                <div class="project-title clearfix">
                                    <h3>Webste for Some Client</h3>
                                    <span class="show_hide close">
                                        <i class="icon-cancel"></i>
                                    </span>
                                </div>
                                <div class="project-info">
                                    <div>
                                        <span>Client</span>Some Client Name</div>
                                    <div>
                                        <span>Date</span>July 2013</div>
                                    <div>
                                        <span>Skills</span>HTML5, CSS3, JavaScript</div>
                                    <div>
                                        <span>Link</span>http://examplecomp.com</div>
                                </div>
                                <p>I learned that we can do anything, but we can't do everything... at least not at the same time. So think of your priorities not in terms of what activities you do, but when you do them. Timing is everything.</p>
                            </div>
                        </div>
                    </div>
                    <!-- End details for portfolio project 9 -->
                    <ul id="portfolio-grid" class="thumbnails row">
                        <li class="span4 mix web">
                            <div class="thumbnail">
                                <img src="Img/Portfolio01.png" alt="project 1">
                                <a href="#single-project" class="more show_hide" rel="#slidingDiv">
                                    <i class="icon-plus"></i>
                                </a>
                                <h3>Tu Equipo</h3>

                                <div class="mask"></div>
                            </div>
                        </li>
                        <li class="span4 mix photo">
                            <div class="thumbnail">
                                <img src="Img/Portfolio02.png" alt="project 2">
                                <a href="#single-project" class="show_hide more" rel="#slidingDiv1">
                                    <i class="icon-plus"></i>
                                </a>
                                <h3>Calidad</h3>

                                <div class="mask"></div>
                            </div>
                        </li>
                        <li class="span4 mix identity">
                            <div class="thumbnail">
                                <img src="Img/Portfolio03.png" alt="project 3">
                                <a href="#single-project" class="more show_hide" rel="#slidingDiv2">
                                    <i class="icon-plus"></i>
                                </a>
                                <h3>Conectados</h3>
                                <div class="mask"></div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- Portfolio section end -->
        <!-- About us section start -->
        <div class="section primary-section" id="about">
            <div class="triangle"></div>
            <div class="container">
                <div class="title">
                    <h1>Quienes Somos?</h1>
                    <p>Esta es una empresa dedicada a la reparación de equipos moviles y ventas del mismo.</p>
                </div>
                <div class="row-fluid team">
                    <div class="span4" id="first-person">
                        <div class="thumbnail">
                            <img src="Img/Team1.png" alt="team 1">
                            <h3>Trabajamos</h3>
                            <ul class="social">
                                <li>
                                    <a href="">
                                        <span class="icon-facebook-circled"></span>
                                    </a>
                                </li>
                                <li>
                                    <a href="">
                                        <span class="icon-twitter-circled"></span>
                                    </a>
                                </li>
                                <li>
                                    <a href="">
                                        <span class="icon-linkedin-circled"></span>
                                    </a>
                                </li>
                            </ul>
                            <div class="mask">
                                <h2>Mayor Venta</h2>
                                <p>Mayor cantidad De trabajo Recomendado.</p>
                            </div>
                        </div>
                    </div>
                    <div class="span4" id="second-person">
                        <div class="thumbnail">
                            <img src="Img/Team2.png" alt="team 1">
                            <h3>Nuestro tiempo</h3>
                            <ul class="social">
                                <li>
                                    <a href="">
                                        <span class="icon-facebook-circled"></span>
                                    </a>
                                </li>
                                <li>
                                    <a href="">
                                        <span class="icon-twitter-circled"></span>
                                    </a>
                                </li>
                                <li>
                                    <a href="">
                                        <span class="icon-linkedin-circled"></span>
                                    </a>
                                </li>
                            </ul>
                            <div class="mask">
                                <h2>Oro</h2>
                                <p>El tiempo para nosotros es dinero.</p>
                            </div>
                        </div>
                    </div>
                    <div class="span4" id="third-person">
                        <div class="thumbnail">
                            <img src="Img/Team3.png" alt="team 1">
                            <h3>Construir</h3>
                            <ul class="social">
                                <li>
                                    <a href="">
                                        <span class="icon-facebook-circled"></span>
                                    </a>
                                </li>
                                <li>
                                    <a href="">
                                        <span class="icon-twitter-circled"></span>
                                    </a>
                                </li>
                                <li>
                                    <a href="">
                                        <span class="icon-linkedin-circled"></span>
                                    </a>
                                </li>
                            </ul>
                            <div class="mask">
                                <h2>Dar a conocer</h2>
                                <p>Mas tiempo-Seguridad-Famá.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="section third-section" id="clients">
            <div class="container centered">
                <div class="sub-section">
                    <div class="title clearfix">
                        <div class="pull-left">
                            <h3>Consultar Equipo</h3>
                        </div>
                        <ul class="client-nav pull-right">
                            <li id="client-prev"></li>
                            <li id="client-next"></li>
                        </ul>
                    </div>
                    <ul class="row client-slider" id="clint-slider">
                        <li>
                            <a href="">
                                <img src="Img/clients/ClientLogo01.png" alt="client logo 1">
                            </a>
                        </li>
                        <li>
                            <a href="">
                                <img src="Img/clients/ClientLogo02.png" alt="client logo 2">
                            </a>
                        </li>
                        <li>
                            <a href="">
                                <img src="Img/clients/ClientLogo03.png" alt="client logo 3">
                            </a>
                        </li>
                        <li>
                            <a href="">
                                <img src="Img/clients/ClientLogo04.png" alt="client logo 4">
                            </a>
                        </li>
                        <li>
                            <a href="">
                                <img src="Img/clients/ClientLogo05.png" alt="client logo 5">
                            </a>
                        </li>
                        <li>
                            <a href="">
                                <img src="Img/clients/ClientLogo02.png" alt="client logo 6">
                            </a>
                        </li>
                        <li>
                            <a href="">
                                <img src="Img/clients/ClientLogo04.png" alt="client logo 7">
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="container newsletter">
                <div class="sub-section">
                    <div class="title clearfix">
                    </div>
                </div>
                <div id="success-subscribe" class="alert alert-success invisible">
                    <strong>Well done!</strong>You successfully subscribet to our newsletter.</div>
                <div class="row-fluid">
                    <div class="span5">
                        <p>Aqui Puedes Consultar El Estado de Tu Equipo y comunicarte para saber mas de los procesos que se han llevado a cabo para finalizar su porgreso con nosotros.</p>
                    </div>
                    <div class="span7">
                        <form class="inline-form" method="post" action="Consult/ConsultDevice.jsp">
                            <input type="number" name="UserId" class="span8" placeholder="Ingresar Documento de Identidad" required />
                            <button id="subscribe" class="button button-sp">Buscar</button>
                        </form>
                        <div id="err-subscribe" class="error centered">Por favor ingresa tu número de documento.</div>
                    </div>
                </div>
            </div>
        </div>
        <div id="contact" class="contact">
            <div class="section secondary-section">


                <div class="container">

                    <div class="row-fluid centered">
                        <ul class="social">
                            <li>
                                <a href="">
                                    <span class="icon-facebook-circled"></span>
                                </a>
                            </li>
                            <li>
                                <a href="">
                                    <span class="icon-twitter-circled"></span>
                                </a>
                            </li>
                            <li>
                                <a href="">
                                    <span class="icon-linkedin-circled"></span>
                                </a>
                            </li>
                            <li>
                                <a href="">
                                    <span class="icon-pinterest-circled"></span>
                                </a>
                            </li>
                            <li>
                                <a href="">
                                    <span class="icon-dribbble-circled"></span>
                                </a>
                            </li>
                            <li>
                                <a href="">
                                    <span class="icon-gplus-circled"></span>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <!-- Contact section edn -->
        <!-- Footer section start -->
        <div class="footer">
            <p>&copy; 2017 DONDUR<a href="#"> Todos Los derechos reservados. </a> <a href="#"> 2017.</a></p>
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
        <script src="Js/jquery.js"></script>
        <script type="text/javascript" src="Js/jquery.mixitup.js"></script>
        <script type="text/javascript" src="Js/bootstrap.js"></script>
        <script type="text/javascript" src="Js/modernizr.custom.js"></script>
        <script type="text/javascript" src="Js/jquery.bxslider.js"></script>
        <script type="text/javascript" src="Js/jquery.cslider.js"></script>
        <script type="text/javascript" src="Js/jquery.placeholder.js"></script>
        <script type="text/javascript" src="Js/jquery.inview.js"></script>
        <!-- Load google maps api and call initializeMap function defined in app.js -->
        <script async="" defer="" type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false&callback=initializeMap"></script>
        <!-- css3-mediaqueries.js for IE8 or older -->
        <!--[if lt IE 9]>
            <script src="js/respond.min.js"></script>
        <![endif]-->
        <script type="text/javascript" src="Js/app.js"></script>
    </body>
</html>