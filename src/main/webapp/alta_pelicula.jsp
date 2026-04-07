<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    if(session.getAttribute("adminLogueado") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<html>
<head>
    <title>Alta de Película</title>
</head>
<body style="font-family: Arial, sans-serif; padding: 20px;">

<h2>Registrar Nueva Película</h2>
<hr>

<form action="alta" method="post">
    <label>Director:</label><br>
    <input type="text" name="director" required style="width: 300px;"><br><br>

    <label>Título:</label><br>
    <input type="text" name="titulo" required style="width: 300px;"><br><br>

    <label>Fecha de Estreno:</label><br>
    <input type="datetime-local" name="fecha" required><br><br>

    <button type="submit" style="padding: 10px 20px">Guardar Película</button>
</form>

<br>
<a href="mantenimiento"><button>Cancelar y volver</button></a>

</body>
</html>