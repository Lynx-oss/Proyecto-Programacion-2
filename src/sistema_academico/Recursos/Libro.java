package sistema_academico.Recursos;



import java.time.LocalDate;
import java.util.Map;

// Clase Libro que extiende de Recurso_Academico, es una clase específica de un tipo de recurso académico
public class Libro extends Recurso_Academico{
   private int numeroPaginas;
    private String editorial;
     private static final Map<String, Integer> puntuaje_Editorial = Map.of( // Este mapa simula una clasificación de editoriales con diferentes niveles de puntaje
            "editorial TOP", 10, // Si la editorial es "editorial TOP", el puntaje es 10
            "editorial media", 7, // Si la editorial es "editorial media", el puntaje es 7
            "editorial baja", 5// Si la editorial es "editorial baja", el puntaje es 5
            
    );
    // Constructor de la clase Libro, que recibe los parámetros necesarios y llama al constructor de la clase base (Recurso_Academico)
    public Libro(int numeroPaginas, String editorial, String Identificador, String titulo, LocalDate fechaCreacion, String autor) {
        super(Identificador, titulo, fechaCreacion, autor);  // Llama al constructor de la clase base para inicializar los atributos comunes a todos los recursos académicos
        this.numeroPaginas = numeroPaginas;
        this.editorial = editorial;
    }

    // Implementación del método abstracto calcular_Relevancia, que calcula la relevancia del libro basado en la editorial

    @Override
    public double calcular_Relevancia(){
        if (puntuaje_Editorial.containsKey(editorial)){
            return puntuaje_Editorial.get(editorial);
        } else {
            System.err.print("la editorial no esta en nuestro sistema: " + editorial);
            return calcular_Relevancia();
        }
    }
    // Implementación del método abstracto mostrar_Detalles, que muestra los detalles del libro
    public void mostrar_Detalles(){
        System.out.println("identificador: " + getIdentificador() +"\nTitulo:" + getTitulo() + "\nNumero de Paginas: " + numeroPaginas +  "\nfecha de creacion: " + fechaCreacion + "\nRelevancia: " + calcular_Relevancia());
    }


  
   
 
   
    
    
    
    
}
