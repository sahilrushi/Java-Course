import java.util.Scanner;
import java.io.*;

public class exp4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--Error Detection using CRC--");
        System.out.print("Enter message bits : ");
        String message = sc.nextLine();

        System.out.print("Enter generator : ");
        String generator = sc.nextLine();

        int[] data = new int[message.length() + generator.length() - 1];
        int[] divisor = new int[generator.length()];

    
        for (int i = 0; i < message.length(); i++) {
            data[i] = Integer.parseInt(message.charAt(i) + "");
        }

        
        for (int i = 0; i < generator.length(); i++) {
            divisor[i] = Integer.parseInt(generator.charAt(i) + "");
        }

        for (int i = 0; i < message.length(); i++) {
            if (data[i] == 1) {
                for (int j = 0; j < divisor.length; j++) {
                    data[i + j] ^= divisor[j];
                }
            }
        }

        
        System.out.print("\nThe Checksum code is : ");
        for (int i = 0; i < message.length(); i++) {
            System.out.print(message.charAt(i));
        }
        for (int i = message.length(); i < data.length; i++) {
            System.out.print(data[i]);
        }
        System.out.println();

        // Check for input CRC code
        System.out.print("Enter checksum code: ");
        message = sc.nextLine();

        System.out.print("\nEnter generator : ");
        generator = sc.nextLine();

        data = new int[message.length() + generator.length() - 1];
        divisor = new int[generator.length()];

        // Convert received message into int array
        for (int i = 0; i < message.length(); i++) {
            data[i] = Integer.parseInt(message.charAt(i) + "");
        }

        for (int i = 0; i < generator.length(); i++) {
            divisor[i] = Integer.parseInt(generator.charAt(i) + "");
        }

        // Calculation of remainder
        for (int i = 0; i < message.length(); i++) {
            if (data[i] == 1) {
                for (int j = 0; j < divisor.length; j++) {
                    data[i + j] ^= divisor[j];
                }
            }
        }

        // Display validity of data
        boolean valid = true;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 1) {
                valid = false;
                break;
            }
        }

        if (valid) {
            System.out.println("\nData stream is valid");
        } else {
            System.out.println("\nData stream is invalid, CRC error occurred");
        }
    }
}