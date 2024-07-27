package br.com.fcpaiva.com.br.springbatch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;

import java.nio.file.FileSystem;

@Configuration
public class PropsConfig {

    @Bean
    public PropertySourcesPlaceholderConfigurer config() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setLocation(new FileSystemResource("/Users/fernandocampos/Estudos/SpringBatch/externalProps/application.yml"));
        return configurer;
    }
}
