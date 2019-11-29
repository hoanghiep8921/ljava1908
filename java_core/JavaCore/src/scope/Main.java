package scope;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class Main {
    public static void main(String[] args) {
        Superman s = new Superman();
        System.out.println(s.name);
        System.out.println(Superman.address);

        String abc = "123";
        String def = "123";
        String hjk = new String("123");
        System.out.println(abc == def);
        System.out.println(abc == hjk);

        System.out.println(abc.equals(def));
        System.out.println(abc.equals(hjk));

        Integer number1 = 10;
        int number2 = 10;
        Integer number3 = new Integer(10);

        System.out.println("______");
        System.out.println(number2 == number3);
        System.out.println(number2 == number1);
        System.out.println(number3 == number1);
        System.out.println(number1.equals(number3));

        System.out.println("_______");

        Dog d1 = new Dog("Shi",10);
        Dog d2 = new Dog("Shiba",10);

        System.out.println(d1 == d2);
        System.out.println(d1.equals(d2));

        int[] arr1 = new int[]{1,4,3,2};
        int[] arr2 = new int[]{8,6,5,7};

        int sumLength = arr1.length + arr2.length;
        int[] arr3 = new int[sumLength];

        for(int i = 0 ; i < sumLength ; i++){
            if(i < arr1.length){
                arr3[i] = arr1[i];
            }else{
                arr3[i] = arr2[i - arr1.length];
            }
        }

        String str1 = "abc";
        String str2 = "def";
        str1.concat(str2);



    }
}
