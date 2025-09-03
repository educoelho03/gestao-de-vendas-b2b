package br.com.gestao_vendas_b2b.service;

import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmailService {

    private static final String EMAIL_ENDPOINT = "mail/send";

    private final SendGrid sendGrid;
    private final Email fromEmail;

    public EmailService(SendGrid sendGrid, Email fromEmail) {
        this.sendGrid = sendGrid;
        this.fromEmail = fromEmail;
    }

    public void sendMail(String to, String subject, String body){
        Email toEmail = new Email(to);
        Content content = new Content("text/plain", body);
        Mail mail = new Mail(fromEmail, subject, toEmail, content);

        try {
            Request request = new Request();
            request.setMethod(Method.POST);
            request.setEndpoint(EMAIL_ENDPOINT);
            request.setBody(mail.build());

            sendGrid.api(request);

        } catch (IOException e) {
            throw new RuntimeException("Erro no envio de emails: " + e);
        }

    }
}
