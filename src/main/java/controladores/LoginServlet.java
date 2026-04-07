package controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.dao.AdministradorDAO;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recogemos los datos del formulario de login
        String login = request.getParameter("login");
        String clave = request.getParameter("clave");

        AdministradorDAO dao = new AdministradorDAO();

        // Validamos contra la base de datos
        if (dao.validarLogin(login, clave)) {
            // Login correcto: Guardamos al usuario en sesión
            HttpSession session = request.getSession();
            session.setAttribute("adminLogueado", login);

            // Redirigimos a la pantalla del panel de control
            response.sendRedirect("panel.jsp");
        } else {
            // Login incorrecto: Volvemos al login con mensaje de error
            request.setAttribute("error", "Usuario o contraseña incorrectos. Inténtalo de nuevo.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}