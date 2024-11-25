package practice.topics.latestFeatures;

public sealed interface SealedClassEx permits A{
}

 sealed interface A extends SealedClassEx permits B{

}

final class B implements A{

}