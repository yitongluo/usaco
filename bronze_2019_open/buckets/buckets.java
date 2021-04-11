/*
ID: yitongl1
LANG: JAVA
TASK: buckets
*/
import java.io.*;
import java.util.*;

class buckets
{
    public static void main (String [] args) throws IOException
    {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("buckets.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("buckets.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        int[] rock = new int[2];
        int[] barn = new int[2];
        int[] lake = new int[2];
        for (int i = 0; i < 10; i++)
        {
            String currentline = f.readLine();
            for (int j = 0; j < 10; j++)
            {
                char currentword = currentline.charAt(j);
                if ( currentword == 'B')
                {
                    barn [0] = j;
                    barn [1] = i;   
                }
                if (currentword == 'L')
                {
                    lake[0] = j;
                    lake[1] = i;
                }  
                if (currentword == 'R')
                {
                    rock[0] = j;
                    rock[1] = i;
                }
            }
        }  
        int deltax = getdelta(lake, barn, 0);
        int deltay = getdelta(lake, barn, 1);
        //out.println(deltax);
        //out.println(deltay);
        out.println(deltax + deltay - 1);
        out.close();                                  
        f.close();
    }

    public static int getdelta(int[] lake, int[] barn, int index)
    {
        if (barn[index] <= lake[index])
        {
            return lake[index] - barn[index];
        }
        else
        {
            return barn[index] - lake[index];
        }
    }
}