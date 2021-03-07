package process.server.model;

public class Result
{
    private final Person person;
    private final Address address;

    public Result(Person person, Address address)
    {
        this.person = person;
        this.address = address;
    }

    public Person getPerson()
    {
        return person;
    }

    public Address getAddress()
    {
        return address;
    }
}
