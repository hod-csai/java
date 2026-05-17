import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class ListDemo {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("Apple");
        System.out.println(al);

        LinkedList<String> ll = new LinkedList<>();
        ll.add("Banana");
        System.out.println(ll);

        Vector<String> v = new Vector<>();
        v.add("Cherry");
        System.out.println(v);
    }
}