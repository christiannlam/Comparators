import java.util.*;
public class Main
{
    public static void main(String[] args) {
        Map<Employee,String> gradeMap = new HashMap<Employee,String>();
        Map<Integer,Employee> employeeMap = new HashMap<Integer,Employee>();
        Scanner input = new Scanner (System.in);
        int userInput = 0;
        printMenuAndGetChoice();
        System.out.println("Enter An Option: ");
        while( userInput != 5)
        {
            userInput = input.nextInt();
            if( userInput == 1)
            {
                addEmployee(employeeMap,gradeMap);
            }
            else if ( userInput == 2)
            {
                removeEmployee(employeeMap,gradeMap);
            }
            else if( userInput == 3)
            {
                modifyPerformance(employeeMap,gradeMap);
            }
            else if( userInput == 4)
            {
                print(gradeMap);
            }
            else if( userInput == 5)
            {
                break;
            }
            printMenuAndGetChoice();
        }
    }

    public static void printMenuAndGetChoice()
    {
        System.out.println("1) Add Employee" + "\n2) Remove Employee" + "\n3) Modify Performance"
                                + "\n4) Display" + "\n5) Quit");
    }

    public static void addEmployee(Map<Integer,Employee> employee, Map<Employee,String> performance)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter First Name Of Employee: ");
        String firstName = input.next();
        System.out.println("Enter Last Name Of Employee: ");
        String lastName = input.next();
        System.out.println("Enter ID Num Of Employee: ");
        int id = input.nextInt();
        System.out.println("Enter Performance Score Of Employee: ");
        String score = input.next();

        while(employee.containsKey(id))
        {
            System.out.println("Employee ID Already Exists. Enter New ID: ");
            id = input.nextInt();

        }
        Employee newEmployee = new Employee(firstName,lastName,id);
        employee.put(newEmployee.getId(),newEmployee);
        performance.put(newEmployee,score);
    }

    public static void removeEmployee(Map<Integer,Employee> employee, Map<Employee,String> performance)
    {
        System.out.println("Enter An Employee ID To Be Removed: ");
        Scanner input = new Scanner(System.in);
        int id = input.nextInt();
        performance.remove(employee.get(id));
        employee.remove(id);
    }

    public static void modifyPerformance(Map<Integer,Employee> employeeMap, Map<Employee,String> gradeMap)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter ID Num To Modify Score: ");
        int id = input.nextInt();
        while(!employeeMap.containsKey(id))
        {
            System.out.println("Employee Does Not Exist. Enter New ID: ");
            id = input.nextInt();
        }
        System.out.println("Enter New Score: ");
        String performance = input.next();
        gradeMap.put(employeeMap.get(id),performance);
    }
    public static void print(Map<Employee,String> gradeMap)
    {
        Set<Employee> employees = gradeMap.keySet();
        List<Employee> employeeList = new ArrayList<Employee>(employees);
        Collections.sort(employeeList,new lastNameComparator());
        employees = new LinkedHashSet<>(employeeList);
        for (Employee em : employees)
        {
            System.out.println(em.toString() + gradeMap.get(em));
        }
    }

}
