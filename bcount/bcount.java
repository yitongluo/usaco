/*
ID: yitongl1
LANG: JAVA
TASK: bcount
*/
import java.io.*;
import java.util.*;

class bcount
{
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("bcount.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("bcount.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int length = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[][] sum = new int [length + 1][3];
        for (int i = 1; i < sum.length; i++)
        {
            int current =  Integer.parseInt(f.readLine());
            for (int j = 0; j < 3; j++)
            {
                if (j == current - 1)
                {
                    sum[i][j] = sum[i - 1][j] + 1;
                }
                else
                {
                    sum[i][j] = sum[i - 1][j];
                }
            }
            //out.println(Arrays.toString(sum[i]));
        }

        for (int i = 1; i <= q; i++)
        {
            StringTokenizer x = new StringTokenizer(f.readLine());
            int left = Integer.parseInt(x.nextToken());
            int right = Integer.parseInt(x.nextToken());
            int one = sum[right][0] - sum[left - 1][0];
            int two = sum[right][1] - sum[left - 1][1];
            int three = sum[right][2] - sum[left - 1][2];
            out.println(one + " " + two + " " + three);
        }
        out.close();                               
        f.close();
    }
}