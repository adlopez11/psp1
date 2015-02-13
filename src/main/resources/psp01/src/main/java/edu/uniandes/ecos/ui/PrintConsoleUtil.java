/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.ui;

import edu.uniandes.ecos.vo.Aplicacion;
import edu.uniandes.ecos.vo.Clase;
import edu.uniandes.ecos.vo.Metodo;
import java.util.List;

/**
 *
 * @author Alvaro
 */
public class PrintConsoleUtil {
    
    public static void imprimirConsola(final List<Aplicacion> aplicaciones){
        System.out.println("LOC de Aplicaciones\n");
        for(int i = 0;i< aplicaciones.size();i++){
            Aplicacion aplicacion = aplicaciones.get(i);
            System.out.println("Aplicacion #"+(i+1)+"\n");
            System.out.println("Nombre: "+aplicacion.getNombre());
            System.out.println("Numero de Clases: "+aplicacion.getClases().size());
            System.out.println("Total LOC: "+getLineasTotales(aplicacion));
            System.out.println("Clases:\n");
            for(Clase clase: aplicacion.getClases()){
                System.out.println("Nombre Clase: "+clase.getNombre());
                System.out.println("LOC Clase: "+clase.getLineas());
                System.out.println("Numero de Metodos: "+clase.getMetodos().size());
                System.out.println("Metodos:");
                for(Metodo metodo : clase.getMetodos()){
                    System.out.println("Nombre Metodo: "+metodo.getNombre());
                    System.out.println("LOC Metodo: "+metodo.getLineas());
                }
            }
            System.out.println("\n");
        }
    }
    
    private static int getLineasTotales(final Aplicacion aplicacion){
        int cont =0;
        for(Clase clase: aplicacion.getClases()){
            cont = cont + clase.getLineas();
        }
        return cont;
    }
}
