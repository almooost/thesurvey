<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>The Survey - Mitarbeiterumfragen</title>

    <!-- Bootstrap -->
    <link href="/resources/assets/gentelella/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="/resources/assets/gentelella/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="/resources/assets/gentelella/vendors/iCheck/skins/flat/green.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="/resources/assets/gentelella/build/css/custom.min.css" rel="stylesheet">
    <link href="/resources/assets/css/style.css" rel="stylesheet">
</head>

<body class="nav-md">

<div class="notification-wrapper">
    <div class="notification">
        <c:if test="${info != ''}">
            ${info}
            ${info = ''}
        </c:if>
    </div>
</div>

<div class="container body">

    <div class="main_container">
        <c:if test="${site != 'live'}">
        <jsp:include page="../inc/menu.jsp"/>
        </c:if>
        <div class="right_col" role="main" style="min-height: 4089px;">
            <div class="row">
<jsp:include page="${site}.jsp" flush="true" />
            </div>
        </div>
    </div>
</div>

<!-- jQuery -->
<script src="/resources/assets/gentelella/vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="/resources/assets/gentelella/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="/resources/assets/gentelella/vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="/resources/assets/gentelella/vendors/nprogress/nprogress.js"></script>
<!-- bootstrap-progressbar -->
<script src="/resources/assets/gentelella/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>

<!-- Custom Theme Scripts -->
<script src="/resources/assets/gentelella/build/js/custom.min.js"></script>
</body>
</html>

<!-- TheSurvey custom JS -->
<script src="/resources/assets/js/custom.js"></script>

</body>
</html>