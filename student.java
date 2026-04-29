public class student {
    int id;
    String name;
    String course;
    double marks;

    public student(int id, String name, String course, double marks) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + course + "," + marks;
    }
}