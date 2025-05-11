package generics;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        list.add(1);
        list.add("Hello");
        list.add(2.13);

        String object = (String) list.get(0);

    }
}
