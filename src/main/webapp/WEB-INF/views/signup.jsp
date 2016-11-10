<%@ page import="java.util.*" %>
<%

%>


<DOCTYPE html/>
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>The Survey - Login</title>

        <!-- Bootstrap -->
        <link href="/resources/assets/gentelella/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="/resources/assets/gentelella/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <!-- Custom Theme Style -->
        <link href="/resources/assets/gentelella/build/css/custom.min.css" rel="stylesheet">
        <link href="/resources/assets/css/style.css" rel="stylesheet">
    </head>

    <body>

    <div class="container body">
        <div class="main_container col-sm-9">
            <!-- login row -->
            <div class="row">

                <h1>Login</h1>
                <h2>Seite: ${site}, Aktion: ${action}</h2>
                <h2>${error}</h2>
                <h2>${info}</h2>

                <h1>Loginseite The Survey</h1>

                <form name="loginForm" action="/appLogin" method="post">
                    <label for="username"></label>
                    <input type="text" id="username" name="username" value="">
                    <input type="password" id="password" name="password" value="">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <input type="submit" value="Anmelden">
                </form>

            </div><!-- /login row -->
        </div>
    </div>

    <!-- jQuery -->
    <script src="/resources/assets/gentelella/vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="/resources/assets/gentelella/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    </body>
    </html>