package onboarding.analyzer;

import com.knowledge.component.ExternalTaskController;
import lombok.SneakyThrows;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;
import java.util.Collections;

@ExternalTaskController(topic = "pedidos_analise")
public class DataAnalyzerExternalTask implements ExternalTaskHandler{

    private static final Logger LOG = LoggerFactory.getLogger(DataAnalyzerExternalTask.class);

    @SneakyThrows
    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService)
    {
        LOG.info("  -> External Task started: {}", this.getClass().getName());

        final String correlationId = generateUUID();

        LOG.info("      ----> Correlation ID: {}", correlationId);
        LOG.info("      ----> Message: {}", (String) externalTask.getVariable("data"));

        externalTaskService.complete(externalTask,
                Collections.singletonMap("correlation_id", correlationId));
    }

    private boolean dataIsOK(String data)
    {
        return data.contains("NOK");
    }

    private String generateUUID()
    {
        return UUID.randomUUID().toString();
    }

}
