package edu.uniandes.ecos.ui;

import edu.uniandes.ecos.biz.FileBiz;
import edu.uniandes.ecos.vo.Aplicacion;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Alvaro
 */
public class Main {
    public static void main(String[] args){
        try {
            final List<Aplicacion> aplicaciones = FileBiz.buscarProyectos();
            PrintConsoleUtil.imprimirConsola(aplicaciones);
            
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
