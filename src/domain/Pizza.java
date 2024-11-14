package domain;

import java.util.List;

public class Pizza {
    public String nome;
    public String sabor;
    public String [] ingredientes;
    public char tamanho;
    public double precoBase;

    public Pizza(String nome, String sabor, String [] ingredientes, char tamanho, double precoBase){
        this.nome = nome;
        this.sabor = sabor;
        this.ingredientes = ingredientes;
        this.tamanho = tamanho;
        this.precoBase = precoBase;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public char getTamanho() {
        return tamanho;
    }

    public void setTamanho(char tamanho) {
        this.tamanho = tamanho;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }
}
