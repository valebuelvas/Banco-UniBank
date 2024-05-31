package model;

public class Datos {
    private String nombre1;
    private String nombre2;
    private String apellido;
    private int nCuenta;
    private double saldo;

    public Datos(String nombre1, String nombre2, String apellido, int nCuenta, double saldo) {
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido = apellido;
        this.nCuenta = nCuenta;
        this.saldo = saldo;
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

    public int getNCuenta() {
        return nCuenta;
    }

    public void setNCuenta(int nCuenta) {
        this.nCuenta = nCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
