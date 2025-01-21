/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistema_academico.interfaces;
import sistema_academico.Recursos.Recurso_Academico;

/**
 *
 * @author ivan
 */
public interface Evaluable {
    double obtenerPuntuaje();
    void realizarEvaluacion(Evaluador evaluador);
    
   
}


