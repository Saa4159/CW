// Importing necessary Java libraries for GUI handling
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

// FullTimeStaffHire class represents a full-time staff member
class FullTimeStaffHire {
    private String vacancyNo,    designation, jobType, staffName, joiningDate, qualification, appointedBy, salary;

    public FullTimeStaffHire(String vacancyNo, String designation, String jobType, String staffName, 
                               String joiningDate, String qualification, String appointedBy, String salary) {
        this.vacancyNo = vacancyNo;
        
        this.designation = designation;
        
        this.jobType = jobType;
        
        this.staffName = staffName;
        
        this.joiningDate = joiningDate;
        
        this.qualification = qualification;
        
        this.appointedBy = appointedBy;
        
        this.salary = salary;
    }

    public String getVacancyNo() {
        return vacancyNo;
    }

    public String toString() {
        return "Full-Time Staff: " + staffName + " | Vacancy: " + vacancyNo + " | Designation: " + 
               designation + " | Salary: " + salary;
    }
}

// PartTimeStaffHire class represents a part-time staff member
class PartTimeStaffHire {
    private String vacancyNo, designation, jobType, staffName, joiningDate, qualification, appointedBy;
    private String workingHour, wages, shifts, weeklyHours;
    private boolean terminated;

    public PartTimeStaffHire(String vacancyNo, String designation, String jobType, String staffName, 
                             String joiningDate, String qualification, String appointedBy, 
                             String workingHour, String wages, String shifts, String weeklyHours) {
        this.vacancyNo = vacancyNo;
        this.designation = designation;
        this.jobType = jobType;
        this.staffName = staffName;
        this.joiningDate = joiningDate;
        this.qualification = qualification;
        this.appointedBy = appointedBy;
        this.workingHour = workingHour;
        this.wages = wages;
        this.shifts = shifts;
        this.weeklyHours = weeklyHours;
        this.terminated = false;
    }

    public String getVacancyNo() {
        return vacancyNo;
    }

    public boolean isTerminated() {
        return terminated;
    }

    public void terminate() {
        if (!terminated) {
            // This will reset the detials of staff members.
            this.staffName = "";
            this.joiningDate = "";
            this.qualification = "";
            this.appointedBy = "";
            this.terminated = true;
        }
    }

