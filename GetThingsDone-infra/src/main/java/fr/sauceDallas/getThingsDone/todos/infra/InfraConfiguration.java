package fr.sauceDallas.getThingsDone.todos.infra;

import fr.sauceDallas.getThingsDone.alerts.infrastructure.EmailAlertSender;
import fr.sauceDallas.getThingsDone.todos.infra.emailSender.EmailAlertSenderImpl;
import fr.sauceDallas.getThingsDone.todos.infra.hibernate.TodoUpdatedEventHibernateRepository;
import fr.sauceDallas.getThingsDone.todos.infra.hibernate.TodosHibernateRepository;
import fr.sauceDallas.getThingsDone.todos.infra.repository.TodosRepositoryImpl;
import fr.sauceDallas.getThingsDone.todos.infra.repository.TodosUpdatedEventRepositoryImpl;
import fr.sauceDallas.getThingsDone.todos.infrastructure.TodosRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.mail.javamail.JavaMailSender;
import org.thymeleaf.TemplateEngine;

@Configuration
@EnableJpaRepositories("fr.sauceDallas.getThingsDone.todos.infra.hibernate")
@EntityScan("fr.sauceDallas.getThingsDone.todos.infra.hibernate")
public class InfraConfiguration {

    @Bean
    TodosRepository todosRepository(TodosHibernateRepository todosHibernateRepository) {
        return new TodosRepositoryImpl(todosHibernateRepository);
    }

    @Bean
    TodosUpdatedEventRepositoryImpl todoUpdatedEventRepository(TodoUpdatedEventHibernateRepository repository) {
        return new TodosUpdatedEventRepositoryImpl(repository);
    }

    @Bean
    EmailAlertSender emailAlertSender(JavaMailSender mailSender, TemplateEngine templateEngine) {
        return new EmailAlertSenderImpl(mailSender, templateEngine);
    }
}
