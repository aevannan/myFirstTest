
/**
 * Pair has row and column attributes
 * 
 * Aaina Vannan
 * Pair class
 */
public class Pair
{
    private int row;
    private int col;
    private int num; //the assigned number - can be changed
    /**
     * @param takes in the row and column number
     */
    public Pair(int r, int c)
    {
        row = r;
        col = c;
        num = 0;
    }
    
    /**
     * @return returns the row number
     */
    
    public int getRow()
    {
        return row;
    }
    
    /**
     * @return returns the column number
     */
    public int getColumn()
    {
        return col;
    }

    /**
     * @return returns 
     */
    public int getNum()
    {
        return num;
    }
}
