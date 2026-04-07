<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%
    // Seguridad para que no entren sin login
    if(session.getAttribute("adminLogueado") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<html>
<head>
    <title>Mantenimiento de Películas</title>
</head>
<body style="font-family: Arial, sans-serif; padding: 20px;">

<h2>Gestión y Mantenimiento de Películas</h2>
<hr>

<a href="alta_pelicula.jsp">
    <button style="padding: 10px;">
        + Dar de alta una nueva película
    </button>
</a>
<br><br>

<table border="1" cellpadding="8" cellspacing="0" style="width: 80%; text-align: left;">
    <tr>
        <th>ID</th>
        <th>Director</th>
        <th>Título</th>
        <th>Fecha Estreno</th>
        <th>Acciones</th>
    </tr>

    <c:forEach var="pelicula" items="${listaPeliculas}">
        <tr>
            <td>${pelicula.id}</td>
            <td>${pelicula.director}</td>
            <td>${pelicula.titulo}</td>
            <td>${pelicula.fecha}</td>
            <td>
                <a href="modificar?id=${pelicula.id}">
                    <button style=>Modificar</button>
                </a>

                <a href="eliminar?id=${pelicula.id}" onclick="return confirm('¿Seguro que quieres borrar esta película?');">
                    <button style="">Eliminar</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>

<br><br>
<a href="panel.jsp"><button style="padding: 10px;">Volver al Panel</button></a>

</body>
</html>