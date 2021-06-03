/*
ID: yitongl1
LANG: JAVA
TASK: numtri
*/
import java.io.*;
import java.util.*;

class numtri
{
    public static void main (String [] args) throws IOException
    {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("numtri.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        int line = Integer.parseInt(f.readLine());
        
                  // Get line, break into tokens
        int[][]triangle = new int[line][line];
        for (int i = 0; i < line; i++)
        {
            StringTokenizer st = new StringTokenizer(f.readLine());
            for (int count = 0; count <= i; count++)
            {
                triangle[i][count] = Integer.parseInt(st.nextToken());
            }
            //out.println(Arrays.toString(triangle[i]));
        }
        if (line == 1)
        {
            out.println(triangle[0][0]);
        }
        else
        {
            out.println(getresult(triangle, triangle[line - 1])[0]);
        }
        //out.println();
        f.close();
        out.close();
    }
    public static int[] getresult (int[][]triangle, int[] choice)
    {
        int[] next = new int[choice.length - 1];
        if (choice.length == 2)
        {
            next[0] = triangle[0][0] + Integer.max(choice[0], choice[1]);
            return next;
        }
        else
        {
            for (int i = 0; i < next.length; i++)
            {
                next[i] = triangle[choice.length - 2][i] + Integer.max(choice[i], choice[i + 1]);
            }
            System.out.println(Arrays.toString(next));
            return getresult(triangle, next);
        }
    }
}

