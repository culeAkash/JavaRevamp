package collection.framework.maps;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapDemo {
    public static void main(String[] args) {
        Map<String,Image> imageCache = new WeakHashMap<>();

        loadCache(imageCache);
//        imageCache.put("img1",new Image("Image 1"));
//        imageCache.put("img2",new Image("Image 2"));
        // Since we are using string literals here, string literals are treated as strong referenced as internally string pool
        // maintains a map of string literals and only can be garbage collected when the class loader loading the string literal
        // is itself cleared.

        System.out.println(imageCache);

        simulateApplicationRunning();
        System.gc();

        System.out.println("After application running(some entries may be cleared) : " + imageCache);
    }

    private static void simulateApplicationRunning() {
        try {
            System.out.println("Application running....");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void loadCache(Map<String, Image> imageCache) {
        // string literals are not used and references are cleared when scope of this method ends
        // making the keys of map unreferenced objects which can be cleared by JVM when used in WeakHashMap
        String key1 = new String("img1");
        String key2 = new String("img2");
        imageCache.put(key1,new Image("Image 1"));
        imageCache.put(key2,new Image("Image 2"));
    }
}


class Image{
    private String name;

    public Image(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Image{" +
                "name='" + name + '\'' +
                '}';
    }
}
