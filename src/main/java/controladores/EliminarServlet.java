package controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.dao.PeliculaDAO;

import java.io.IOException;

@WebServlet("/eliminar")
public class EliminarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("adminLogueado") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // Cogemos el ID que nos manda el botón rojo
        int id = Integer.parseInt(request.getParameter("id"));

        // Lo borramos de la base de datos
        PeliculaDAO dao = new PeliculaDAO();
        dao.eliminar(id);

        // Recargamos la tabla de mantenimiento
        response.sendRedirect("mantenimiento");
    }
}