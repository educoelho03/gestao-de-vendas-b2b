package br.com.gestao_vendas_b2b.event.listeners;

import br.com.gestao_vendas_b2b.event.FuncionarioCadastradoEvent;
import br.com.gestao_vendas_b2b.service.EmailService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioEventListener { // ESTE LISTENER OUVE O "FUNCIONARIO CADASTRADO EVENT", quando ele é criado ele envia o email

    private final EmailService emailService;

    public FuncionarioEventListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @EventListener
    public void handleFuncionarioCadastrado(FuncionarioCadastradoEvent event) {
        String subject = "🚀 Bem-vindo(a) ao Sistema de Gestão de Vendas! - Funcionario: " + event.getNome();
        String body = "Olá, Seja bem-vindo(a) ao nosso Sistema de Gestão de Vendas! ";

        emailService.sendMail(event.getEmail(), subject, body);
    }
}
