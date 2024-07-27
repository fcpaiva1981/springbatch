package br.com.fcpaiva.com.br.springbatch.app.step;

import br.com.fcpaiva.com.br.springbatch.entity.Cliente;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeituraArquivoDelimitadoStepConfig {
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step leituraArquivoDelimitadoStep(ItemReader<Cliente> leituraArquivoDelimitadoItemReader,
                                             ItemWriter<Cliente> leituraArquivoDelimitadoItemWriter) {
        return stepBuilderFactory
                .get("leituraArquivoDelimitadoStep")
                .<Cliente,Cliente>chunk(1)
                .reader(leituraArquivoDelimitadoItemReader)
                .writer(leituraArquivoDelimitadoItemWriter)
                .build();
    }
}
