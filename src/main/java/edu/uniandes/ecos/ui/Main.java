package edu.uniandes.ecos.ui;


import edu.uniandes.ecos.MeanService;
import edu.uniandes.ecos.StandardDeviationService;
import edu.uniandes.ecos.biz.RegressionBiz;
import edu.uniandes.ecos.util.FileUtil;
import edu.uniandes.ecos.vo.ParVO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Alvaro
 */
public class Main {
    public static void main(String[] args){
        
        System.out.println("Calculo de Regresion y Correlacion\n");
        
        try {
            System.out.println("Digite el nombre del archivo con las dos lista de numeros "
                + "a evaluar, debe colocarse en la carpeta /src/test/resources/: ");
            Scanner sc = new Scanner(System.in);
            String file = sc.next();
            System.out.println("\nArchivo de valores " + file + "\n");
            
            System.out.println("Digite el valor de Xk: ");
            Scanner sc2 = new Scanner(System.in);
            String xkString = sc2.next();

            LinkedList<ParVO> listPar = FileUtil.getListNumbers(file);
            
            Double xk = Double.parseDouble(xkString);
            
            Double b1 = RegressionBiz.getB1(listPar);
            
            Double b0 = RegressionBiz.getB0(listPar, b1);
            
            Double r = RegressionBiz.getR(listPar);
            
            Double yk = RegressionBiz.getYk(b0, b1, xk);

            System.out.println("xk: " + xk);
            System.out.println("b0: " + b0);
            System.out.println("b1: " + b1);
            System.out.println("rXY: " + r);
            System.out.println("r2: " + (r*r));
            System.out.println("yk: " + yk);


        } catch (FileNotFoundException ex) {
            System.out.println("No se encuentra el archivo especificado, se debe ubicar en la carpeta /src/test/resources/");
        } catch (IOException ex) {
            System.out.println("Error al leer el archivo especificado");
        } catch (NumberFormatException ex) {
            System.out.println("Error en el formato de los archivos deben haber dos numeros en cada linea separados por tabulacion, asi como el valor de xk deben ser Double");
        }
        System.out.println("\nFin de la aplicacion");
        
    }
}
