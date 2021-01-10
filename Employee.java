import java.util.Comparator;
public class Employee
{
    private String firstName;
    private String lastName;
    private int id;

    public Employee()
    {
        firstName = "";
        lastName = "";
        id = 0;
    }

    public Employee(String first, String last, int num)
    {
        firstName = first;
        lastName = last;
        id = num;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID: " + id + " LastName: " + lastName + " First name: " + firstName + " Performance:" + " ";
    }

    public boolean equals(Employee e)
    {
        if(firstName.equals(e.getFirstName()) && lastName.equals(e.getLastName()) && id == e.getId())
        {
            return true;
        }
        else
        {
            return false;
        }

    }
    public int hashCode()
    {
        final int HASH_MULTIPLIER = 29;
        int h = HASH_MULTIPLIER * firstName.hashCode() + lastName.hashCode();
        h = HASH_MULTIPLIER * h + ((Integer)id).hashCode();
        return h;
    }
}