    public String toString() {
        return "Part-Time Staff: " + staffName + (terminated ? " [Terminated]" : "") +
               " | Vacancy: " + vacancyNo + " | Designation: " + designation + " | Shifts: " + shifts;
    }
}

    // This is the Main class for the recruitment system with the use of the graphical user interface.
    public class RecruitmentSystem {    
    private JFrame frame;
    private JPanel sharedPanel, partTimePanel, fullTimePanel;
    private JTextField vacancyField, designationField, jobTypeField, nameField, dateField, qualificationField, appointedByField;
    private JTextField workingHourField, wagesField, shiftsField, salaryField, weekHoursField, terminateField;
    private ArrayList<PartTimeStaffHire> partTimeList = new ArrayList<>();
    private ArrayList<FullTimeStaffHire> fullTimeList = new ArrayList<>();

    public RecruitmentSystem() {
        frame = new JFrame("Recruitment System");
        frame.setSize(1000, 600);
        frame.setLayout(null);

        JLabel title = new JLabel("Recruitment System");
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setBounds(400, 10, 300, 30);
        frame.add(title);

        createSharedFields(); 
        createPartTimePanel();
        createFullTimePanel();
        createButtons();

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createSharedFields() {
        sharedPanel = new JPanel();
        sharedPanel.setLayout(null);
        sharedPanel.setBounds(50, 60, 350, 250);

        JLabel[] labels = new JLabel[] {
            new JLabel("Vacancy No:"), new JLabel("Designation:"), new JLabel("Job Type:"),
            new JLabel("Staff Name:"), new JLabel("Joining Date:"), new JLabel("Qualification:"),
            new JLabel("Appointed By:")
        };

        JTextField[] fields = new JTextField[] {
            vacancyField = new JTextField(), designationField = new JTextField(), jobTypeField = new JTextField(),
            nameField = new JTextField(), dateField = new JTextField(), qualificationField = new JTextField(),
            appointedByField = new JTextField()
        };

        int y = 0;
        for (int i = 0; i < labels.length; i++) {
            labels[i].setBounds(0, y, 150, 25);
            fields[i].setBounds(160, y, 150, 25);
            sharedPanel.add(labels[i]);
            sharedPanel.add(fields[i]);
            y += 35;
        }
        frame.add(sharedPanel);
    }

    private void createPartTimePanel() {
        partTimePanel = new JPanel();
        partTimePanel.setLayout(null);
        partTimePanel.setBounds(50, 320, 350, 200);

        JLabel[] labels = new JLabel[] {
            new JLabel("Working Hours:"), new JLabel("Wages/hour:"), new JLabel("Shifts:"),
            new JLabel("Weekly Hours:"), new JLabel("Terminate Vacancy:")
        };

        JTextField[] fields = new JTextField[] {
            workingHourField = new JTextField(), wagesField = new JTextField(), shiftsField = new JTextField(),
            weekHoursField = new JTextField(), terminateField = new JTextField()
        };

        int y = 0;
        for (int i = 0; i < labels.length; i++) {
            labels[i].setBounds(0, y, 150, 25);
            fields[i].setBounds(160, y, 150, 25);
            partTimePanel.add(labels[i]);
            partTimePanel.add(fields[i]);
            y += 35;
        }
        frame.add(partTimePanel);
        partTimePanel.setVisible(false);
    }

    private void createFullTimePanel() {
        fullTimePanel = new JPanel();
        fullTimePanel.setLayout(null);
        fullTimePanel.setBounds(50, 320, 350, 100);

        JLabel[] labels = new JLabel[] {
            new JLabel("Salary:"), new JLabel("Terminate Vacancy:")
        };

        JTextField[] fields = new JTextField[] {
            salaryField = new JTextField(), terminateField = new JTextField()
        };

        int y = 0;
        for (int i = 0; i < labels.length; i++) {
            labels[i].setBounds(0, y, 150, 25);
            fields[i].setBounds(160, y, 150, 25);
            fullTimePanel.add(labels[i]);
            fullTimePanel.add(fields[i]);
            y += 35;
        }
        frame.add(fullTimePanel);
        fullTimePanel.setVisible(false);
    }

    private boolean fieldsFilledForPartTime() {
        return !vacancyField.getText().isEmpty() && !designationField.getText().isEmpty() && !jobTypeField.getText().isEmpty()
                && !nameField.getText().isEmpty() && !dateField.getText().isEmpty() && !qualificationField.getText().isEmpty()
                && !appointedByField.getText().isEmpty() && !workingHourField.getText().isEmpty() && !wagesField.getText().isEmpty()
                && !shiftsField.getText().isEmpty() && !weekHoursField.getText().isEmpty();
    }

    private boolean fieldsFilledForFullTime() {
        return !vacancyField.getText().isEmpty() && !designationField.getText().isEmpty() && !jobTypeField.getText().isEmpty()
                && !nameField.getText().isEmpty() && !dateField.getText().isEmpty() && !qualificationField.getText().isEmpty()
                && !appointedByField.getText().isEmpty() && !salaryField.getText().isEmpty();
    }

    private void createButtons() {
        JButton showPartTime = new JButton("Part-Time Staff");
        showPartTime.setBounds(500, 60, 200, 30);
        showPartTime.addActionListener(e -> {
            partTimePanel.setVisible(true);
            fullTimePanel.setVisible(false);
        });
        frame.add(showPartTime);

        JButton showFullTime = new JButton("Full-Time Staff");
        showFullTime.setBounds(500, 100, 200, 30);
        showFullTime.addActionListener(e -> {
            fullTimePanel.setVisible(true);
            partTimePanel.setVisible(false);
        });
        frame.add(showFullTime);

        JButton savePartTime = new JButton("Save Part-Time");
        savePartTime.setBounds(500, 150, 200, 30);
        savePartTime.addActionListener(e -> {
            if (fieldsFilledForPartTime()) {
                PartTimeStaffHire pt = new PartTimeStaffHire(
                        vacancyField.getText(), designationField.getText(), jobTypeField.getText(),
                        nameField.getText(), dateField.getText(), qualificationField.getText(),
                        appointedByField.getText(), workingHourField.getText(), wagesField.getText(),
                        shiftsField.getText(), weekHoursField.getText()
                );
                partTimeList.add(pt);
                JOptionPane.showMessageDialog(frame, "Part-Time Staff Saved!");
            } else {
                JOptionPane.showMessageDialog(frame, "Please fill all fields for Part-Time Staff.");
            }
        });
        frame.add(savePartTime);

        JButton saveFullTime = new JButton("Save Full-Time");
        saveFullTime.setBounds(500, 190, 200, 30);
        saveFullTime.addActionListener(e -> {
            if (fieldsFilledForFullTime()) {
                FullTimeStaffHire ft = new FullTimeStaffHire(
                        vacancyField.getText(), designationField.getText(), jobTypeField.getText(),
                        nameField.getText(), dateField.getText(), qualificationField.getText(),
                        appointedByField.getText(), salaryField.getText()
                );
                fullTimeList.add(ft);
                JOptionPane.showMessageDialog(frame, "Full-Time Staff Saved!");
            } else {
                JOptionPane.showMessageDialog(frame, "Please fill all fields for Full-Time Staff.");
            }
        });
        frame.add(saveFullTime);

        JButton displayButton = new JButton("Display All Staff");
        displayButton.setBounds(500, 230, 200, 30);
        displayButton.addActionListener(e -> {
            StringBuilder displayText = new StringBuilder("All Staff:\n\n");
            for (FullTimeStaffHire staff : fullTimeList) {
                displayText.append(staff.toString()).append("\n");
            }
            for (PartTimeStaffHire staff : partTimeList) {
                displayText.append(staff.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(frame, displayText.toString());
        });
        frame.add(displayButton);

        JButton clearButton = new JButton("Clear Fields");
        clearButton.setBounds(500, 270, 200, 30);
        clearButton.addActionListener(e -> {
            vacancyField.setText("");
            designationField.setText("");
            jobTypeField.setText("");
            nameField.setText("");
            dateField.setText("");
            qualificationField.setText("");
            appointedByField.setText("");
            workingHourField.setText("");
            wagesField.setText("");
            shiftsField.setText("");
            weekHoursField.setText("");
            salaryField.setText("");
            terminateField.setText("");
        });
        frame.add(clearButton);

        JButton setShiftsButton = new JButton("Set Shifts");
        setShiftsButton.setBounds(500, 310, 200, 30);
        setShiftsButton.addActionListener(e -> {
            String shifts = shiftsField.getText();
            JOptionPane.showMessageDialog(frame, shifts.isEmpty() ? "Please enter shifts." : "Shifts set to: " + shifts);
        });
        frame.add(setShiftsButton);

        JButton setSalaryButton = new JButton("Set Salary");
        setSalaryButton.setBounds(500, 350, 200, 30);
        setSalaryButton.addActionListener(e -> {
            String sal = salaryField.getText();
            JOptionPane.showMessageDialog(frame, sal.isEmpty() ? "Please enter salary." : "Salary set to: " + sal);
        });
        frame.add(setSalaryButton);

        // To be able to terminate Part time staff member contracts.
        JButton terminatePart = new JButton("Terminate Part-Time");
        terminatePart.setBounds(500, 390, 200, 30);
        terminatePart.addActionListener(e -> {
            String vac = terminateField.getText().trim();
            boolean found = false;
            for (PartTimeStaffHire pt : partTimeList) {
                if (pt.getVacancyNo().equals(vac)) {
                    pt.terminate();
                    JOptionPane.showMessageDialog(frame, "Part-Time Staff with Vacancy " + vac + " terminated.");
                    found = true;
                    break;
                }
            }
            if (!found) {
                JOptionPane.showMessageDialog(frame, "No Part-Time Staff found with Vacancy " + vac + ".");
            }
        });
     
        frame.add(terminatePart);
    }
     
    public static void main(String[] args) {
        new RecruitmentSystem();
    }
}
