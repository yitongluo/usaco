/*
ID: yitongl1
LANG: JAVA
TASK: hps
*/
import java.io.*;
import java.util.Arrays;

class hps
{
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("hps.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
        int games = Integer.parseInt(f.readLine());
        int[] h = new int[games];
        int[] p = new int[games];
        int[] s = new int[games];
        for (int a = 0; a < games; a++)
        {
            String current = f.readLine();
            if (current.equals("H"))
            {
                h[a] = 1;
            }
            if (current.equals("P"))
            {
                p[a] = 1;
            }
            if (current.equals("S"))
            {
                s[a] = 1;
            }
        }
        for (int b = 1; b < games; b++)
        {
            h[b] = h[b - 1] + h[b];
            p[b] = p[b - 1] + p[b];
            s[b] = s[b - 1] + s[b];
        }
        System.out.println(Arrays.toString(s));
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < games; i++)
        {
            int temp = 0;
            if (p[i] >= h[i] && p[i] >= s[i])
            {
                temp = p[i] + Integer.max(h[games - 1] - h[i], s[games - 1] - s[i]);
                max = Integer.max(temp, max);
            }
            if (h[i] >= p[i] && h[i] >= s[i])
            {
                temp = h[i] + Integer.max(p[games - 1] - p[i], s[games - 1] - s[i]);
                max = Integer.max(temp, max);
            }
            if (s[i] >= h[i] && s[i] >= p[i])
            {
                temp = s[i] + Integer.max(h[games - 1] - h[i], p[games - 1] - p[i]);
                max = Integer.max(temp, max);
            }
        }
        out.println(max);
        f.close();
        out.close();
    }
}