public class PartTimeStaffHire extends StaffHire {
    // Part-time exclusive fields
    private double wagesPerHour;
    private int workingHours;
    private String shift;
    private boolean terminated;

    // Constructor that are the same as StaffHire's parameters
    public PartTimeStaffHire(int vacancyNumber, String designation, String jobType,
                           String staffName, String joiningDate, String qualification,
                           String appointedBy, boolean joined,
                           double wagesPerHour, int workingHours, String shift) {
        
        super(vacancyNumber, designation, jobType, staffName, joiningDate,
              qualification, appointedBy, joined);
        
        //This sets part-time exclusive fields
        this.wagesPerHour = wagesPerHour;
        
        this.workingHours = workingHours;
        
        this.shift = shift;
        
        this.terminated = false;
    }

    // Getters
    public double getWagesPerHour() { return wagesPerHour; }
    public int getWorkingHours() { return workingHours; }
    public String getShift() { return shift; }
    public boolean isTerminated() { return terminated; }

    // Terminate method
    public void terminate() {
        if (!terminated) {
            setStaffName("");
            
            setJoiningDate("");
            
            setQualification("");
            
            setAppointedBy("");
            
            setJoined(false);
            terminated = true;
        }
    }

    // Display info
    @Override
    public void display() {
        super.display(); // Shows basic info from StaffHire
        if (getJoined() && !terminated) {
            System.out.println("Wages per Hour: $" + wagesPerHour);
            
            System.out.println("Working Hours: " + workingHours + " hrs/week");
            
            System.out.println("Shift: " + shift);
        }
    }
}