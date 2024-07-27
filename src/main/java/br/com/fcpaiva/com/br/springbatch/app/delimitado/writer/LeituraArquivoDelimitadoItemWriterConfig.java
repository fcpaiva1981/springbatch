package br.com.fcpaiva.com.br.springbatch.app.delimitado.writer;

import br.com.fcpaiva.com.br.springbatch.entity.Cliente;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeituraArquivoDelimitadoItemWriterConfig {

    @Bean
    public ItemWriter<Cliente>  leituraArquivoDelimitadoItemWriter(){
        return items -> items.forEach(System.out::println);
    }
}
