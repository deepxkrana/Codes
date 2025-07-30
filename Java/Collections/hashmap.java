import java.util.*;

class hashmap{
    public static void main(String[] args) {
        HashMap<Integer, String> hm=new HashMap<>();
        hm.put(1,"Apple");
        hm.put(2,"Banana");
        hm.put(3,"Grapes");
        System.out.println(hm);
        System.out.println(hm.get(2));
        System.out.println(hm.containsKey(3));
        System.out.println(hm.containsValue("Grapes"));
        System.out.println(hm.keySet());
        Collection<String> names=hm.values();
        Set<Map.Entry<Integer, String>> entries=hm.entrySet();
        for (Map.Entry<Integer, String> entry : hm.entrySet()) {
            System.out.println(entry.getValue());
            System.out.println(entry.getKey());
        }
        System.out.println(hm.size());
        System.out.println(hm.isEmpty());
        hm.remove(2);
        System.out.println(hm);
        hm.replace(3, "Orange");
        System.out.println(hm);
        hm.putIfAbsent(4, "Guava");
        System.out.println(hm);
        hm.clear();
        System.out.println(hm);
        // HashMap<>hm1= HashMap<>(hm.clone());
        // hm1=hm.clone();
    }
}
