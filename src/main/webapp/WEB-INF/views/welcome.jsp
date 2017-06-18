<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<c:url var="firstUrl" value="/welcome/1" />
<c:url var="lastUrl" value="/welcome/${welcome.totalPages}" />
<c:url var="prevUrl" value="/welcome/${currentIndex - 1}" />
<c:url var="nextUrl" value="/welcome/${currentIndex + 1}" />

<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>RateMyPic - Home Page</title>

    <!-- Bootstrap Core CSS -->
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${contextPath}/resources/css/3-col-portfolio.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/myStyles.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>




<!-- Page Content -->
<div class="container">
    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="../addPhoto">Add Photo</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#">Your Profile</a>
                    </li>
                    <form method="POST" style="display: inline">
                    <li>
                        <div id="imaginary_container" style="padding-top: 10px; width: 600px">
                            <div class="input-group stylish-input-group">

                                    <input type="text" id="searchText" name="searchText" class="form-control"  placeholder="Search" style="display: inline">
                                    <span class="input-group-addon">
                                        <%--<a href="searchAll">--%>
                                            <button href="searchAll" type="submit" style="display: inline">
                                                <span class="glyphicon glyphicon-search"></span>
                                            </button>
                                        <%--</a>--%>
                                    </span>

                            </div>
                        </div>
                    </li>
                    </form>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    <a href="../welcome">
        <img class="img-responsive center-block" src="${contextPath}/resources/img/Logo.png"  alt="Logo">
    </a>

    <!-- Page Header -->
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Welcome
                <small>${pageContext.request.userPrincipal.name}</small>
            </h1>
        </div>
    </div>
    <!-- /.row -->


    <div class="row">
    <c:forEach items="${postList}" var="post">
        <div class="col-md-4 portfolio-item">
                <img class="img-responsive" src="data:image/png;base64,${post.base64}"/>
                <%--<img src="${post.img}" width="40" height="40"/>--%>
                <%--<img src="data:image/jpg;base64,<c:out value='${bean.imageByteArrayString}'/>" />--%>
            <h3>
                <a href="#">${post.title}</a>
            </h3>
            <p>${post.description}</p>
            <p><a href="<c:url value='/addLike-${post.id}' />"><button>Like</button></a> ${post.likes}, <a href="<c:url value='/addDislike-${post.id}' />"><button>Dislike</button></a> ${post.dislikes}</p>
        </div>
    </c:forEach>
    </div>

    <hr>


    <div class="row text-center">
        <div class="col-lg-12">
            <ul class="pagination">
                <c:choose>
                    <c:when test="${currentIndex == 1}">
                        <li class="disabled"><a href="#">&lt;&lt;</a></li>
                        <li class="disabled"><a href="#">&lt;</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${firstUrl}">&lt;&lt;</a></li>
                        <li><a href="${prevUrl}">&lt;</a></li>
                    </c:otherwise>
                </c:choose>
                <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
                    <c:url var="pageUrl" value="/welcome/${i}" />
                    <c:choose>
                        <c:when test="${i == currentIndex}">
                            <li class="active"><a href="${pageUrl}"><c:out value="${i}" /></a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="${pageUrl}"><c:out value="${i}" /></a></li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <c:choose>
                    <c:when test="${currentIndex == welcome.totalPages}">
                        <li class="disabled"><a href="#">&gt;</a></li>
                        <li class="disabled"><a href="#">&gt;&gt;</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="${nextUrl}">&gt;</a></li>
                        <li><a href="${lastUrl}">&gt;&gt;</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>

    <hr>

    <!-- Footer -->
    <footer>
        <div class="row">
            <div class="col-lg-12">
                <p>Copyright &copy; RateMyPic 2017</p>
            </div>
        </div>
        <!-- /.row -->
    </footer>

</div>
<!-- /.container -->

<!-- jQuery -->
<script src="js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
