<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Resultados de la Consulta</title>
</head>
<body style="font-family: Arial, sans-serif; padding: 20px;">

<h2>Películas dirigidas por: ${directorActual}</h2>
<hr>

<table border="1" cellpadding="8" cellspacing="0" style="width: 50%; text-align: left;">
    <tr style="background-color: #f2f2f2;">
        <th>Título</th>
        <th>Fecha de Estreno</th>
    </tr>
    <c:forEach var="pelicula" items="${listaPeliculas}">
        <tr>
            <td>${pelicula.titulo}</td>
            <td>${pelicula.fecha}</td>
        </tr>
    </c:forEach>
</table>

<br><br>
<a href="consulta.jsp"><button style="padding: 10px;">Realizar otra consulta</button></a>
&nbsp;&nbsp;
<a href="resumen.jsp"><button style="padding: 10px">Finalizar</button></a>

</body>
</html>