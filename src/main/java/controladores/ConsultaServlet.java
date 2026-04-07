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
import java.util.ArrayList;
import java.util.List;

// Esta anotación es la URL a la que llamará el formulario HTML
@WebServlet("/consultar")
public class ConsultaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recogemos el nombre del director que el usuario ha escrito en el formulario
        String director = request.getParameter("director");

        // Buscamos sus películas en la Base de Datos
        PeliculaDAO dao = new PeliculaDAO();
        List<Pelicula> peliculas = dao.obtenerPorDirector(director);

        // Gestionamos la Sesión para guardar el historial de directores consultados
        HttpSession session = request.getSession();
        List<String> directoresConsultados = (List<String>) session.getAttribute("historialDirectores");

        if (directoresConsultados == null) {
            directoresConsultados = new ArrayList<>();
        }

        // Comprobamos si hay resultados
        if (peliculas.isEmpty()) {
            // Si no existe, enviamos un mensaje de error y volvemos al formulario
            request.setAttribute("error", "No se ha encontrado ninguna película para el director: " + director);
            request.getRequestDispatcher("consulta.jsp").forward(request, response);
        } else {
            // Si existe, lo añadimos al historial (si no estaba ya)
            if (!directoresConsultados.contains(director)) {
                directoresConsultados.add(director);
            }
            session.setAttribute("historialDirectores", directoresConsultados);

            // Enviamos la lista de películas a la página de resultados
            request.setAttribute("listaPeliculas", peliculas);
            request.setAttribute("directorActual", director);
            request.getRequestDispatcher("resultados.jsp").forward(request, response);
        }
    }
}