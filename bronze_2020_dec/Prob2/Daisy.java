import java.io.*;
import java.util.*;


class Daisy
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int amount = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
        int [] list = new int[amount];
        int count = 0;
        for (int i = 0; i < list.length; i++)
        {
            list[i] = Integer.parseInt(st.nextToken());
        }
        for (int j = 0; j < list.length; j++)
        {
            for (int i = 0; i <= j; i++)
            {
                if (determineaAverage(list, i, j));
                {
                    count = count + 1;
                }
            }
        }
        System.out.println(count);
    }

    private static int addUp(int[] list, int i, int j)
    {
        int temp = 0;
        for (int x = i; x <= j; x++)
        {
            temp = temp + list[x];
        }
        return temp;
    }

    private static boolean determineaAverage(int[] list, int i, int j)
    {
        int total = addUp(list, i, j);
        int count = 1 + j - i;
        int averageValue = total / count;
        //4bSystem.out.println("(" + i + "," + j + ")" + total + " " + count + " " + averageValue);
        if (total % count == 0)
        {
            for (int x = i; x <= j; x++)
            {
                if (list[x] == averageValue)
                {
                    return true;
                }
            }
        }
        return false;
    }

}