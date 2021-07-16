/*
ID: yitongl1
LANG: JAVA
TASK: div7
*/
import java.io.*;
import java.util.*;

class div7
{
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("div7.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("div7.out")));
        int length = Integer.parseInt(f.readLine());
        int[] sum = new int[length + 1];
        int[] mode = new int[length + 1];
        for (int i = 1; i < sum.length; i++)
        {
            sum[i] = sum[i - 1] + Integer.parseInt(f.readLine());
            mode[i] = sum[i]% 7;
        }
        int[]first = {-1, -1, -1, -1, -1, -1, -1};
        int longest = -1;
        //out.println(Arrays.toString(mode));
        for (int i = 1; i < mode.length; i++)
        {
            int current = mode[i];
            if (first[current] == -1)
            {
                first[current] = i;
            }
            else
            {
                longest = Integer.max(longest, i - first[current]);
            }
        }
        if (longest == -1)
        {
            out.println(0);
        }
        else
        {
            out.println(longest);
        }
        f.close();
        out.close();
    }
}