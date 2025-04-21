//This is the superclass which represents the staff hiring process
public class StaffHire {
    
    //these are the private attributes regards to the job vacancy 
    private int vacancyNumber;
    
    private String designation;
    
    private String jobType;
    //these are the same but protected attributes in regards to the staff being hired
    
    protected String staffName;
    
    protected String joiningDate;
    
    protected String qualification;
    
    protected String appointedBy;
    
    protected boolean joined;

    //These are the constructors that initialise all of the attributes for staff hire
    public StaffHire(int vacancyNumber, String designation, String jobType, String staffName, String joiningDate,
                     String qualification, String appointedBy, boolean joined) {
        
        this.vacancyNumber = vacancyNumber;
        
        this.designation = designation;
        
        this.jobType = jobType;
        
        this.staffName = staffName;
        
        this.joiningDate = joiningDate;
        
        this.qualification = qualification;
        
        this.appointedBy = appointedBy;
        
        this.joined = joined;
    }
    

    //These are the getter methods for the attributes
    public int getVacancyNumber() {
        return vacancyNumber;
    }

    public String getDesignation() {
        return designation;
    }

    public String getJobType() {
        return jobType;
    }

    public String getStaffName() {
        return staffName;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public String getQualification() {
        return qualification;
    }

    public String getAppointedBy() {
        return appointedBy;
    }

    public boolean getJoined() {
        return joined;
    }

    //These are the setter methods for the fields that are going to be edited
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void setAppointedBy(String appointedBy) {
        this.appointedBy = appointedBy;
    }

    public void setJoined(boolean joined) {
        this.joined = joined;
    }

    //These are the display methods that show staff and vacancy info
    public void display() {
        System.out.println("Vacancy Number: " + vacancyNumber);
        
        System.out.println("Designation: " + designation);
        
        System.out.println("Job Type: " + jobType);
        
        //These only display, once someone has been hired
        if (joined) {
            System.out.println("Staff Name: " + staffName);
            
            System.out.println("Joining Date: " + joiningDate);
            
            System.out.println("Qualification: " + qualification);
            
            System.out.println("Appointed By: " + appointedBy);
        } else {
            System.out.println("No staff has been hired yet.");
        }
    }
}