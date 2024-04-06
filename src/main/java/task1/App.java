package task1;

import java.io.*;

public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student("Boris",21,4.75);

        System.out.println(student.getName());
        System.out.println(student.getAge());
        System.out.println(student.getGPA());
        try (FileOutputStream fileOut = new FileOutputStream("student.bin");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)){
            out.writeObject(student);
            System.out.println("Объект сериализован");
        }
        try (
                FileInputStream fileInput = new FileInputStream("student.bin");
                ObjectInputStream in = new ObjectInputStream(fileInput)){
            student = (Student)in.readObject();
            System.out.println("Объект десериализован");
        }

        System.out.println(student.getName());
        System.out.println(student.getAge());
        System.out.println(student.getGPA());

    }
}
