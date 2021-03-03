package process.server.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class AggregateInformationDelegate implements JavaDelegate
{
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception
    {
        String person =  (String) delegateExecution.getVariable("person");
        String recoveredAdress = (String) delegateExecution.getVariable("recovered-address");
    }
}
