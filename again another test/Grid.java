import java.util.Stack;
/**
 * Write a description of class Grid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Grid
{
   private static final int SIZE = 10;
   int[][] pixels = new int[SIZE][SIZE];
   Stack <Pair> pairs = new Stack<>(); //has the pairs
   int count = 1;
   /**
    * Flood fill, starting with the given row and column.
    */
   public void floodfill(int row, int column)
   {
       Pair temp = new Pair(row, column);
       if(temp.getNum() == 0) //if the pair doesnt have a number, then push it off onto the stack
       {
           pairs.push(new Pair(row, column));
           temp.changeNum(count);
           count++;
       }
   }

   /**
    * @return the given array
    */
   public String toString()
   {
      String r = "";
      for (int i = 0; i < SIZE; i++)
      {
         for (int j = 0; j < SIZE; j++)
            r = r + String.format("%4d", pixels[i][j]);
         r = r + "\n";
      }
      return r;
   }
   
   /**
    * @return the stack Pairs
    */
   public Stack returnPairs()
   {
       return pairs;
   }
}
