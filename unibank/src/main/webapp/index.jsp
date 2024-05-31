<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <header class="masthead" style="background-image: url('resources/img/inicio-bg.jpg')">
            <div class="container position-relative px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5 justify-content-center">
                    <div class="col-md-10 col-lg-8 col-xl-7">
                        <div class="site-heading">
                            <h1>UniBank</h1>
                            <span class="subheading">Cuidamos tu futuro financiero</span>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <!-- Main Content-->
        <main class="mb-4">
            <div class="container px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5 justify-content-center">
                    <div class="col-md-10 col-lg-8 col-xl-7">
                        <p>Crea tu cuenta aquí para que puedas empezar a realizar transacciones con tu dinero.</p>
                        <div class="my-5">
                            <form id="contactForm" action="/unibank/Registrar" method="post">
                                <div class="form-floating">
                                    <input class="form-control" id="name" name="name" type="text" placeholder="Enter your name..." data-sb-validations="required" required/>
                                    <label for="name">Primer Nombre</label>
                                    <div class="invalid-feedback" data-sb-feedback="name:required">Campo obligatorio.</div>
                                </div>
                                <div class="form-floating">
                                    <input class="form-control" id="email" name="email" type="text" placeholder="Enter your email..." data-sb-validations="required"/>
                                    <label for="email">Segundo Nombre</label>
                                    <div class="invalid-feedback" data-sb-feedback="name:required">Campo obligatorio.</div>
                                </div>
                                <div class="form-floating">
                                    <input class="form-control" id="message" name="message" type="text" placeholder="Enter your message here..." data-sb-validations="required" required/>
                                    <label for="message">Apellido</label>
                                    <div class="invalid-feedback" data-sb-feedback="name:required">Campo obligatorio.</div>
                                </div>
                                <div class="form-floating">
                                    <input class="form-control" id="phone" name="phone" type="tel" placeholder="Enter your phone number..." data-sb-validations="required" required/>
                                    <label for="phone">Número de Identificación</label>
                                    <div class="invalid-feedback" data-sb-feedback="phone:required">Campo obligatorio.</div>
                                </div>
                                <br />
                                <!-- Submit Button-->
                                <button class="btn btn-primary text-uppercase" id="submitButton" type="submit" onclick="mostrarVentanaEmergente()">Enviar</button>
                            </form>
                        </div>
                        <div class="d-flex justify-content-end mb-4"><a class="btn btn-primary text-uppercase" href="ingresar.jsp">Ya tengo cuenta →</a></div>
                    </div>
                </div>
            </div>
        </main>
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
        <script type="text/javascript">
            function mostrarVentanaEmergente(numCuenta) {
                alert("Cuenta creada correctamente. Número de cuenta: " + numCuenta);
            }
        </script>

        <%
            Integer numCuenta = (Integer) request.getAttribute("numCuenta");
            if (numCuenta != null) {
        %>
            <script type="text/javascript">
                mostrarVentanaEmergente(<%= numCuenta %>);
            </script>
        <%
            }
        %>
    </body>
</html>