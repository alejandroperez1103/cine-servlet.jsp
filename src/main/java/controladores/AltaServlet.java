package controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.dao.PeliculaDAO;
import modelo.entidades.Pelicula;

import java.io.IOException;
import java.sql.Timestamp;

@WebServlet("/alta")
public class AltaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // Recogemos datos del formulario
        String director = request.getParameter("director");
        String titulo = request.getParameter("titulo");
        String fechaStr = request.getParameter("fecha").replace("T", " ");

        // Ajuste de la fecha para que MariaDB la entienda perfectamente
        if (fechaStr.length() == 16) {
            fechaStr += ":00";
        }
        Timestamp fecha = Timestamp.valueOf(fechaStr);

        // Creamos el objeto película (el ID se pone a 0 porque es AUTO_INCREMENT en la BD)
        Pelicula p = new Pelicula(0, director, titulo, fecha);

        // Insertamos en la base de datos usando el DAO
        PeliculaDAO dao = new PeliculaDAO();
        dao.insertar(p);

        // Redirigimos de vuelta a la tabla para ver la película recién creada
        response.sendRedirect("mantenimiento");
    }
}