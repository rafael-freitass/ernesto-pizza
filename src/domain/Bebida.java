package domain;

public class Bebida {
    public String nome;
    public String tipo;
    public double preco;

    public Bebida(String nome, String tipo, double preco) {
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
