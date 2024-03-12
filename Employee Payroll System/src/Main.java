import java.util.ArrayList;
import java.util.List;

abstract class Employees{
    private String name;
    private int id;
    public Employees(String name,int id)
    {
        this.name=name;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employees[" +
                "name='" + name + '\'' +
                ", id=" + id +",Salary"+calculateSalary() +"]";
    }
}
class FullTimeEmployee extends Employees{
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }
    @Override
    public double calculateSalary(){
        return monthlySalary;
    }
}
class PartTimeEmployee extends Employees{
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
    @Override
    public double calculateSalary(){
        return hourlyRate*hoursWorked;
    }
}
class PayrollSystem {
    private List<Employees> employeesList;

    public PayrollSystem() {
        this.employeesList = new ArrayList<>(); // Initializing with ArrayList
    }


    public void addEmployess(Employees employees)
    {
        employeesList.add(employees);
    }
    public void removeEmployees(int id)
    {
//        Employees removeToRemove=null;
        for (Employees employees: employeesList)
        {
           if (employees.getId()==id)
           {
               employeesList.remove(employees);
               break;
           }
           else {
               System.out.println("Employee Not Found");
           }
        }
    }
    public void displayEmployees()
    {
        for (Employees employees:employeesList)
        {
            System.out.println(employees);
        }
    }
    public Employees serchEmployess(int id)
    {
        for (Employees employees:employeesList)
        {
            if (employees.getId()==id)
            {
                return employees;
            }


        }
        return null;
    }

}

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem=new PayrollSystem();
        FullTimeEmployee emp1=new FullTimeEmployee("naran khadka",1,3402020);
        PartTimeEmployee emp2=new PartTimeEmployee("Manisha",2,40,100);
       payrollSystem.addEmployess(emp1);

       payrollSystem.addEmployess(emp2);

        System.out.println("Initial Employess details:");

       payrollSystem.displayEmployees();
        System.out.println("removing the employee using the ID");
        payrollSystem.removeEmployees(1);
        payrollSystem.displayEmployees();
        payrollSystem.serchEmployess(1);
        payrollSystem.displayEmployees();




    }
}
