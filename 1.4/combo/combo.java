/*
ID: yitongl1
LANG: JAVA
TASK: combo
*/
import java.io.*;
import java.util.*;

class combo
{
    public static void main (String [] args) throws IOException
    {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("combo.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        
        int[] john = new int [3];
        int[] master = new int[3];
        for (int line = 1; line <= 2; line++)
        {
            StringTokenizer x = new StringTokenizer(f.readLine());
            for (int i = 0; i < 3; i++)
            {
                if (line == 1)
                {
                    john[i] = Integer.parseInt(x.nextToken());
                }
                else
                {
                    master[i] = Integer.parseInt(x.nextToken());
                }
            }
        }
        if (n <= 5)
        {
            out.println(n * n * n);
        }
        else
        {
            out.println(250 - compute(john, master, n));
        }
        f.close();
        out.close();
    }

    public static int compute(int[] john, int[] master, int n)
    {
        int [] overlap = new int[3];
        int result = 1;
        for (int i = 0; i < 3; i++)
        {
            int[] a = getsurround(john[i], n);
            int[] b = getsurround(master[i], n);
            result = result *getSameElement(a, b);
        }
        return result;
    }

    public static int[] getsurround(int x, int n)
    {
        int[] result = {x + 1, x + 2, x, x - 1, x - 2};
        for (int i = 0; i < 5; i++)
        {
            if (result[i] > n)
            {
                result[i] = result[i] - n;
            }
            if (result[i] < 1)
            {
                result[i] = result[i] + n;
            }
        }
        return result;
    }

    public static int getSameElement(int[] a, int[] b )
    {
        int result = 0;
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                if (a[i] == b[j])
                {
                    result++;
                }
            }
        }
        return result;
    }
}