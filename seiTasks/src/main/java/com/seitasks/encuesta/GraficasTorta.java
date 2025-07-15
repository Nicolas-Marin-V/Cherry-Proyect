package com.seitasks.encuesta;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class GraficasTorta extends JFrame {

    public GraficasTorta(String title, JFreeChart chart) {
        super(title);
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void mostrarGraficas(List<RespuestaEncuesta> respuestas) {
        if (respuestas == null || respuestas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay datos para graficar.");
            return;
        }

        mostrarGraficoMetodo(respuestas);
        mostrarGraficoHorario(respuestas);
    }

    private static void mostrarGraficoMetodo(List<RespuestaEncuesta> respuestas) {
        int conMetodo = 0, sinMetodo = 0;
        for (RespuestaEncuesta r : respuestas) {
            if (r.programa == 1) conMetodo++;
            else sinMetodo++;
        }

        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Pomodoro", conMetodo);
        dataset.setValue("FlashCards", sinMetodo);

        JFreeChart chart = ChartFactory.createPieChart(
                "Uso del Método de Estudio",
                dataset,
                true,
                true,
                false
        );

        new GraficasTorta("Método de estudio", chart).setVisible(true);
    }

    private static void mostrarGraficoHorario(List<RespuestaEncuesta> respuestas) {
        int madrugada = 0, mañana = 0, tarde = 0, noche = 0;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        for (RespuestaEncuesta r : respuestas) {
            try {
                LocalTime hora = LocalTime.parse(r.hora, formatter);
                int h = hora.getHour();

                if (h >= 0 && h < 6) madrugada++;
                else if (h < 12) mañana++;
                else if (h < 18) tarde++;
                else noche++;

            } catch (Exception e) {
                System.out.println("Hora inválida: " + r.hora);
            }
        }

        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Madrugada (00–05)", madrugada);
        dataset.setValue("Mañana (06–11)", mañana);
        dataset.setValue("Tarde (12–17)", tarde);
        dataset.setValue("Noche (18–23)", noche);

        JFreeChart chart = ChartFactory.createPieChart(
                "Distribución Horaria de Estudio",
                dataset,
                true,
                true,
                false
        );

        new GraficasTorta("Horarios", chart).setVisible(true);
    }
}
