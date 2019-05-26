package br.com.fiap.componentes.naciot;

public class IotPojo {
    private int id;
    private int hum;
    private int luz;
    private int buzzer;
    private int led;

    public IotPojo(int id, int hum, int luz, int buzzer, int led) {
        this.id = id;
        this.hum = hum;
        this.luz = luz;
        this.buzzer = buzzer;
        this.led = led;
    }

    public IotPojo(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHum() {
        return hum;
    }

    public void setHum(int hum) {
        this.hum = hum;
    }

    public int getLuz() {
        return luz;
    }

    public void setLuz(int luz) {
        this.luz = luz;
    }

    public int getBuzzer() {
        return buzzer;
    }

    public void setBuzzer(int buzzer) {
        this.buzzer = buzzer;
    }

    public int getLed() {
        return led;
    }

    public void setLed(int led) {
        this.led = led;
    }
}
