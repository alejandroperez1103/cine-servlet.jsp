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
import java.util.List;

// Atento a esto: esta es la ruta exacta a la que has intentado entrar
@WebServlet("/mantenimiento")
public class MantenimientoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Comprobamos que el usuario está logueado
        HttpSession session = request.getSession();
        if (session.getAttribute("adminLogueado") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // Usamos nuestro DAO para traernos todas las películas
        PeliculaDAO dao = new PeliculaDAO();
        List<Pelicula> listaPeliculas = dao.obtenerTodas();

        // Metemos la lista en el request y nos vamos a la página JSP a pintarla
        request.setAttribute("listaPeliculas", listaPeliculas);
        request.getRequestDispatcher("mantenimiento.jsp").forward(request, response);
    }
}