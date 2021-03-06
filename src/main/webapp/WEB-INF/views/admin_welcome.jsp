<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Admin panel</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<div class="container">

    <a href="welcome"><img class="img-responsive center-block" src="${contextPath}/resources/img/Logo.png"  alt="Logo"></a>
    <h4 class="form-heading" style="text-align: center; color: #AAAAAA">Admin Panel</h4>
    <p><a href="listUsers"><button class="btn btn-lg btn-primary btn-block">List all users</button></a></p>
    <p><a href="findUser"><button class="btn btn-lg btn-primary btn-block">Find user</button></a></p>
    <p><a href="listPosts"><button class="btn btn-lg btn-primary btn-block">List all posts</button></a></p>
    <p><a href="findPost"><button class="btn btn-lg btn-primary btn-block">Find post</button></a></p>
    <p><a href="${contextPath}/login?logout" style="text-decoration: none"><button class="btn btn-lg btn-danger btn-block" type="button">Logout</button></a></p>

</div>
<!-- /container -->
<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>--%>
<%--<script src="${contextPath}/resources/js/bootstrap.min.js"></script>--%>
</body>
</html>
