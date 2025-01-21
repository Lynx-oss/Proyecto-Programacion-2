
package sistema_academico.Recursos;

import java.time.LocalDate;
/**
 * Clase abstracta que representa un recurso académico.
 * Cada recurso académico tiene un identificador, título, fecha de creación, autor y métodos abstractos para calcular relevancia y mostrar detalles.
 * 
 */
 // Atributos privados de la clase: identificador, título, fecha de creación, y autor
public abstract class Recurso_Academico {
    private String identificador;
    private String Titulo;
    LocalDate fechaCreacion;
    private String autor;
    
     
// Constructor de la clase que inicializa los atributos del recurso académico
    public Recurso_Academico(String identificador, String Titulo, LocalDate fechaCreacion, String autor) {
        this.identificador = identificador;
        this.Titulo = Titulo;
        this.fechaCreacion = fechaCreacion;
        this.autor = autor;
       
    }

    
    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

   
    
    //Método abstracto que calcula la relevancia del recurso académico.
    public abstract double calcular_Relevancia();
    
    public abstract void mostrar_Detalles();
        
    
    
}

