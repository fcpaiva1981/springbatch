package br.com.fcpaiva.com.br.springbatch.app.largurafixa.writer;

import br.com.fcpaiva.com.br.springbatch.entity.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeituraArquivoLarguraFixaWriterConfig {

    @Bean
    public ItemWriter<Cliente> leituraArquivoLarguraFixaItemWriter() {
        return items -> items.forEach(System.out::println);
    }
}
