<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<%@page import="control.Operaciones"%>
<%@page import="model.Datos"%>
<%
    Integer numCuenta = (Integer) session.getAttribute("numCuenta");
    if (numCuenta == null) {
        out.println("Número de cuenta no ingresado correctamente");
        return;
    }
    
    int numCuentaInt = numCuenta.intValue();
    Operaciones DB = new Operaciones();
    Datos datos = DB.obtenerDatosCuenta(numCuenta);
%>

<%
    HttpSession applicationSession = request.getSession();
    ArrayList<Integer> cuentasConsig = (ArrayList<Integer>) applicationSession.getAttribute("cuentasConsig");
    int consigs = 0;
    if (cuentasConsig != null && cuentasConsig.contains(numCuenta)) {
        consigs = Collections.frequency(cuentasConsig, numCuenta);
    }
    ArrayList<Integer> cuentasRetir = (ArrayList<Integer>) applicationSession.getAttribute("cuentasRetir");
    int retirs = 0;
    if (cuentasRetir != null && cuentasRetir.contains(numCuenta)) {
        retirs = Collections.frequency(cuentasRetir, numCuenta);
    }
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
                            <h1>Cuenta</h1>
                            <h2 class="subheading">Conoce los datos asociados a tu cuenta</h2>
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
                            <h2 class="post-title">Datos de la cuenta</h2>
                            </br>
                            <h3 class="post-subtitle">Primer Nombre: <%= datos.getNombre1() %></h3>
                            </br>
                            <h3 class="post-subtitle">Segundo Nombre: <%= datos.getNombre2() %></h3>
                            </br>
                            <h3 class="post-subtitle">Apellido: <%= datos.getApellido() %></h3>
                            </br>
                            <h3 class="post-subtitle">Número de Cuenta: <%= datos.getNCuenta() %></h3>
                            </br>
                            <h3 class="post-subtitle">Saldo: <%= datos.getSaldo() %></h3>
                            </br>
                            <h3 class="post-subtitle">Últimas Transacciones: <%= consigs %> consignacion/es y <%= retirs %> retiro/s</h3>
                        </a>
                    </div>
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