package br.com.gestao_vendas_b2b.event;

import org.springframework.context.ApplicationEvent;

public class ClienteCadastradoEvent extends ApplicationEvent {

    private String nome;
    private String email;

    public ClienteCadastradoEvent(Object source, String nome, String email) {
        super(source);
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
