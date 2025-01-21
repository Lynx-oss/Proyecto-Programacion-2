
package sistema_academico.interfaces;
import sistema_academico.Recursos.Recurso_Academico;

public interface Filtro_Recurso {
    boolean evaluar(Recurso_Academico recurso);
}
