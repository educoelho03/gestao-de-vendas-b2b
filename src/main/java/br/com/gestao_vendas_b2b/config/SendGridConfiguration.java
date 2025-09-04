package br.com.gestao_vendas_b2b.config;

import br.com.gestao_vendas_b2b.model.entities.SendGridProperties;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
@EnableConfigurationProperties(SendGridConfiguration.class)
public class SendGridConfiguration {

    private final SendGridProperties sendGridProperties;

    public SendGridConfiguration(SendGridProperties sendGridProperties) {
        this.sendGridProperties = sendGridProperties;
    }

    @Bean
    public SendGrid sendGrid(){
        String apiKey = sendGridProperties.getApiKey();
        return new SendGrid(apiKey);
    }

    @Bean
    public Email fromEmail() {
        String fromEmail = sendGridProperties.getSenderEmail();
        return new Email(fromEmail);
    }
}
