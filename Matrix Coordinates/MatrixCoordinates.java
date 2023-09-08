
/**
 * This class creates a String representation of a matrix of (x,y) coordinates
 * of 'rows' rows and 'cols' columns, both in normal order, and reverse order.
 *
 * @author (your name)
 * @version (today's date)
 */
public class MatrixCoordinates
{
    public static String normalOrder(int rows, int cols)
    {
        String result = "";
        // these nested loops go forwards, starting with the first row and column
        int row = 0;  // put your rows loop here 
        while(row < rows){
            int column = 0;
            while(column < cols){
                result += "("+row+","+column+")";
                column++;
            }
            result += "\n";
            row++;
        }
        return result;
    }
    
    public static String reverseOrder(int rows, int cols)
    {
        String result = "";
        // these nested loops go forwards, starting with the first row and column
        int row = rows - 1;  // put your rows loop here 
        while(row >= 0){
            int column = cols - 1;
            while(column >= 0){
                result += "("+row+","+column+")";
                column--;
            }
            result += "\n";
            row--;
        }
        return result;
    }
}
