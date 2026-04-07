<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Resumen de Consultas</title>
</head>
<body style="font-family: Arial, sans-serif; padding: 20px; text-align: center;">

<h2>Resumen de tu sesión</h2>
<hr style="width: 50%;">

<h3>Directores consultados:</h3>

<ul style="list-style-type: none; padding: 0;">
    <c:forEach var="director" items="${sessionScope.historialDirectores}">
        <li style="font-size: 18px; margin: 5px;">${director}</li>
    </c:forEach>
</ul>

<br><br>

<a href="index.jsp"><button style="padding: 10px;">Inicio</button></a>

&nbsp;&nbsp;

<a href="reiniciar">
    <button style="padding: 10px;">
        Nueva consulta (Limpiar sesión)
    </button>
</a>

</body>
</html>