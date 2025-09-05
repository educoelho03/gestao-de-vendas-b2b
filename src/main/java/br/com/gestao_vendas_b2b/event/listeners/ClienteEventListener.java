package br.com.gestao_vendas_b2b.event.listeners;

import br.com.gestao_vendas_b2b.event.ClienteCadastradoEvent;
import br.com.gestao_vendas_b2b.service.EmailService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ClienteEventListener {

    private EmailService emailService;

    public ClienteEventListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @EventListener
    public void handleProdutoCadastradoEvent(ClienteCadastradoEvent event){
        String subject = "🚀 Bem-vindo(a) ao Sistema de Gestão de Vendas! - Cliente: " + event.getNome();
        String body = "Olá, Seja bem-vindo(a) ao nosso Sistema de Gestão de Vendas! Agora voce esta apto a realizar um pedido";

        emailService.sendMail(event.getEmail(), subject, body);
    }
}
