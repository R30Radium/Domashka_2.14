import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        StringList stringList = new StringListImpl();
        stringList.add("one");
        stringList.add("two");
        stringList.add("three");
        stringList.add("four");
        stringList.add("five");

        stringList.add(4,"fourrr");

        stringList.remove(1);

        System.out.printf(Arrays.toString(stringList.toArray()));

        stringList.clear();
        System.out.println(stringList.size());
    }
}
