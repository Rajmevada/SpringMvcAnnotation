<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome page</title>
</head>
<body>
    Greeting : ${greeting}
    This is a welcome page.
    
     <div>
        <sec:authorize access="hasRole('ADMIN')">
            <label><a href="#">Edit this page</a> | This part is visible only to ADMIN</label>
        </sec:authorize>
    </div>
 
    <br/>
    <div>
        <sec:authorize access="hasRole('ADMIN') and hasRole('DBA')">
            <label><a href="#">Start backup</a> | This part is visible only to one who is both ADMIN & DBA</label>
        </sec:authorize>
    </div>
</body>
</html>