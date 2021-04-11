/*
ID: yitongl1
LANG: JAVA
TASK: beads
*/
import java.io.*;
import java.util.*;

class beads
{
    public static void main (String [] args) throws IOException
    {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("beads.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        int i1 = Integer.parseInt(f.readLine());   
        String necklace = f.readLine();
        String doubled = necklace + necklace;
        
        int maximum = 0;
        for (int start = 0; start < necklace.length(); start++)
        {

            int temp = check(start, doubled);
            if (temp > maximum)
            {
                maximum = temp;
            }
        }
        out.println(maximum);
        out.close();
        f.close();
    }

    private static int check(int index, String necklace)
    {
        int n = necklace.length() / 2;
        int resultForward = check(index, n, necklace, 1);
        int resultBackward = check(index + n - 1, n - resultForward, necklace, -1);
        return resultForward + resultBackward;
    }

    private static int check(int index, int count, String necklace, int direction)
    {
        char first = necklace.charAt(index);
        if (first == 'w')
        {
            return Math.max(check(index, count, necklace, 'b', direction), check(index, count, necklace, 'r', direction));
        }
        else
        {
           return check(index, count, necklace, first, direction);
        }
    }

    public static int check(int index, int count, String necklace, char color, int direction)
    {
        int result = 0;
        for (int i = 0; i < count; i++)
        {
            char current = necklace.charAt(index + i * direction);
            if (current == color || current == 'w')
            {
                result++;
            }
            else
            {
                break;
            }
        }
        return result;
    }

}
