package domain;

import java.util.List;

public class Pedido {
    private Cliente cliente;
    public List<Pizza> listaPizzas;
    public List<Bebida> listaBebidas;
    public double precoTotal;
    public String status;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Pizza> getListaPizzas() {
        return listaPizzas;
    }

    public void setListaPizzas(List<Pizza> listaPizzas) {
        this.listaPizzas = listaPizzas;
    }

    public List<Bebida> getListaBebidas() {
        return listaBebidas;
    }

    public void setListaBebidas(List<Bebida> listaBebidas) {
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
