package fr.sauceDallas.getThingsDone.app.ui;


import fr.sauceDallas.getThingsDone.alerts.infrastructure.EmailAlertSender;
import fr.sauceDallas.getThingsDone.app.GetThingsDoneConfiguration;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@TestConfiguration
@EnableWebMvc
@EnableAutoConfiguration
@Import(GetThingsDoneConfiguration.class)
public class ITConfiguration {

    @Bean
    @Scope("cucumber-glue")
    public TodoWorld todoWorld() {
        return new TodoWorld();
    }

    @Bean
    @Primary
    public EmailAlertSender EmailAlertSender() {
        return Mockito.mock(EmailAlertSender.class);
    }
}
