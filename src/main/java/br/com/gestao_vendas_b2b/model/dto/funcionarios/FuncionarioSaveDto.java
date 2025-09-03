package br.com.gestao_vendas_b2b.model.dto.funcionarios;

import br.com.gestao_vendas_b2b.model.enums.Cargo;

public class FuncionarioSaveDto {

    private String nome;
    private String email;
    private String senha;
    private Cargo cargo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}
