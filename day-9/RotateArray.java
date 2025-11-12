public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;
        int k = 2; // rotate by 2 positions
        
        int[] rotated = new int[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = arr[i];
        }
        
        System.out.println("After rotation:");
        for (int num : rotated) {
            System.out.print(num + " ");
        }
    }
}
