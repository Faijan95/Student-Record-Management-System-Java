import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        recordmanager rm = new recordmanager();

        while (true) {
            System.out.println("\n===== STUDENT RECORD MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    rm.addStudent(new student(id, name, course, marks));
                    break;

                case 2:
                    rm.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID to Search: ");
                    int sid = sc.nextInt();
                    rm.searchStudent(sid);
                    break;

                case 4:
                    System.out.print("Enter Student ID to Delete: ");
                    int did = sc.nextInt();
                    rm.deleteStudent(did);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}