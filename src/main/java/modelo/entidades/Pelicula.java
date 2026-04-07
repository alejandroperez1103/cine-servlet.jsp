package modelo.entidades;

import java.sql.Timestamp;

public class Pelicula {
    private int id;
    private String director;
    private String titulo;
    private Timestamp fecha;

    // Constructor vacío
    public Pelicula() {
    }

    // Constructor con todos los campos
    public Pelicula(int id, String director, String titulo, Timestamp fecha) {
        this.id = id;
        this.director = director;
        this.titulo = titulo;
        this.fecha = fecha;
    }

    // Getters Y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
}