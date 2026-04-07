package modelo.dao;

import modelo.entidades.Pelicula;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeliculaDAO {

    // Obtener películas de un director concreto (Para la consulta pública)
    public List<Pelicula> obtenerPorDirector(String director) {
        List<Pelicula> lista = new ArrayList<>();
        String sql = "SELECT * FROM pelicula WHERE director = ?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, director);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    lista.add(new Pelicula(
                            rs.getInt("id"),
                            rs.getString("director"),
                            rs.getString("titulo"),
                            rs.getTimestamp("fecha")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Obtener todas las películas (Para el listado de Mantenimiento)
    public List<Pelicula> obtenerTodas() {
        List<Pelicula> lista = new ArrayList<>();
        String sql = "SELECT * FROM pelicula";

        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Pelicula(
                        rs.getInt("id"),
                        rs.getString("director"),
                        rs.getString("titulo"),
                        rs.getTimestamp("fecha")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Obtener una sola película por su ID (Útil para rellenar el formulario de modificar)
    public Pelicula obtenerPorId(int id) {
        String sql = "SELECT * FROM pelicula WHERE id = ?";
        try (Connection conn = Conexion.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Pelicula(
                            rs.getInt("id"),
                            rs.getString("director"),
                            rs.getString("titulo"),
                            rs.getTimestamp("fecha")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Insertar nueva película (Alta)
    public boolean insertar(Pelicula p) {
        String sql = "INSERT INTO pelicula (director, titulo, fecha) VALUES (?, ?, ?)";
        try (Connection conn = Conexion.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, p.getDirector());
            pstmt.setString(2, p.getTitulo());
            pstmt.setTimestamp(3, p.getFecha());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Modificar una película existente
    public boolean actualizar(Pelicula p) {
        String sql = "UPDATE pelicula SET director = ?, titulo = ?, fecha = ? WHERE id = ?";
        try (Connection conn = Conexion.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, p.getDirector());
            pstmt.setString(2, p.getTitulo());
            pstmt.setTimestamp(3, p.getFecha());
            pstmt.setInt(4, p.getId());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Eliminar película de la base de datos
    public boolean eliminar(int id) {
        String sql = "DELETE FROM pelicula WHERE id = ?";
        try (Connection conn = Conexion.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}