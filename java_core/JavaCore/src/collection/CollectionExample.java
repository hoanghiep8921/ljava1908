package collection;

import java.util.*;

public class CollectionExample {

    public static void main(String[] args) {
        //String[] list = new String[];
        //int[] arr = new int[]{1,2,3,4}; 5
        //int[] newArr = new int[5];
        //List<Integer> test = new ArrayList();

        List<String> list = new ArrayList();
        List<String> list2 = new ArrayList<>();
        List<String> lst = new LinkedList<>();

        System.out.println(list.size());
        // arr.length
        list.add("abc");
        list.add("def");
        list.add("hjk");
        list.add(1,"abc");
        list2.add("ABC");
        list.addAll(list2);
        list.addAll(1,list2);

        System.out.println(list.contains("def"));
        //arr[1]
        System.out.println(list.get(1));
        System.out.println(list.indexOf("abc"));


//        list.clear();
//        System.out.println(list.isEmpty());
//        System.out.println(list.size());
        System.out.println("________");
        for (String item : list) {
            System.out.println(item);
        }
        System.out.println(list.remove("ABC"));
        list.set(0,"FUC");
        System.out.println("____");
        list.toArray();
        for (String item : list) {
            System.out.println(item);
        }

        List<String> tmp = Arrays.asList("123","456");

        System.out.println("________");
        Set<String> set = new HashSet<>();

        set.add("123");
        set.add("123");
        set.add("456");
        for(String s : set){
            System.out.println(s);
        }
        System.out.println("__________");
        Set<Integer> setInteger = new TreeSet<>();
        setInteger.add(5);
        setInteger.add(4);
        setInteger.add(1);
        for(Integer i : setInteger){
            System.out.println(i);
        }

        Map<String,Integer> map = new HashMap<>();
        map.put("Java",100);
        map.put("PHP",200);
        map.put("C#",300);

        for(String s : map.keySet()){
            System.out.println("Key là :" + s );
            System.out.println("Value là : "+ map.get(s));
        }

        System.out.println("_____");
        Map<String,List<Integer>> map2 = new TreeMap<>();
        List<Integer> lstNumber = new ArrayList<>();
        lstNumber.add(1);
        map2.put("d",lstNumber);
        lstNumber.add(2);
        map2.put("a",lstNumber);
        map2.put("a",lstNumber);
        for(String s : map2.keySet()){
            System.out.println("Key là :" + s + " có giá trị là " +map2.get(s).size());
        }
        System.out.println("______");
        List<Integer> arr = Arrays.asList(1,2,1,1,3,2,5);
        Map<Integer,Integer> countMap  = new TreeMap<>();
        for(Integer i : arr){
            if(countMap.containsKey(i)){
                countMap.put( i , countMap.get(i) + 1);
            }else{
                countMap.put( i , 1 );
            }
        }

        for(Integer key : countMap.keySet()){
            System.out.println("Key là "+key + " xuất hiện " +countMap.get(key) + " lần");
        }


        System.out.println("________");
        Queue<String> queue = new ArrayDeque<>();
        queue.add("Item 1");
        queue.add("Item 2");
        System.out.println(queue.poll());
        System.out.println(queue.peek());

        System.out.println("_______");
        Stack<String> stack = new Stack<>();
        stack.add("item 1");
        stack.add("item 2");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());




    }
}
