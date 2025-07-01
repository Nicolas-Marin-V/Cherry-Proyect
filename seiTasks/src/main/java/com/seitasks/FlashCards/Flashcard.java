
package com.seitasks.FlashCards;

/**
 *
 * @author esteb
 */
public class Flashcard {

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
