import java.util.*;

public class recordmanager {
    ArrayList<student> students;
    filehandler fh = new filehandler();

    public recordmanager() {
        students = fh.loadStudents();
    }

    public void addStudent(student s) {
        students.add(s);
        fh.saveStudent(s);
        System.out.println("Student Added Successfully.");
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No Student Records Found.");
            return;
        }

        for (student s : students) {
            System.out.println("ID: " + s.id);
            System.out.println("Name: " + s.name);
            System.out.println("Course: " + s.course);
            System.out.println("Marks: " + s.marks);
            System.out.println("----------------------");
        }
    }

    public void searchStudent(int id) {
        for (student s : students) {
            if (s.id == id) {
                System.out.println("Student Found:");
                System.out.println("ID: " + s.id);
                System.out.println("Name: " + s.name);
                System.out.println("Course: " + s.course);
                System.out.println("Marks: " + s.marks);
                return;
            }
        }
        System.out.println("Student Not Found.");
    }

    public void deleteStudent(int id) {
        boolean found = false;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).id == id) {
                students.remove(i);
                found = true;
                break;
            }
        }

        if (found) {
            fh.overwriteStudents(students);
            System.out.println("Student Deleted Successfully.");
        } else {
            System.out.println("Student Not Found.");
        }
    }
}