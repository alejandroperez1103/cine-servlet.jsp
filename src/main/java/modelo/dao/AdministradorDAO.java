package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdministradorDAO {

    // Metodo que devuelve 'true' si el usuario y la clave coinciden en la base de datos
    public boolean validarLogin(String login, String clave) {
        String sql = "SELECT * FROM administrador WHERE login = ? AND clave = ?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Sustituimos las interrogaciones por los datos que nos pasen
            pstmt.setString(1, login);
            pstmt.setString(2, clave);

            try (ResultSet rs = pstmt.executeQuery()) {
                // Si el resultado es 'true', significa que encontró al menos un registro que coincide
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    // Metodo para registrar un nuevo administrador en la base de datos
    public boolean insertar(modelo.entidades.Administrador admin) {
        String sql = "INSERT INTO administrador (login, clave) VALUES (?, ?)";

        try (Connection conn = Conexion.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, admin.getLogin());
            pstmt.setString(2, admin.getClave());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}