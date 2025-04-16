# CS4001-CW
Repository for Programming CW 

# Java Recruitment System

This is a Java-based recruitment system I built as part of a university coursework assignment. It's designed to help manage full-time and part-time staff hiring using Object-Oriented Programming (OOP) principles.

## 📁 Project Overview

The system allows a user to:
- Add full-time or part-time staff
- Set working hours, wages, and joining details
- Terminate part-time staff
- Display all staff info
- Clear the form fields from the GUI

The GUI was made using basic Java Swing components, and all the logic is handled through classes and inheritance.

## 🧱 Class Structure

- **StaffHire.java**  
  The parent class that holds common attributes like vacancy number, designation, and job type.

- **FullTimeStaffHire.java**  
  Inherits from `StaffHire` and handles full-time staff details such as salary and working hours.

- **PartTimeStaffHire.java**  
  Inherits from `StaffHire` and deals with part-time staff details, including shift, wages, and termination status.

- **RecruitmentSystem.java**  
  This is the GUI class. It uses Swing components and has buttons to add, display, terminate, and clear staff data.
