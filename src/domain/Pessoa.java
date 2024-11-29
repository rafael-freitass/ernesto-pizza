package domain;

import java.time.LocalDate;
import java.util.Date;

public class Pessoa {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;

    public Pessoa(LocalDate dataNascimento, String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }
    public Pessoa(LocalDate dataNascimento, String nome) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
