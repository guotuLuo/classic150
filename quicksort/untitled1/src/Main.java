import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        int[] a=
            {72,6,57,88,60,42,83,73,48,85};
        //  {48 6 57 88 60 42 83 73 72 85}
        //  {48 6 57 72 60 42 83 73 88 85}
        //  {48 6 57 42 60 72 83 73 88 85}
        //  {}
        quickSort(a,0,9);
        System.out.println(Arrays.toString(a));
    }

    public static void quickSort(int[] a,int left,int right) {
        if(left < right){
            int temp = qSort(a, left, right);
            quickSort(a, left, temp - 1);
            quickSort(a, temp + 1, right);
        }
    }

    public static int qSort(int[] a,int left,int right) {
       int temp = a[left];
       while(left < right){
           while(left < right && a[right] > temp){
               right--;
           }
           if(left < right){
               a[left++] = a[right];
           }
           while(left < right && a[left] <= temp){
               left++;
           }
           if(left < right){
               a[right--] = temp;
           }
       }
       a[left] = temp;
       return left;
    }
}
