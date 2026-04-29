import java.io.*;
import java.util.*;

public class filehandler {
    String filename = "students.txt";

    public void saveStudent(student s) {
        try {
            FileWriter fw = new FileWriter(filename, true);
            fw.write(s.toString() + "\n");
            fw.close();
        } catch (Exception e) {
            System.out.println("Error saving student.");
        }
    }

    public ArrayList<student> loadStudents() {
        ArrayList<student> list = new ArrayList<>();

        try {
            File file = new File(filename);
            if (!file.exists()) return list;

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                String[] arr = data.split(",");

                int id = Integer.parseInt(arr[0]);
                String name = arr[1];
                String course = arr[2];
                double marks = Double.parseDouble(arr[3]);

                list.add(new student(id, name, course, marks));
            }

            sc.close();
        } catch (Exception e) {
            System.out.println("Error loading students.");
        }

        return list;
    }

    public void overwriteStudents(ArrayList<student> list) {
        try {
            FileWriter fw = new FileWriter(filename);

            for (student s : list) {
                fw.write(s.toString() + "\n");
            }

            fw.close();
        } catch (Exception e) {
            System.out.println("Error updating file.");
        }
    }
}