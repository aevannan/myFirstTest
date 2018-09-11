import java.util.Stack;
import java.util.Scanner;
/**
 * Write a description of class Parking here.
 * 
 * Aaina Vannan
 * Ex 15.10 
 */
public class Parking
{
    public static void main (String[] args)
    {
        Stack <Integer> dw = new Stack<>(); //this is the driveway stack
        //this is the stack where cars are temporarily moved to so that the cars that weren't put in last in dw can be removed
        Stack <Integer> street = new Stack<>(); 
        Scanner keyboard = new Scanner(System.in);
        
        //create if menus
        int choice = 1; //have to change choice in the while 
        System.out.println("Your integer is your license plate number!!!");
        while (choice != 0)
        {
            System.out.println();
            System.out.println("Enter a positive integer to add a car; negative integer to remove a car; or 0 to stop: ");
            choice = keyboard.nextInt(); //gets choice
            if (choice > 0) //to add a car
            {
                dw.push(choice); //adds the car to the top of the stack 
                System.out.println("Your car is at " + choice + " in the driveway");
                System.out.println("This is the driveway: " + dw); //prints the dw stack
                System.out.println("This is the street: " + street); //prints the street stack
            }
            if (choice < 0)
            {
                choice = choice * -1; //have to make license plate positive because only positive numbers are in the driveway
                if (dw.peek() == choice) //checks to see if the top of the stack is the choice
                {
                    dw.pop(); //if it is, remove it
                    System.out.println("Your car at " + choice + " is now removed from the driveway");
                    System.out.println("This is the driveway: " + dw);
                    System.out.println("This is the street: " + street);
                }
                else if (dw.peek() != choice)
                {
                    int len = dw.size(); //length of the driveway stack
                    if(dw.contains(choice)) //if choice is in driveway
                    {
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
                                        dw.push(stemp); //moves everything from street into driveway
                                    }
                                }
                                System.out.println("Your car at " + choice + " is now removed from the driveway");
                                System.out.println("All the cars in the street were added back");
                                System.out.println("This is the driveway: " + dw);
                                System.out.println("This is the street: " + street);
                                len = 0; //so the while loop ends
                            }
                            else
                            {
                                int temp = dw.pop();
                                street.push(temp); //moves temp to street
                                System.out.println("The car at " + temp + " was temporarily moved to the street");
                                System.out.println("This is the driveway: " + dw);
                                System.out.println("This is the street: " + street);
                                System.out.println();
                                len--;
                            }
                        }
                    }
                    else
                    {
                        //if the car was not in the driveway, I move everything from street to dw stack & print the stacks at the end
                        System.out.println("Your car was not in the driveway!");
                        while (street.size() > 0)
                        {
                            int stemp = street.pop();
                            if (stemp != choice)
                            {
                                dw.push(stemp); //moves everything from street into driveway
                            }
                        }
                        System.out.println("All the cars in the street were added back");
                        System.out.println("This is the driveway: " + dw);
                        System.out.println("This is the street: " + street);
                    }
                }
            }
        }
    }
}



