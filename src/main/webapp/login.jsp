<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>User Login</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    
</head>
<body class="bg-light">
   <div class="container-fluid d-flex align-items-center justify-content-center" style="min-height: 100vh;">
    <div class="col-md-6">
        <div class="card">
            <div class="card-header">
                <h2 class="text-center">User Login</h2>
            </div>
            <div class="card-body">
                <form action="login" method="post">
                    <div class="mb-3">
                        <label for="username" class="form-label">Username:</label>
                        <input type="text" id="username" name="username" class="form-control" required>
                    </div>

                    <div class="mb-3">
                        <label for="password" class="form-label">Password:</label>
                        <input type="password" id="password" name="password" class="form-control" required>
                    </div>
                    <div class="text-center">
                        <button type="submit" class="btn btn-primary">Login</button>
                        <a href="register.jsp" class="btn btn-primary">Register</a>
                    </div>
                </form>
            </div>
        </div>

        <c:if test="${not empty param.error}">
            <div class="alert alert-danger mt-3" role="alert">
                Invalid credentials! Please try again.
            </div>
        </c:if>
    </div>
</div>

    <!-- Bootstrap JS (Optional, if you need JavaScript features) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
