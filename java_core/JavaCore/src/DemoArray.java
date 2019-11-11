public class DemoArray {
    public static void main(String[] args) {
        int[] a = new int[10];
        //a[10] = 10;
        //int c;
        //System.out.println(a[0]);
        for(int i = 0 ; i < a.length ;i++){
            a[i] = i;
        }
        for(int i = 0; i < a.length;i++){
            System.out.println(a[i]);
        }

        int[] arr = new int[]{5,3,1,4,7};

        for(int i=0;i<arr.length;i++){
            for(int j = 0;j<arr.length;j++){
                if(arr[i] > arr[j]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }


    }
}
