/*
ID: yitongl1
LANG: JAVA
TASK: factory
*/
import java.io.*;
import java.util.*;

class factory
{
    public static void main (String [] args) throws IOException
    {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("factory.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("factory.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
                  // Get line, break into tokens
        int n = Integer.parseInt(st.nextToken());  //number of cows  
        boolean [][] map  = new boolean[n + 1][n + 1]; //matrix of the factory, first index is the destination, each array is the 
        //place that can go there.
        int[] eachcount = new int[n + 1];
        for (int i = 0; i < map.length; i++)
        {
            for (int j = 0; j < map[0].length; j++)
            {
                map[i][j] = false;
            }
        }
        for (int i = 0; i < n - 1; i++)
        {
            StringTokenizer x = new StringTokenizer(f.readLine());
            int start = Integer.parseInt(x.nextToken());
            int end  = Integer.parseInt(x.nextToken());
            map[end][start] = true;
            eachcount[end]++;
        }
        for (int i = 0; i < n; i++)
        {
            System.out.println(Arrays.toString(map[i]));
        }

        
        System.out.println(Arrays.toString(eachcount));
        boolean binary = false;
        for (int i = 1; i < n; i++)
        {
            if (NextConnected(map, i, eachcount) == n - 1)
            {
                out.println(i);
                binary = true;
                break;
            }
        }       
        if (!binary)   
        {
            out.println(-1);
        }        
        out.close();                                  
        f.close();
    }

    public static int NextConnected (boolean[][] map, int index, int[]eachcount)
    {
        int size = map.length;
        int total = eachcount[index];
        for (int i = 0; i < size; i++)
        {
            if (map[index][i] == true)
            {
                total = total + NextConnected(map, i, eachcount);
            }
        }
        return total;
    }
}