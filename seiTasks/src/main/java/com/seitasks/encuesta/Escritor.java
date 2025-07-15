package com.seitasks.encuesta;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Escritor {

    public static void escribirResultados(int productividad, int alcance, int satisfaccion, int importancia, int estres, String hora, int programa) {
        try {
            CSVWriter csvWriter = new CSVWriter(new FileWriter("resultados.csv", true)); 

            String[] fila = new String[7];
            fila[0] = String.valueOf(productividad);
            fila[1] = String.valueOf(alcance);
            fila[2] = String.valueOf(satisfaccion);
            fila[3] = String.valueOf(importancia);
            fila[4] = String.valueOf(estres);
            fila[5] = String.valueOf(hora);
            fila[6] = String.valueOf(programa);
            csvWriter.writeNext(fila);
            csvWriter.close();

            System.out.println("Datos escritos correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
