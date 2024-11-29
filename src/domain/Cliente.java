package domain;

import java.time.LocalDate;

public class Cliente extends Pessoa {
    private String telefone;
    private String endereco;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Cliente(String nome, String cpf, LocalDate dataNascimento, String telefone, String endereco) {
        super(dataNascimento, nome, cpf);
        this.telefone = telefone;
        this.endereco = endereco;
    }
    public Cliente(String nome, LocalDate dataNascimento, String telefone, String endereco) {
        super(dataNascimento, nome);
        this.telefone = telefone;
        this.endereco = endereco;
    }
}
