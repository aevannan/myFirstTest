import java.util.Stack;
/**
 * Write a description of class Grid here.
 * 
 * Aaina Vannan
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
       pairs.push(temp);
       pixels[row][column] = count; //for the first time
       count++;
       //before up and down, left and right
       while(count <= SIZE * SIZE) //less than a 100
       {
           temp = pairs.pop(); //start of going up/down/left/right & when done with the if statements, goes up back to pop it off
           if (((temp.getRow() - 1) >= 0) && (pixels[temp.getRow() -1][temp.getColumn()] == 0)) //checking north
           {
               //add pair to stack, add count to pixels, and change count
               pairs.push(new Pair(temp.getRow() - 1, temp.getColumn()));
               pixels[temp.getRow() -1][temp.getColumn()] = count;
               count++;
           }
           if (((temp.getColumn() + 1) < SIZE) && (pixels[temp.getRow()][temp.getColumn()+ 1] == 0)) //checking east
           {
               //add pair to stack, add count to pixels, and change count
               pairs.push(new Pair(temp.getRow(), temp.getColumn()+1));
               pixels[temp.getRow()][temp.getColumn()+1] = count;
               count++;
           }
           if (((temp.getRow() +1) < SIZE) && (pixels[temp.getRow() +1][temp.getColumn()] == 0)) //checking south
           {
               //add pair to stack, add count to pixels, and change count
               pairs.push(new Pair(temp.getRow() + 1, temp.getColumn()));
               pixels[temp.getRow() +1][temp.getColumn()] = count;
               count++;
           }
           if (((temp.getColumn() - 1) >= 0) && (pixels[temp.getRow()][temp.getColumn()-1] == 0)) //checking west
           {
               //add pair to stack, add count to pixels, and change count
               pairs.push(new Pair(temp.getRow(), temp.getColumn()-1));
               pixels[temp.getRow()][temp.getColumn()-1] = count;
               count++;
           }
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
          {
             r = r + String.format("%4d", pixels[i][j]);
          }
          r = r + "\n";
      }
      return r;
   }
}
