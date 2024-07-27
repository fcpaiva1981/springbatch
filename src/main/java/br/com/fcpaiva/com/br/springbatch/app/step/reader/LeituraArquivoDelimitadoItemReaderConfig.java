package br.com.fcpaiva.com.br.springbatch.app.step.reader;

import br.com.fcpaiva.com.br.springbatch.entity.Cliente;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class LeituraArquivoDelimitadoItemReaderConfig {

    @StepScope
    @Bean
    public FlatFileItemReader<Cliente> leituraArquivoDelimitadoItemReader(
            @Value("#{jobParameters['arquivoClientesDelimitado']}" ) Resource arquivoClientes){
       return new FlatFileItemReaderBuilder<Cliente>()
               .name("leituraArquivoDelimitadoItemReader")
               .resource(arquivoClientes)
               .delimited()
               .names(new String[] {"nome", "sobrenome", "idade", "email"})
               .targetType(Cliente.class)
               .build();
    }
}
