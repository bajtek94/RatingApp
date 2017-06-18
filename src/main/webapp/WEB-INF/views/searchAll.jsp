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
    <c:if test="${!searchList.isEmpty()}">
        <h4 class="form-heading" style="text-align: center; color: #AAAAAA">List of found users:</h4>


        <div class="container-fluid">
            <div class="row">

                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

                    <div class="row placeholders">
                        <div class="table-responsive">


                                <table class="table table-hover table-bordered">
                                    <thead>
                                    <tr>
                                        <th>id</th>
                                        <th>Username</th>
                                        <th>Name</th>
                                        <th>Last name</th>
                                        <th>Email</th>
                                        <%-- <sec:authorize access="hasRole('ROLE_ADMIN')"><th>#</th></sec:authorize> --%>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${searchList}" var="user">
                                        <tr>
                                            <td>${user.id}</td>
                                            <td>${user.username}</td>
                                            <td>${user.name}</td>
                                            <td>${user.lastName}</td>
                                            <td>${user.email}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>

                        </div>
                    </div>
                    <!-- /placeholders -->
                </div>
                <!-- /main -->
            </div>
        </div>
    </c:if>
    <c:if test="${listOfFound.isEmpty()}">
        <h2 class="form-heading" style="text-align: center; color: #AAAAAA">No match results.</h2>
    </c:if>
    <!-- /container -->



</div>
<!-- /container -->
<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>--%>
<%--<script src="${contextPath}/resources/js/bootstrap.min.js"></script>--%>
</body>
</html>
