package process.server.delegate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.spin.plugin.variable.SpinValues;
import org.camunda.spin.plugin.variable.value.JsonValue;
import org.springframework.stereotype.Component;
import process.server.model.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AggregateInformationDelegate implements JavaDelegate
{
    private final ObjectMapper objectMapper;
    private final ObjectWriter objectWriter;

    public AggregateInformationDelegate(ObjectMapper objectMapper)
    {
        this.objectMapper = objectMapper;
        this.objectWriter = this.objectMapper.writer();
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception
    {
        final Person person = objectMapper.readValue((String) delegateExecution.getVariable("person"), Person.class);
        final Address address = objectMapper.readValue((String) delegateExecution.getVariable("recovered-address"), Address.class);
        final Result result = new Result(person, address);
        delegateExecution.setVariable("result", objectWriter.writeValueAsString(objectMapper.valueToTree(result)));

        /*JsonValue jsonValue = SpinValues.jsonValue(result.toString()).create();
        delegateExecution.setVariable("result", jsonValue);*/
    }
}
