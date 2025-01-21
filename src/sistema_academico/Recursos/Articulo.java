
package sistema_academico.Recursos;
import java.time.LocalDate;
import java.util.List;


//Clase Articulo que extiende de Recurso_Academico.
 // Atributos específicos de la clase Articulo
public class Articulo extends Recurso_Academico{
    private List<String> palabrasClave;
    private String revista;
    private int citas;

    // Constructor de la clase Articulo que inicializa los atributos.
    public Articulo(List<String> palabrasClave, String revista, int citas, String identificador, String Titulo, LocalDate fechaCreacion, String autor) {
        super(identificador, Titulo, fechaCreacion, autor);
        this.palabrasClave = palabrasClave;
        this.revista = revista;
        this.citas = citas;
    }

   // Calcula la relevancia del artículo basado en el número de citas.
    @Override
    public double calcular_Relevancia() {
            if (citas > 50){ 
        return 1.0;//Si el artículo tiene más de 50 citas, su relevancia es alta
    } else if (citas >= 10 && citas <= 50){
        return 0.5; // Si tiene entre 10 y 50 citas, la relevancia es media.
    } else {
        return 0.2; //  Si tiene menos de 10 citas, la relevancia es baja
    }
    }

    
    //Muestra los detalles del artículo, incluyendo su identificador, título,  fecha de creación, autor, revista, número de citas, palabras clave y relevancia.
    @Override
    public void mostrar_Detalles() {
  
    System.out.println("Identificador: " + getIdentificador());
         System.out.println("-----------------------------------------------------");
    System.out.println("Título: " + getTitulo());
    System.out.println("Fecha de Creación: " + getFechaCreacion());
    System.out.println("Autor: " + getAutor());
    System.out.println("Revista: " + revista);
    System.out.println("Número de Citas: " + citas);
    System.out.println("Palabras Clave: " + String.join(", ", palabrasClave));
    System.out.println("Relevancia: " + calcular_Relevancia());
         System.out.println("-----------------------------------------------------");
}

    // Devuelve el número de palabras clave asociadas al artículo.
 public int contarPalabrasClave() {
     return palabrasClave.size();
 }
    
    
    
}
