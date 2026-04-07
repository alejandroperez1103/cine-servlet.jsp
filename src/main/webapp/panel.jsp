<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // Mini-seguridad: Si no hay un admin logueado en la sesión, lo echamos al login
    if(session.getAttribute("adminLogueado") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<html>
<head>
    <title>Panel de Administración</title>
</head>
<body style="font-family: Arial, sans-serif; padding: 20px;">

<h2>Panel de Control del Administrador</h2>
<hr>

<p style="font-size: 18px; color: green;">
    ¡Acceso concedido! Has iniciado sesión como: <strong>${sessionScope.adminLogueado}</strong>
</p>
<br>

<a href="mantenimiento">
    <button style="padding: 10px 20px; font-size: 14px;">
        Mantenimiento de películas
    </button>
</a>
<br><br>
<a href="registro_admin.jsp">
    <button style="padding: 10px 20px; font-size: 14px;">
        + Registrar Nuevo Administrador
    </button>
</a>

<br><br><br>

<a href="index.jsp">
    <button style="padding: 10px 20px;">Volver al Inicio</button>
</a>

</body>
</html>