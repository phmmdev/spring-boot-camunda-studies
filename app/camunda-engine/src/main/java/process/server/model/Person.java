package process.server.model;

public class Person
{
    private String name;
    private int age;
    private String postCode;

    public Person()
    {
    }

    public Person(String name, int age, String postCode)
    {
        this.name = name;
        this.age = age;
        this.postCode = postCode;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public String getPostCode()
    {
        return postCode;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setPostCode(String postCode)
    {
        this.postCode = postCode;
    }
}
