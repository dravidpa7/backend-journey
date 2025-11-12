public class MissingNumbers {
    public static void main(String[] args) {
        int array[] = {1, 2, 4, 6, 3, 7, 8};
        int max = 0;
        for (int i =0 ; i<array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        int findOrginalSum = (max * (max + 1)) / 2;
        int findArraySum = 0;
        for (int i : array) {
            findArraySum += i;
        }

        int missingNumber = findOrginalSum - findArraySum;
        System.out.println("The missing number is: " + missingNumber);
    }
}
