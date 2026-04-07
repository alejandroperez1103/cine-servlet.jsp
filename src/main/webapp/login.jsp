<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Login Administradores</title>
</head>
<body style="font-family: Arial, sans-serif; padding: 20px;">

<h2>Acceso al Panel de Mantenimiento</h2>
<hr>

<c:if test="${not empty error}">
    <p style="color: red; font-weight: bold;">${error}</p>
</c:if>

<form action="login" method="post">
    <label for="login">Usuario (login):</label>
    <input type="text" id="login" name="login" required>
    <br><br>

    <label for="clave">Contraseña:</label>
    <input type="password" id="clave" name="clave" required>
    <br><br>

    <button type="submit" style="padding: 10px 20px; font-size: 16px;">Entrar</button>
</form>

<br><br>
<a href="index.jsp"><button>Volver</button></a>

</body>
</html>