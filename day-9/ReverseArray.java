public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;

        // Reverse the array without creating new array

        // Here we Have used two pointer approach
        int left = 0, right = n - 1;
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        System.out.println("After reversal:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

    }
}
