package practice.topics.annotations;

public class TestAnnotation {
    @CustomAnnotation(value = "Testing",version = 1)
    public void test(){
        System.out.println(CustomAnnotation.class);

    }

    public static void main(String arg[]){

    }
}
