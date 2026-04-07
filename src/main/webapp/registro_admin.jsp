<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    // Seguridad: Solo un admin logueado puede crear a otro admin
    if(session.getAttribute("adminLogueado") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<html>
<head>
    <title>Registrar Administrador</title>
</head>
<body style="font-family: Arial, sans-serif; padding: 20px;">

<h2>Registrar Nuevo Administrador</h2>
<hr>

<form action="registrarAdmin" method="post">
    <label>Nuevo Usuario (login):</label><br>
    <input type="text" name="nuevoLogin" required style="width: 250px;"><br><br>

    <label>Contraseña:</label><br>
    <input type="password" name="nuevaClave" required style="width: 250px;"><br><br>

    <button type="submit" style="padding: 10px 20px">Crear Administrador</button>
</form>

<br>
<a href="panel.jsp"><button style="padding: 10px;">Cancelar y volver</button></a>

</body>
</html>