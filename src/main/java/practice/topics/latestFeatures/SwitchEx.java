package practice.topics.latestFeatures;

public class SwitchEx {

    public static void main(String arg[]){
        String value ="1";
        switch (value){
            case "1" -> System.out.println(value+"is first");
            case "2" -> System.out.println(value+"is second");
            default -> System.out.println("don't have any idea");
        }
    }
}
