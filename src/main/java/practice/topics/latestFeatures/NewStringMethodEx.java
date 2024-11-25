package practice.topics.latestFeatures;

public class NewStringMethodEx {

    public static void main(String arg[]){
        String s = """
                A
                B
                C
                """;
        System.out.println(s.lines().findFirst());

        s.strip();
    }
}
