package controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.dao.AdministradorDAO;
import modelo.entidades.Administrador;

import java.io.IOException;

@WebServlet("/registrarAdmin")
public class RegistroAdminServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        if (request.getSession().getAttribute("adminLogueado") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // Recogemos los datos del formulario
        String login = request.getParameter("nuevoLogin");
        String clave = request.getParameter("nuevaClave");

        // Creamos el objeto y lo insertamos
        Administrador nuevoAdmin = new Administrador(0, login, clave);
        AdministradorDAO dao = new AdministradorDAO();
        dao.insertar(nuevoAdmin);

        // Volvemos al panel
        response.sendRedirect("panel.jsp");
    }
}