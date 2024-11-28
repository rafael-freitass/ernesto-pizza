package domain;

import enums.Tamanho;

public class Pizza {
    public String sabor;
    public String [] ingredientes;
    public Tamanho tamanho; // AQUI
    public double precoBase;

    public Pizza(String sabor, String [] ingredientes, double precoBase){
        this.sabor = sabor;
        this.ingredientes = ingredientes;
        this.precoBase = precoBase;
        // TAMANHO
    }

    public double calcularPreco(Tamanho tamanho){
        return precoBase * tamanho.getFator();
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String [] getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String [] ingredientes) {
        this.ingredientes = ingredientes;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }
}
