import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Build a scanner
        final Scanner input = new Scanner(System.in);

        //Prompt and store double amount
        System.out.println("Enter the amount of data:");
        int data_amount = Integer.parseInt(input.nextLine());

        //Prompt and store String unit
        System.out.println("Enter the unit (bytes, kilobytes, megabytes, gigabytes)");
        String unit_type = input.nextLine();

        //Prompt and store download speed (in megabits
        System.out.println("Enter your download speed (in megabits per second):");
        int download_speed = Integer.parseInt(input.nextLine());

        //Build a Data object with these three values
        Data newInput = new Data(data_amount, unit_type, download_speed);
        //Print out the data Object with your toString();


        System.out.println(newInput);



    }
}
