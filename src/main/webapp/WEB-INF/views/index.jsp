<DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>The Survey</title>

    <!-- Bootstrap -->
    <link href="/resources/assets/gentelella/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="/resources/assets/gentelella/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="/resources/assets/gentelella/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- bootstrap-progressbar -->
    <link href="/resources/assets/gentelella/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="/resources/assets/gentelella/build/css/custom.min.css" rel="stylesheet">
    <link href="/resources/assets/css/style.css" rel="stylesheet">
</head>

<body>

<div class="container body">
    <div class="main-menu col-md-3 col-sm-12">
        <jsp:include page="../inc/menu.jsp"/>
    </div>
    <div class="main_container col-sm-9">
        <div class="row">
<jsp:include page="${site}.jsp" flush="true" />
        </div>
    </div>
</div>

<jsp:include page="../inc/footer.jsp"/>

<!-- jQuery -->
<script src="/resources/assets/gentelella/vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="/resources/assets/gentelella/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="/resources/assets/gentelella/vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="/resources/assets/gentelella/vendors/nprogress/nprogress.js"></script>
<!-- Chart.js -->
<script src="/resources/assets/gentelella/vendors/Chart.js/dist/Chart.min.js"></script>
<!-- gauge.js -->
<script src="/resources/assets/gentelella/vendors/bernii/gauge.js/dist/gauge.min.js"></script>
<!-- bootstrap-progressbar -->
<script src="/resources/assets/gentelella/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
<!-- iCheck -->
<script src="/resources/assets/gentelella/vendors/iCheck/icheck.min.js"></script>
<!-- Skycons -->
<script src="/resources/assets/gentelella/vendors/skycons/skycons.js"></script>
<!-- Flot -->
<script src="/resources/assets/gentelella/vendors/Flot/jquery.flot.js"></script>
<script src="/resources/assets/gentelella/vendors/Flot/jquery.flot.pie.js"></script>
<script src="/resources/assets/gentelella/vendors/Flot/jquery.flot.time.js"></script>
<script src="/resources/assets/gentelella/vendors/Flot/jquery.flot.stack.js"></script>
<script src="/resources/assets/gentelella/vendors/Flot/jquery.flot.resize.js"></script>
<!-- bootstrap-daterangepicker -->
<script src="/resources/assets/gentelella/vendors/moment/min/moment.min.js"></script>

<!-- Custom Theme Scripts -->
<script src="/resources/assets/gentelella/build/js/custom.min.js"></script>

<!-- TheSurvey custom JS -->
<script src="/resources/assets/js/custom.js"></script>

</body>
</html>