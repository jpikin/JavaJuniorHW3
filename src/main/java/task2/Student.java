package task2;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Student implements Externalizable {
    private String name;
    private int age;

    private Double gpa;

    public Student(){

    }
    public Student(String name, int age, Double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Double getGPA() {
        return gpa;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(age);
        out.writeObject(gpa);
    }

    @Override

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        age = in.readInt();
        gpa = (Double) in.readObject();

        }



    @Override
    public String toString() {
        return "name: " + this.name + "\n age: " + this.age + "\n GPA: "+ this.gpa;
    }
}
