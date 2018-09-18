

import java.util.Queue;
import java.util.PriorityQueue;
import java.util.LinkedList;
/**
   Class for simulating a runway.
*/
public class RunwaySimulator
{
   private Queue <String> land;
   private Queue <String> takeOff;
   
   /**
      Constructor.
   */
   public RunwaySimulator()
   {
     //the LinkedList class implements the Queue interface
     land = new LinkedList<>(); 
     takeOff = new LinkedList<>();

   }

   /**
      Add a flight symbol to the taking off queue.
      @param flightSymbol the flight symbol.
   */
   public void addTakeOff(String flightSymbol)
   {
      takeOff.add(flightSymbol);

   }

   /**
      Add a flight symbol to the landing queue.
      @param flightSymbol the flight symbol.
   */
   public void addLanding(String flightSymbol)
   {
      land.add(flightSymbol);
       
   }

   /**
      Handle the next action.
   */
   public void handleNextAction()
   {
      int done = 1; //if done == 1, nothing has been done yet
      if (land.size() != 0 && (done != 0)) //if land has something in it and nothing has been done yet
      {
          String temp = land.remove();
          System.out.println(temp + " is landing"); //because you can't return so print
          done = 0; //something has been done
      }
      else if (takeOff.size() != 0 && (done != 0)) //if takeOff has something in it and nothing has been done yet
      {
          String temp = takeOff.remove();
          System.out.println(temp + " is taking off"); 
          done = 0; //something has been done
      }
      else if ((land.size() == 0) && (takeOff.size() == 0) && (done == 1)) //if both queues are empty and nothing has been done yet
      {
          System.out.println("No actions left to do");
      }
      }
  }


