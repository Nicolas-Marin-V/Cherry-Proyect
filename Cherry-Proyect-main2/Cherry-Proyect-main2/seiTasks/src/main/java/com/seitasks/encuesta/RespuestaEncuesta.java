package com.seitasks.encuesta;

public class RespuestaEncuesta {
    public int productividad;
    public int metas;
    public int satisfaccion;
    public int metodo;
    public int estres;
    public String hora;
    public int programa;

    public RespuestaEncuesta(int productividad, int metas, int satisfaccion, int metodo, int estres, String hora, int programa) {
        this.productividad = productividad;
        this.metas = metas;
        this.satisfaccion = satisfaccion;
        this.metodo = metodo;
        this.estres = estres;
        this.hora = hora;
        this.programa = programa;
    }

    
}
