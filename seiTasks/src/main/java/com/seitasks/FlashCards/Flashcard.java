package com.seitasks.FlashCards;

import java.io.Serializable;

public class Flashcard implements Serializable {
    private static final long serialVersionUID = 1L;
    
    String Pregunta;
    String Respuesta;
    
    public Flashcard(String Pregunta, String Respuesta) {
        this.Pregunta = Pregunta;
        this.Respuesta = Respuesta;
    }

    public String getPregunta() {
        return Pregunta;
    }

    public String getRespuesta() {
        return Respuesta;
    }

    public void setPregunta(String Pregunta) {
        this.Pregunta = Pregunta;
    }

    public void setRespuesta(String Respuesta) {
        this.Respuesta = Respuesta;
    }
}
