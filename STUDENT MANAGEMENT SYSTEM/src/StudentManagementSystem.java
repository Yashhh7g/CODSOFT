import java.io.*;
import java.util.ArrayList;

public class StudentManagementSystem {

    private ArrayList<Student> students;
    private final String FILE_NAME = "students.dat";

    public StudentManagementSystem() {
        loadFromFile();
    }

    public void addStudent(Student student) {
        students.add(student);
        saveToFile();
        System.out.println("✅ Student added successfully.");
    }

    public void removeStudent(int rollNumber) {
        for (Student s : students) {
            if (s.getRollNumber() == rollNumber) {
                students.remove(s);
                saveToFile();
                System.out.println("✅ Student removed successfully.");
                return;
            }
        }
        System.out.println("❌ Student not found.");
    }

    public void searchStudent(int rollNumber) {
        for (Student s : students) {
            if (s.getRollNumber() == rollNumber) {
                System.out.println(s);
                return;
            }
        }
        System.out.println("❌ Student not found.");
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            students = (ArrayList<Student>) ois.readObject();
        } catch (Exception e) {
            students = new ArrayList<>();
        }
    }

    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }
}
