<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%
    HttpSession applicationSession = request.getSession();
    Integer conteoCuentasCorrectas = (Integer) applicationSession.getAttribute("conteoCuentasCorrectas");
    int conteoCuentasCorrectasInt = (conteoCuentasCorrectas != null) ? conteoCuentasCorrectas : 0;
    ArrayList<Integer> cuentasCorrectas = (ArrayList<Integer>) applicationSession.getAttribute("cuentasCorrectas");
%>
<%
    Integer conteoCuentasConsig = (Integer) applicationSession.getAttribute("conteoCuentasConsig");
    int conteoCuentasConsigInt = (conteoCuentasConsig != null) ? conteoCuentasConsig : 0;
%>
<%
    Integer conteoCuentasRetir = (Integer) applicationSession.getAttribute("conteoCuentasRetir");
    int conteoCuentasRetirInt = (conteoCuentasRetir != null) ? conteoCuentasRetir : 0;
%>
<%
    Double comisionC = (Double) applicationSession.getAttribute("comisionC");
    double comisionCDouble = (comisionC != null) ? comisionC : 0.0;
%>
<%
    Double comisionR = (Double) applicationSession.getAttribute("comisionR");
    double comisionRDouble = (comisionR != null) ? comisionR : 0.0;
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>UniBank</title>
        <link rel="icon" type="image/x-icon" href="resources/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body>
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light" id="mainNav">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="index.jsp">Banco UniBank</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto py-4 py-lg-0">
                        <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="index.jsp">Inicio</a></li>
                        <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="ingresar.jsp">Ingresar</a></li>
                        <li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4" href="resumen.jsp">Resumen</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- Page Header-->
        <header class="masthead" style="background-image: url('resources/img/cuent-bg.jpg')">
            <div class="container position-relative px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5 justify-content-center">
                    <div class="col-md-10 col-lg-8 col-xl-7">
                        <div class="post-heading">
                            <h1>Resumen</h1>
                            <h2 class="subheading">Resumen del manejo de las cuentas</h2>
                            <span class="meta">Estas con los mejores, UniBank te cuida</span>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <!-- Post Content-->
        <div class="container px-4 px-lg-5">
            <div class="row gx-4 gx-lg-5 justify-content-center">
                <div class="col-md-10 col-lg-8 col-xl-7">
                    <!-- Post preview-->
                    <div class="post-preview">
                        <a>
                            <h2 class="post-title">Resumen de cuentas en el día</h2>
                            </br>
                            <h3 class="post-subtitle">Número de clientes atendidos: <%= conteoCuentasCorrectas %></h3>
                            </br>
                            <h3 class="post-subtitle">Cuentas atendidas: <%= cuentasCorrectas %></h3>
                            </br>
                            <h3 class="post-subtitle">Número de transacciones realizadas: <%= conteoCuentasConsig + conteoCuentasRetir%></h3>
                            </br>
                            <h3 class="post-subtitle">Transacciones realizadas: <%= conteoCuentasConsig %> consignacion/es y <%= conteoCuentasRetir %> retiro/s.</h3>
                            </br>
                            <h3 class="post-subtitle">Dinero obtenido por comisiones: <%= comisionC + comisionR %></h3>
                        </a>
                    </div>
                    <!-- Divider-->
                    <hr class="my-4" />
                    <!-- Post preview-->
                    <div class="post-preview">
                        <a href="politicas.jsp">
                            <h2 class="post-title">Click aquí</h2>
                            <h3 class="post-subtitle">Para conocer las políticas de nuestro banco.</h3>
                        </a>
                    </div>
                    </br>
                </div>
            </div>
        </div>
        <!-- Footer-->
        <footer class="border-top">
            <div class="container px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5 justify-content-center">
                    <div class="col-md-10 col-lg-8 col-xl-7">
                        <ul class="list-inline text-center">
                            <li class="list-inline-item">
                                <a href="#!">
                                    <span class="fa-stack fa-lg">
                                        <i class="fas fa-circle fa-stack-2x"></i>
                                        <i class="fab fa-twitter fa-stack-1x fa-inverse"></i>
                                    </span>
                                </a>
                            </li>
                            <li class="list-inline-item">
                                <a href="#!">
                                    <span class="fa-stack fa-lg">
                                        <i class="fas fa-circle fa-stack-2x"></i>
                                        <i class="fab fa-facebook-f fa-stack-1x fa-inverse"></i>
                                    </span>
                                </a>
                            </li>
                            <li class="list-inline-item">
                                <a href="#!">
                                    <span class="fa-stack fa-lg">
                                        <i class="fas fa-circle fa-stack-2x"></i>
                                        <i class="fab fa-github fa-stack-1x fa-inverse"></i>
                                    </span>
                                </a>
                            </li>
                        </ul>
                        <div class="small text-center text-muted fst-italic">Copyright &copy; UniBank 2024</div>
                    </div>
                </div>
            </div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>