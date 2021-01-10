import java.util.Comparator;
public class lastNameComparator implements Comparator<Employee>
{
    public int compare(Employee a, Employee b)
    {
        // If Last Name Are Same
        if( a.getLastName().equals(b.getLastName() ))
        {
            // If First Name Are Same
            if(a.getFirstName().equals(b.getFirstName()))
            {
                // Order By ID NUM
                return a.getId() - (b.getId());
            }
            else
            {
                // Order By First Name
                return a.getFirstName().compareTo(b.getFirstName());
            }
        }
        else
        {
            // Order By Last Name
            return a.getLastName().compareTo(b.getLastName());
        }
    }
}
