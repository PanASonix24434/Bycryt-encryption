<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Welcome</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container-fluid d-flex align-items-center justify-content-center" style="min-height: 100vh;">
    <div class="col-md-6">
        <div class="card">
            <div class="card-header">
                <h2 class="text-center">Welcome</h2>
            </div>
            <div class="card-body">
                <p class="text-center">Welcome, ${sessionScope.username}!</p>
                <!-- Use the correct URL with or without context path -->
                <p class="text-center"><a href="${pageContext.request.contextPath}/logout">Logout</a></p>
            </div>
        </div>
    </div>
</div>

    <!-- JavaScript for logout redirection -->
    <script>
        function logout() {
            // Perform logout via servlet
            window.location.href = "logout";
        }
    </script>

    <!-- Bootstrap JS (Optional, if you need JavaScript features) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
