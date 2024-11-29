package domain;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    public ArrayList<Pizza> listaPizzas;
    public ArrayList<Bebida> listaBebidas;
    public double precoTotal;
    public String status;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Pizza> getListaPizzas() {
        return listaPizzas;
    }

    public void setListaPizzas(ArrayList<Pizza> listaPizzas) {
        this.listaPizzas = listaPizzas;
    }

    public ArrayList<Bebida> getListaBebidas() {
        return listaBebidas;
    }

    public void setListaBebidas(ArrayList<Bebida> listaBebidas) {
        this.listaBebidas = listaBebidas;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
