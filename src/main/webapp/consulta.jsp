<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Consultar Director</title>
</head>
<body style="font-family: Arial, sans-serif; padding: 20px;">

<h2>Consultar películas por director</h2>
<hr>

<c:if test="${not empty error}">
    <p style="color: red; font-weight: bold;">${error}</p>
</c:if>

<form action="consultar" method="post">
    <label for="director">Nombre del director:</label>
    <input type="text" id="director" name="director" required>
    <button type="submit">Consultar</button>
</form>

<br>
<a href="index.jsp">Volver al inicio</a>

</body>
</html>