//This is the subclass for hiring full time staff only which adds onto the original staffhire class
public class FullTimeStaffHire extends StaffHire {
    //These fields are exclusive only to full time staff
    private double salary;
    
    private int weeklyFractionalHours;

    //Constructor for initialising superclass and subclass
    public FullTimeStaffHire(int vacancyNumber, String designation, String jobType, String staffName, String joiningDate,
                             String qualification, String appointedBy, boolean joined, double salary, double wagesPerHour, int weeklyFractionalHours) {
        //Call to parent constructor
                                 super(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, joined);
        
                                 this.salary = salary;
        this.weeklyFractionalHours = weeklyFractionalHours;
    }

    //Getter method used for salary
    public double getSalary() {
        return salary;
    }
    //Setter method used for updating salary
    public void setSalary(double salary) {
        this.salary = salary;
    }

    //Setter method for working hours 
    public int getWeeklyFractionalHours() {
        return weeklyFractionalHours;
    }
    //To update the code above
    public void setWeeklyFractionalHours(int weeklyFractionalHours) {
        this.weeklyFractionalHours = weeklyFractionalHours;
    }

    //Overridden dispaly method that shows full time employee details
    @Override 
    public void display() {
        //Shows staff information using parent method
        super.display();
        System.out.println("Salary: " + salary);
        System.out.println("Weekly Fractional Hours: " + weeklyFractionalHours);
    }
}