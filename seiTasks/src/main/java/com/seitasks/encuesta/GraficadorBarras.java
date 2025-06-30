package com.seitasks.encuesta;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.util.List;

public class GraficadorBarras {

    public static void mostrarGraficoBarras(List<RespuestaEncuesta> respuestas) {
        if (respuestas == null || respuestas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay datos para mostrar.");
            return;
        }

        int total = respuestas.size();
        double sumaProductividad = 0, sumaMetas = 0, sumaSatisfaccion = 0, sumaMetodo = 0, sumaEstres = 0;

        for (RespuestaEncuesta r : respuestas) {
            sumaProductividad += r.productividad;
            sumaMetas += r.metas;
            sumaSatisfaccion += r.satisfaccion;
            sumaMetodo += r.metodo;
            sumaEstres += r.estres;
        }

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(sumaProductividad / total, "Promedio", "Productividad");
        dataset.addValue(sumaMetas / total, "Promedio", "Metas");
        dataset.addValue(sumaSatisfaccion / total, "Promedio", "Satisfacción");
        dataset.addValue(sumaMetodo / total, "Promedio", "Método");
        dataset.addValue(sumaEstres / total, "Promedio", "Estrés");

        JFreeChart chart = ChartFactory.createBarChart(
            "Promedios de la Encuesta",
            "Categoría",
            "Valor Promedio",
            dataset
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));

        JFrame ventana = new JFrame("Gráfico de Encuesta");
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.setContentPane(chartPanel);
        ventana.pack();
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }
}
