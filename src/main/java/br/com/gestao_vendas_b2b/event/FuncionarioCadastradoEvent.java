package br.com.gestao_vendas_b2b.event;

import br.com.gestao_vendas_b2b.model.entities.Funcionario;
import org.springframework.context.ApplicationEvent;

public class FuncionarioCadastradoEvent extends ApplicationEvent { // ESSE EVENTO VAI CARREGAR AS INFORMAÇÕES NECESSARIAS PARA ENVIAR O EMAIL

    private final String email;
    private final String nome;

    public FuncionarioCadastradoEvent(Object source, String email, String nome) {
        super(source);
        this.email = email;
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }
}
