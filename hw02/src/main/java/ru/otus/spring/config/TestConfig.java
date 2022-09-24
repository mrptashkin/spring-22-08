package ru.otus.spring.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.otus.spring.control.QuestionParser;
import ru.otus.spring.control.QuestionParserImpl;
import ru.otus.spring.domain.*;

@Configuration
@PropertySource("classpath:/application.properties")
public class TestConfig {



    @Bean
    QuestionParser questionParser(@Value("${db.url}") String resource) {
        return new QuestionParserImpl(resource);
    }

}
