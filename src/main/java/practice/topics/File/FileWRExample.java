package practice.topics.File;


import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class FileWRExample {
    public static void main(String arg[]) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(new File("C:\\Users\\biswo\\OneDrive\\Desktop\\Notes\\Notes")));
        String line;
        while ((line =br.readLine())!=null){
            //System.out.println(line);
        }

       Stream<String> lines =
               Files.lines(Path.of("C:\\Users\\biswo\\OneDrive\\Desktop\\Notes\\Notes"));

        lines.forEach(l->{
            System.out.println(l);
        });
    }
}
