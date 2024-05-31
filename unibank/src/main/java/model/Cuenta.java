package model;

public class Cuenta {
    private int numCuenta;
    private Cliente cliente;
    private double saldo;

    public Cuenta(int numCuenta, Cliente cliente, double saldo) {
        this.numCuenta = numCuenta;
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
