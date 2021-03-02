package process.server.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import process.server.model.Address;

@Component
public class AddressRecoverDelegate implements JavaDelegate
{
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception
    {
        String postCode = (String) delegateExecution.getVariable("post-code");
        if(postCode.equals("03044000"))
            delegateExecution.setVariable("recovered-address", new Address("SP", "São Paulo", "rua Visconde de Parnaíba - Brás" ));
        else
            delegateExecution.setVariable("recovered-address", new Address("SP", "São Paulo", "rua Dona Ana Neri - Mooca" ));
    }
}
