<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    if(session.getAttribute("adminLogueado") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<html>
<head>
    <title>Modificar Película</title>
</head>
<body style="font-family: Arial, sans-serif; padding: 20px;">

<h2>Modificar Película</h2>
<hr>

<form action="modificar" method="post">
    <input type="hidden" name="id" value="${pelicula.id}">

    <label>Director:</label><br>
    <input type="text" name="director" value="${pelicula.director}" required style="width: 300px;"><br><br>

    <label>Título:</label><br>
    <input type="text" name="titulo" value="${pelicula.titulo}" required style="width: 300px;"><br><br>

    <label>Fecha de Estreno:</label><br>
    <input type="date" name="fecha" value="${pelicula.fecha.toString().substring(0, 10)}" required><br><br>

    <button type="submit" style="padding: 10px 20px; background-color: #4CAF50; color: white;">Guardar Cambios</button>
</form>

<br>
<a href="mantenimiento"><button>Cancelar y volver</button></a>

</body>
</html>