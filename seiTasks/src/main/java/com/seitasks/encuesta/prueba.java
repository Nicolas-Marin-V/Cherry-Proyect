package com.seitasks.encuesta;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class prueba {
    public static void main(String[] args) {
        String archCSV = "src/main/java/com/seitasks/encuesta/dummy.csv";

        try {
            CSVReader csvReader = new CSVReader(new FileReader(archCSV));
            String[] fila = null;

            while ((fila = csvReader.readNext()) != null) {
                System.out.println(fila[0]
                        + " | " + fila[1]
                        + " |  " + fila[2]);
            }

            csvReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
        } catch (CsvValidationException e) {
            System.out.println("Error al validar el CSV: " + e.getMessage());
        }
    }
}



