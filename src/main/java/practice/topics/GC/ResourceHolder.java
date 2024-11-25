package practice.topics.GC;

import java.lang.ref.Cleaner;

public class ResourceHolder {
    private static final Cleaner cleaner = Cleaner.create();

    private static class Resource implements Runnable {
        @Override
        public void run() {
            // Clean up code here
            System.out.println("Cleaning up resources");
        }
    }

    private final Resource resource;
    private final Cleaner.Cleanable cleanable;

    public ResourceHolder() {
        this.resource = new Resource();
        this.cleanable = cleaner.register(this, resource);
    }

    public static void main(String[] args) {
        ResourceHolder holder = new ResourceHolder();
        // Resource will be cleaned up automatically when holder is no longer reachable
    }
}

