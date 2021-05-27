import java.io.*;
import java.util.*;

class prob1
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int pages = Integer.parseInt(st.nextToken());
        int addition = Integer.parseInt(st.nextToken());
        int[] eachCitecount = new int[100001];
        StringTokenizer Citationreader = new StringTokenizer(in.readLine());//Citation number read for each page
        int max = -1;
        for (int i = 0; i < pages; i++)
        {
            int current= Integer.parseInt(Citationreader.nextToken());
            if (current > max)
            {
                max = current; 
            }
            eachCitecount[current]++;
        }

        int count = 0;
        int hindex = -1;
        for (int i = max; i >= 0; i--)
        {
            count = count + eachCitecount[i];
            if (count >= i)
            {
                hindex = i;
                break;
            }
        }
        // System.out.println(hindex);
        // System.out.println(count);
        // System.out.println(increment(addition, eachCitecount[hindex]));
        if(count - eachCitecount[hindex] + increment(addition, eachCitecount[hindex]) < hindex + 1)
        {
            System.out.println(hindex);
        }
        else
        {
            System.out.println(hindex + 1);
        }

    }

    public static int increment(int a, int b)//a is number of additional citation, b is number of paper with exact h cite
    {
        if (a > b)
        {
            return b;
        }
        return a;
    }
}