import java.util.*;
import java.io.*;
class Daisy2
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
        int[] list = new int[n];
        int count = 0;
        for (int i = 0; i < list.length; i++)
        {
            list[i] = Integer.parseInt(st.nextToken());
        }
        for (int end = 0; end < list.length; end++)
        {
            for (int start = 0; start <= end; start++)
            {
                if (determineAverage(list, start, end))
                {
                    //System.out.println(start + " " + end);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static boolean determineAverage(int[]list, int start, int end)
    {
        int total = addUp(list, start, end);
        int count = end - start + 1;
        int average = total / count;
        if (total % count != 0)
        {
            return false;
        }
        for (int x = start; x <= end; x++)
        {
            if (list[x] == average)
            {
                return true;
            }
        }
        return false;
    }

    private static int addUp(int[] list, int Start, int end)
    {
        int total = 0;
        for(int x = Start; x <= end; x++)
        {
            total = total + list[x];
        }
        return total;
    }   
}