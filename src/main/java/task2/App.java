package task2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static task2.StudentApp.*;

public class App {
    public static void main(String[] args) {
        List<Student> students;
        File f = new File(FILE_JSON);
        if (f.exists() && !f.isDirectory()) {
            students = loadFromFile(FILE_JSON);
        } else {
            students = prepare();
            saveToFile(FILE_JSON, students);
            saveToFile(FILE_XML, students);
        }
        System.out.println(students);

    }

    static List<Student> prepare() {
        List<Student> list = new ArrayList<>();
        list.add(new Student("Boris", 21, 4.75));
        return list;
    }
}
