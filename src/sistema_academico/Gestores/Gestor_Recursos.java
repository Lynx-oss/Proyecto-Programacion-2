
package sistema_academico.Gestores;
import sistema_academico.Recursos.Recurso_Academico;
import sistema_academico.interfaces.Filtro_Recurso;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import sistema_academico.interfaces.Filtro_Recurso;
import sistema_academico.Excepciones.CategoriaInvalida_Exception;
import sistema_academico.Excepciones.RecursoNoEncontrado_Exception;
import sistema_academico.Excepciones.LimiteRecursos_Exception;

public class Gestor_Recursos {
    
    private List<Recurso_Academico> recursos; //lista que contiene todos los recursos academicos
    private int limite_Recurso = 100; //limite que puse ficticio para tener una idea
    
    //este es el constructor de lgestor recursos para asignarle el atributo recursos
    public Gestor_Recursos(List<Recurso_Academico> recursos){
        this.recursos = recursos;
    }
    
    //hice eeste metodo para filtrar los recursos segun un filtro proporcionado
    public List<Recurso_Academico>Filtrar(Filtro_Recurso filtro){
        return recursos.stream() //el stream de utiliza para iterar la lista de recursos
                .filter(filtro::evaluar)//aplica el filtro proporcionado
                .collect(Collectors.toList()); //ponemos los resultados en una nueva lista
    }
    //otro metodo para ordenar los recursos usando un comparador
    public List<Recurso_Academico> ordenar(Comparator<Recurso_Academico> comparador){
        return recursos.stream()//el stream de utiliza para iterar la lista de recursos
                .sorted(comparador)//ordena los recursos segun el comparador
                .collect(Collectors.toList());//ponemos los resultados en una nueva lista
    }
   //otro metodo que genera un informe con todos los recursos
    public void Generar_informe() {
        System.out.println("Total de recursos registrados: " + recursos.size()); //muestra todos los recursos asignados
        
        //llama al metodo mostrar_Detalles de cada recurso para mostrar sus detalles
        recursos.forEach(Recurso_Academico::mostrar_Detalles);  
        
    }
    //un metodo para asignar una categoria a un recurso
       public void asignarCategoria(Recurso_Academico recurso, String categoria) throws CategoriaInvalida_Exception {
        if (categoria == null || categoria.isEmpty()) { //verifica si la categoria es nula o vacia
            throw new CategoriaInvalida_Exception("La categoría proporcionada no es válida.");
        }
        
       }
       //un metodo para buscar un recurso por su identificador
       public Recurso_Academico buscarRecurso(String Identificador) throws RecursoNoEncontrado_Exception {
           return recursos.stream() //busca el recurso en la lista por su identificador
                .filter(recurso -> recurso.getIdentificador().equals(Identificador)) //filtra por el identificador
                .findFirst()//toma el primer recurso que coincide
                .orElseThrow(() -> new RecursoNoEncontrado_Exception("Recurso con identificador " + Identificador + " no encontrado.")); //en el caso que no se encuentre lanza una excepcion
       }
       
       //otro metodo para agregar un recurso a la lista de recurso y verificando que no se haya alcanzado el limite
        public void agregarRecurso(Recurso_Academico recurso) throws LimiteRecursos_Exception {
            //verifica si la cantidad de recursos ha alcanzado su limite
        if (recursos.size() >= limite_Recurso) {
            throw new LimiteRecursos_Exception("Límite de " + limite_Recurso + " alcanzado."); //si alcanza su limite lanza esta excepcion
        }
        recursos.add(recurso); //si no se alcanza agrega el recurso a la lista
    }
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
}
        

        
            
    
    
    

