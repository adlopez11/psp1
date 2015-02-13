package edu.uniandes.ecos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // Leer datos del archivo

        System.out.println("Calculo del Promedio y Desviacion Estandar\n");
        
        try {
            System.out.println("Digite el nombre del archivo con la lista de numeros "
                + "a evaluar, debe colocarse en la carpeta /src/test/resources/: ");
            Scanner sc = new Scanner(System.in);
            String file = sc.next();
            
            System.out.println("\nArchivo de valores " + file + "\n");

            LinkedList<Double> list = FileUtil.getListNumbers(file);

            System.out.println("Promedio: " + MeanService.calculateMean(list));

            System.out.println("Desviacion Estadar: " + StandardDeviationService.calculateStandardDeviation(list) + "\n");

        } catch (FileNotFoundException ex) {
            System.out.println("No se encuentra el archivo especificado, se debe ubicar en la carpeta /src/test/resources/");
        } catch (IOException ex) {
            System.out.println("Error al leer el archivo especificado");
        } catch (NumberFormatException ex) {
            System.out.println("Existen lineas que no son numeros");
        }
        System.out.println("\nFin de la aplicacion");
    }
}
