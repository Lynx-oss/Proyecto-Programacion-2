
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import sistema_academico.Gestores.Gestor_Recursos;
import sistema_academico.Excepciones.RecursoNoEncontrado_Exception;
import sistema_academico.Excepciones.CategoriaInvalida_Exception;
import sistema_academico.Excepciones.LimiteRecursos_Exception;
import sistema_academico.Recursos.Articulo;
import sistema_academico.Recursos.Libro;
import sistema_academico.Recursos.Recurso_Academico;
import sistema_academico.Recursos.Trabajo_Investigacion;

public class Sistema_Academico {
    public static void main(String[] args) {
        //creo la instancia del gestor pasando una lista vacia
        Gestor_Recursos gestor = new Gestor_Recursos(new ArrayList<Recurso_Academico>());

      
        try {
            //aca estan los 3 recursos distintos
            Libro libro1 = new Libro(300, "editorial TOP", "L001", "Programación en Java y springboot", LocalDate.of(2020, 5, 15), "Robert C. Martin");
            Articulo articulo1 = new Articulo(Arrays.asList("Python", "Newbie", "Software"), "Revista de Tecnología", 25, "A001", "Innovaciones en Python", LocalDate.of(2021, 7, 10), "Guido van Rossum");
            Trabajo_Investigacion trabajo1 = new Trabajo_Investigacion(Arrays.asList("Alan", "Bob", "Charlie"), "Inteligencia Artificial", true, "T001", "IA en el futuro", LocalDate.of(2022, 3, 20), "Alan Turing");
            //agregar los recursos al gestor
            gestor.agregarRecurso(libro1);
            gestor.agregarRecurso(articulo1);
            gestor.agregarRecurso(trabajo1);

            System.out.println("Recursos agregados exitosamente.");
        } catch (LimiteRecursos_Exception e) {
            System.err.println(e.getMessage()); //muestra si ocurre un error al agregar recurso
        }

      
        try {
            // Buscar el recurso con identificador "L001" 
            Recurso_Academico recurso = gestor.buscarRecurso("L001");
            
            // Intenta asignar una categoría vacía con lo cual generará una excepción
            gestor.asignarCategoria(recurso, "");
            
            // Si todo va bien imprime el título del recurso
            System.out.println("Recurso encontrado y categoría asignada: " + recurso.getTitulo());
        } catch (RecursoNoEncontrado_Exception | CategoriaInvalida_Exception e) {
            // Captura y muestra el mensaje de error si el recurso no se encuentra o la categoría es inválida
            System.err.println(e.getMessage());
        }
       //filtra recursos con relevancia mayor o igual a 0.5 
        List<Recurso_Academico> recursosRelevantes = gestor.Filtrar(recurso -> recurso.calcular_Relevancia() >= 0.5);
        System.out.println("Recursos relevantes:");
        for (Recurso_Academico recurso : recursosRelevantes) {
            System.out.println("- " + recurso.getTitulo() + " (Relevancia: " + recurso.calcular_Relevancia() + ")");
        }

       //informa con todos los recursos
        System.out.println("\nInforme de Recursos:");
        gestor.Generar_informe();
    }
}

