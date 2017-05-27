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

    <title>Adding new photo</title>

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
    <img class="img-responsive center-block"
         src="${contextPath}/resources/img/Logo.png"  alt="Logo" style="margin-bottom: -20px">
    <form:form method="POST" modelAttribute="postForm" class="form-signin">
        <h4 class="form-heading" style="text-align: center; color: #AAAAAA">Add new photo</h4>
        <spring:bind path="title">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="title" class="form-control" placeholder="Title"
                            autofocus="true"></form:input>
                <%--<form:errors path="username"></form:errors>--%>
            </div>
        </spring:bind>

        <spring:bind path="description">
            <div class="form-group ${status.error ? 'has-error' : ''}" >
                <%--<form:input type="text" path="description" class="form-control" placeholder="Description" style="height: 200px"></form:input>--%>
                <form:textarea path="description" class="form-control" placeholder="Description" style="height: 200px"></form:textarea>
                    <%--<form:errors path="password"></form:errors>--%>
            </div>
        </spring:bind>

        <spring:bind path="categories">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="categories" class="form-control" placeholder="Categories"></form:input>
                <%--<form:errors path="name"></form:errors>--%>
            </div>
        </spring:bind>

        <%--<spring:bind path="img">--%>
            <%--<div class="form-group ${status.error ? 'has-error' : ''}">--%>
                <%--<form:input type="file" path="img" name="img" class="form-control"></form:input>--%>
                <%--<c:set var="imageError">--%>
                    <%--<form:errors path="img" />--%>
                <%--</c:set>--%>
                <%--<c:if test="${not empty imageError}">--%>
                    <%--<div class="alert alert-danger" role="alert" style="margin-top: 10px;">--%>
                        <%--<form:errors path="img"></form:errors>--%>
                    <%--</div>--%>
                <%--</c:if>--%>
            <%--</div>--%>
        <%--</spring:bind>--%>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        <a href="welcome" style="text-decoration: none"><button class="btn btn-lg btn-danger btn-block" type="button">Cancel</button></a>
    </form:form>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
