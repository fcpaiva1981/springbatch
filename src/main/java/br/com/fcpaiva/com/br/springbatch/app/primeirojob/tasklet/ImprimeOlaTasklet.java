package br.com.fcpaiva.com.br.springbatch.app.primeirojob.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@StepScope
public class ImprimeOlaTasklet implements Tasklet{
    @Value("#{jobParameters['nome']}")
    private String nome;


    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        System.out.println(String.format("Olá Mundo! %s",nome));
        return RepeatStatus.FINISHED;
    }
}
