package practice.datastructure;

import org.w3c.dom.Node;

import java.net.StandardSocketOptions;
import java.util.*;

public class LinkedListEx {

    public static void main(String arg[]){
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        //reverse linked list
        LinkedList<Integer> reverse = new LinkedList<>();
        Iterator<Integer> it = list.descendingIterator();
        while (it.hasNext()){
            reverse.add(it.next());
        }
        System.out.println(reverse);
        Set<Integer> s = new HashSet<>();

        int k=2;
        int l=4;
        System.out.println(k%l);


    }
}
