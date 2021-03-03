package process.server.delegate;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateVariableMapping;
import org.camunda.bpm.engine.delegate.VariableScope;
import org.camunda.bpm.engine.variable.VariableMap;
import org.springframework.stereotype.Component;
import process.server.model.Person;

@Component
public class PostCodeVariableMapping implements DelegateVariableMapping
{
    @SneakyThrows
    @Override
    public void mapInputVariables(DelegateExecution delegateExecution, VariableMap variableMap)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        final Person person = objectMapper.readValue((String) delegateExecution.getVariable("person"), Person.class);
        variableMap.putValue("post-code", person.getPostCode());
    }

    @Override
    public void mapOutputVariables(DelegateExecution delegateExecution, VariableScope variableScope)
    {
        delegateExecution.setVariable("recovered-address", variableScope.getVariable("recovered-address"));
    }
}
