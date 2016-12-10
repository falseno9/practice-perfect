package Random;

import org.apache.commons.lang3.tuple.MutablePair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Kunal on 12/9/2016.
 */
public class MyHashMap {

    List<LinkedList<MutablePair>> buckets = new ArrayList<LinkedList<MutablePair>>(Collections.nCopies(1000, null));

    private static AtomicInteger size = new AtomicInteger();

    public void put(String key, String value) {

        int hashcode = key.hashCode() % 1000;
        LinkedList<MutablePair> bucket = buckets.get(hashcode);

        if (bucket == null) {
            LinkedList<MutablePair> l1 = new LinkedList();
            l1.add(MutablePair.of(key, value));
            buckets.add(hashcode, l1);
        } else {
            for (MutablePair p : bucket) {
                if (p.getLeft().equals(key)) {
                    p.setValue(value);
                    return;
                }
            }
            bucket.add(MutablePair.of(key, value));
        }
        size.incrementAndGet();
    }

    public String get(String key) {
        int hashcode = key.hashCode() % 1000;
        LinkedList<MutablePair> bucket = buckets.get(hashcode);

        for (MutablePair p : bucket) {
            if (p.getLeft().equals(key)) {
                return (String) p.getRight();
            }
        }
        return null;
    }

    public AtomicInteger size() {
        return size;
    }

    public static void main(String[] args) {
        MyHashMap myHash = new MyHashMap();
        myHash.put("a", "1");
        myHash.put("a", "2");
        myHash.put("b", "2");
        System.out.println(myHash.get("a"));
        System.out.println(myHash.size());
    }
}
