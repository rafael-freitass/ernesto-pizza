package domain;

import enums.Tamanho;

import javax.swing.text.TabableView;
import java.util.List;

public class Pizza {
    public String nome;
    public String sabor;
    public String [] ingredientes;
    public Tamanho tamanho;
    public double precoBase;

    public Pizza(String sabor, String [] ingredientes, double precoBase){
        this.sabor = sabor;
        this.ingredientes = ingredientes;
        this.precoBase = precoBase;
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
