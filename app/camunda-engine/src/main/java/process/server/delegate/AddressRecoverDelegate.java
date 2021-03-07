package process.server.delegate;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import process.server.model.Address;

@Component
public class AddressRecoverDelegate implements JavaDelegate
{
    private final ObjectMapper objectMapper;

    public AddressRecoverDelegate(ObjectMapper objectMapper)
    {
        this.objectMapper = objectMapper;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception
    {
        String postCode = (String) delegateExecution.getVariable("post-code");
        if(postCode.equals("03044000"))
            delegateExecution.setVariable("recovered-address", getAddress(true));
        else
            delegateExecution.setVariable("recovered-address", getAddress(false));
    }

    private String getAddress(boolean isPhHome)
    {
        Address phAddress =  new Address("SP", "São Paulo", "Rua Visconde de Paraíba");
        Address notPhAddress = new Address("SP", "São Paulo", "rua Dona Ana Neri - Mooca");
        return isPhHome ? serializeAddress(phAddress) : serializeAddress(notPhAddress);

    }

    private String serializeAddress(Address address)
    {
        String serializedAddress = objectMapper.valueToTree(address).toString();
        return serializedAddress;
    }
}
