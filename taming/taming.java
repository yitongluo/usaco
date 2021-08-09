/*
ID: yitongl1
LANG: JAVA
TASK: fenceplan
*/
import java.io.*;
import java.util.*;

class taming
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("taming.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("taming.out")));
        int length = Integer.parseInt(f.readLine());
        int[] input = new int[length];
        StringTokenizer st = new StringTokenizer(f.readLine());
        for (int i = 0; i < length; i++)
        {
            input[i] = Integer.parseInt(st.nextToken());
        }
        input[0] = 0;
        if (verify(input))
        {
            int a = getmin(input);
            int b = getmin(maxform(input));
            out.println(a + " " + b);
        }
        else
        {
            out.println(-1);
        }
        f.close();
        out.close();
    }
    public static boolean  verify (int[] input)
    {
        for (int i = 0; i < input.length; i++)
        {
            int current = input[i];
            if (!(current == 0 || current == -1))
            {
                if (i-current < 0)
                {
                    return false;
                }
                for (int j = 1; j <= current; j++)
                {
                    if (input[i - j] != current - j && input[i - j] != -1)
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static int[] maxform(int[] input)
    {
        for (int i = 0; i < input.length; i++)
        {
            int current = input[i];
            if (current > 0)
            {
                for (int j = 1; j <= current; j++)
                {
                    input[i - j] = current - j;
                }
            }
        }
        for (int a = 0; a < input.length; a++)
        {
            if (input[a] < 0)
            {
                input[a] = 0;
            }
        }
        return input;
    }
    public static int getmin(int[] input)
    {
        boolean[] brout = new boolean[input.length];
        for (int i = 0; i < input.length; i++)
        {
            if (input[i] == 0)
            {
                brout[i] = true;
            }
            if (input[i] > 0)
            {
                brout[i - input[i]] = true;
            }
        }
        return count(brout);
        
    }
    public static int count(boolean[] input)
    {
        int count = 0;
        for (boolean a : input)
        {
            if (a)
            {
                count++;
            }
        }
        return count;
    }
}