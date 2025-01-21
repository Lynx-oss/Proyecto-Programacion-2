
package sistema_academico.Recursos;
import java.time.LocalDate;
import java.util.List;

//Clase Trabajo_Investigacion que extiende de Recurso_Academico.
 // Atributos específicos de la clase Trabajo_Investigacion
public class Trabajo_Investigacion extends Recurso_Academico{
    List<String>autores;
    String  lineaInvestigacion;
    boolean financiamiento;

    //Constructor de la clase Trabajo_Investigacion que inicializa los atributos.
    public Trabajo_Investigacion(List<String> autores, String lineaInvestigacion, boolean financiamiento, String identificador, String Titulo, LocalDate fechaCreacion, String autor) {
        super(identificador, Titulo, fechaCreacion, autor);
        this.autores = autores;
        this.lineaInvestigacion = lineaInvestigacion;
        this.financiamiento = financiamiento;
    }
    
    //Calcula la relevancia del trabajo de investigación basado en el número de autores.

    @Override
    public double calcular_Relevancia() {
         if(autores.size() > 10) { // Si el número de autores es mayor a 10, la relevancia es alta.
            return 1.0;
        } else if (autores.size() >= 5){//Si tiene entre 5 y 10 autores, la relevancia es media.
            return 0.5;
        } else {
            return 0.1;// Si tiene menos de 5 autores, la relevancia es baja.
        }
    }

   @Override
public void mostrar_Detalles() {
    System.out.println("Identificador: " + getIdentificador());
    System.out.println("Título: " + getTitulo());
    System.out.println("Fecha de Creación: " + getFechaCreacion());
    System.out.println("Autor: " + getAutor());
    System.out.println("Línea de Investigación: " + lineaInvestigacion);
    System.out.println("Número de Autores: " + autores.size());
    System.out.println("Financiamiento: " + (financiamiento ? "Sí" : "No"));
    System.out.println("Relevancia: " + calcular_Relevancia());
}
 //Método que devuelve si el trabajo de investigación tiene financiamiento.
public boolean tienefinanciamiento() {
    return financiamiento;

    

   
    }
    
    
        
    
}
