package ie.atu.refresh;

public class FilterArray {
    public static void main(String[] args) {
        // Create integer variable to store the sum of all even numbers in the array
        int sum = 0;

        // Create integer array which holds number 1 to 100
        int[] numbers = new int[100];

        // Iterate over the array and populate it with numbers 1 to 100
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        } // End of for loop

        // Use a for loop to iterate through the array and print out each element
        for (int i = 0; i < numbers.length; i++) {
            // Print all even numbers in the array. Find the sum of all even numbers in the
            // array and print that too.
            if (numbers[i] % 2 == 0) {
                sum += numbers[i];
                System.out.println(numbers[i]);
            } // End of if statement
        } // End of for loop
          // Print the sum of all even numbers in the array
        System.out.println("The sum of all even numbers in the array is: " + sum);
    } // End of main
} // End of class