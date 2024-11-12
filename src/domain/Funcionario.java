package domain;

import java.util.Date;

public class Funcionario extends Pessoa{
    private String cargo;

    public Funcionario(String nome, String cpf, Date dataNascimento, String cargo){
        super(dataNascimento, nome, cpf);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
