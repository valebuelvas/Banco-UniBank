package model;

public class Cliente {
    private int consecutivo;
    private String id;
    private String nombre1;
    private String nombre2;
    private String apellido;

    public Cliente(int consecutivo, String id, String nombre1, String nombre2, String apellido) {
        this.consecutivo = consecutivo;
        this.id = id;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido = apellido;
    }

    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
