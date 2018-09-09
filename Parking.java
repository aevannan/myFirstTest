import java.util.Stack;
import java.util.Scanner;
/**
 * Write a description of class Parking here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Parking
{
    public static void main (String[] args)
    {
        Stack <Integer> dw = new Stack<>();
        Stack <Integer> street = new Stack<>();
        Scanner keyboard = new Scanner(System.in);
        //create if menus
        int choice = 1;
        System.out.println("Your integer is your license plate number!!!");
        while (choice != 0)
        {
            System.out.println();
            System.out.println("Enter a positive integer to add a car; negative integer to remove a car; or 0 to stop: ");
            choice = keyboard.nextInt();
            if (choice > 0)
            {
                dw.push(choice);
                System.out.println("Your car is at " + choice + " in the driveway");
                System.out.println("This is the driveway: " + dw);
                System.out.println("This is the street: " + street);
            }
            if (choice < 0)
            {
                choice = choice * -1;
                if (dw.peek() == choice)
                {
                    dw.pop();
                    System.out.println("Your car at " + choice + " is now removed from the driveway");
                    System.out.println("This is the driveway: " + dw);
                    System.out.println("This is the street: " + street);
                }
                else if (dw.peek() != choice)
                {
                    int len = dw.size(); //length of the driveway stack
                    while (len > 0) 
                    {
                        if (dw.peek() == choice)
                        {
                            dw.pop();
                            while (street.size() > 0)
                            {
                                int stemp = street.pop();
                                if (stemp != choice)
                                {
                                    dw.push(stemp);
                                }
                            }
                            System.out.println("Your car at " + choice + " is now removed from the driveway");
                            System.out.println("All the cars in the street were added back");
                            System.out.println("This is the driveway: " + dw);
                            System.out.println("This is the street: " + street);
                            len = 0; 
                        }
                        else
                        {
                            int temp = dw.pop();
                            street.push(temp);
                            System.out.println("The car at " + temp + " was temporarily moved to the street");
                            System.out.println("This is the driveway: " + dw);
                            System.out.println("This is the street: " + street);
                            System.out.println();
                        }
                    }
                }
            }
        }
    }
}
