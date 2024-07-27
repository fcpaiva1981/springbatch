package br.com.fcpaiva.com.br.springbatch.primeiroImprimeOlaJob;



import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableBatchProcessing
public class PrimeiroImprimeOlaJobParametrizadoBatch {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job primeiroImprimeOlaJobParametrizado() {
        return jobBuilderFactory
                .get("imprimeOlaJob")
                .start(imprimeOlaStepParametrizado())
                .incrementer(new RunIdIncrementer() )
                .build();
    }

    @Bean
    public Step imprimeOlaStepParametrizado() {
        return stepBuilderFactory
                .get("imprimeOlaStep")
                .tasklet(getTaskletParametrizado(null))
                .build();
    }

    @Bean
    @StepScope
    public  Tasklet getTaskletParametrizado(@Value("#{jobParameters['nome']}") String nome) {
        return new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                System.out.println(String.format("Olá Mundo! %s",nome));
                return RepeatStatus.FINISHED;
            }
        };
    }

}
