package com.seitasks.encuesta;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LectorEncuesta {

    public static List<RespuestaEncuesta> leerResultados() {
        List<RespuestaEncuesta> resultados = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader("src/main/java/com/seitasks/encuesta/resultados.csv"))) {
            String[] fila;
            reader.readNext();
            while ((fila = reader.readNext()) != null && fila.length == 7) {
                int productividad = Integer.parseInt(fila[0]);
                int metas = Integer.parseInt(fila[1]);
                int satisfaccion = Integer.parseInt(fila[2]);
                int metodo = Integer.parseInt(fila[3]);
                int estres = Integer.parseInt(fila[4]);
                String hora = fila[5];
                int programa = Integer.parseInt(fila[6]);

                resultados.add(new RespuestaEncuesta(productividad, metas, satisfaccion, metodo, estres,hora,programa));
            }
        } catch (Exception e) {
            System.out.println("Error leyendo archivo: " + e.getMessage());
        }
        return resultados;
    }
}
