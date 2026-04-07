package controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.dao.PeliculaDAO;
import modelo.entidades.Pelicula;

import java.io.IOException;
import java.sql.Timestamp;

@WebServlet("/modificar")
public class ModificarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. Seguridad
        if (request.getSession().getAttribute("adminLogueado") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // 2. Recoger el ID de la URL y buscar la película
        int id = Integer.parseInt(request.getParameter("id"));
        PeliculaDAO dao = new PeliculaDAO();
        Pelicula p = dao.obtenerPorId(id);

        // 3. Mandar los datos al formulario
        request.setAttribute("pelicula", p);
        request.getRequestDispatcher("modificar.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // Recoger los datos del formulario editado
        int id = Integer.parseInt(request.getParameter("id"));
        String director = request.getParameter("director");
        String titulo = request.getParameter("titulo");

        // Como el formulario ahora solo envía "YYYY-MM-DD", le añadimos " 00:00:00" a mano
        String fechaStr = request.getParameter("fecha") + " 00:00:00";
        Timestamp fecha = Timestamp.valueOf(fechaStr);

        // 2. Actualizar en la BD
        Pelicula p = new Pelicula(id, director, titulo, fecha);
        PeliculaDAO dao = new PeliculaDAO();
        dao.actualizar(p);

        // 3. Volver al listado
        response.sendRedirect("mantenimiento");
    }
}