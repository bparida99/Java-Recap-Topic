package practice.topics.latestFeatures;

import java.util.random.RandomGenerator;

public class RandomGeneratorEx {

    public static void main(String arg[]){
        RandomGenerator random = RandomGenerator.of("Random");
        System.out.println("Random Int: " + random.nextInt(0,100));
    }
}
