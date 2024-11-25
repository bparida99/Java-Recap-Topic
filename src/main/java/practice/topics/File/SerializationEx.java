package practice.topics.File;

import java.io.*;

public class SerializationEx implements Serializable {

    private static final long serialVersionUID = 1L;

    private transient int id;
    private String name;
    public SerializationEx(int id, String name)
    { this.id = id;this.name = name; }


    public static void main(String ar[]) throws IOException {
        SerializationEx sl= new SerializationEx(1,"Biswo");

        try (FileOutputStream fileOut = new FileOutputStream("person.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(sl);  // Serialize the object
            System.out.println("Object has been serialized: " + sl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
