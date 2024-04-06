package task2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentApp {
    public static final String FILE_JSON = "task.json";
    public static final String FILE_XML = "task.xml";

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();

    public static void saveToFile(String file, List<Student> students) {
        try {
            if (file.endsWith("json")) {
                objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                objectMapper.writeValue(new File(file), students);
            }
            else if (file.endsWith("xml")){
                xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                xmlMapper.writeValue(new File(file), students);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Student> loadFromFile(String fileName){
        List<Student>  students = new ArrayList<>();
        File file = new File(fileName);
        try {
            if (file.exists()) {
                if (fileName.endsWith("json")) {
                    students = objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, Student.class));
                }
                else if (fileName.endsWith("xml")){
                    students = xmlMapper.readValue(file, xmlMapper.getTypeFactory().constructCollectionType(List.class, Student.class));
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return students;
    }
}
