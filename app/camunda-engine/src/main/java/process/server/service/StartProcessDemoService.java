package process.server.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import process.server.model.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class StartProcessDemoService
{
    @Autowired
    private RuntimeService runtimeService;

    @SneakyThrows
    public void startProcess(Person person)
    {
        ObjectMapper objectMapper =  new ObjectMapper();
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("person", objectMapper.writeValueAsString(person));
        runtimeService.startProcessInstanceByKey("address-recovery", variables);
    }
}
