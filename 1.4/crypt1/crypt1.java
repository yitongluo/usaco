/*
ID: yitongl1
LANG: JAVA
TASK: crypt1
*/
import java.io.*;
import java.util.*;

class crypt1
{
    public static void main (String [] args) throws IOException
    {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("crypt1.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
        int size = Integer.parseInt(f.readLine());
        int[] list = new int[size];
        boolean[] binary = new boolean[10];
        for (int i = 0; i < 10; i++)
        {
            binary[i] = false;
        }
        StringTokenizer st = new StringTokenizer(f.readLine());
        for (int j = 0; j < size; j++)
        {
            int current = Integer.parseInt(st.nextToken());
            list[j] = current;
            binary[current] = true;
        }
        out.println(Try(list, binary));
        out.close();                                 
        f.close();
    }

    public static int Try(int[] list, boolean[] binary)
    {
        int temp = 0;
        for (int i = 0; i < list.length; i++)
        {
            for (int j = 0; j < list.length; j++)
            {
                for (int k = 0; k < list.length; k++)
                {
                    for (int a = 0; a < list.length; a++)
                    {
                        for (int b = 0; b < list.length; b++)
                        {
                            int first = list[i] * 100 + list[j] * 10 + list[k];
                            int second = list[a] * 10 + list[b];
                            int partialA = first * list[a];
                            int partialB = first * list[b];
                            if (partialA < 1000 && partialB < 1000 && isValid(partialA, binary) 
                            && isValid(partialB, binary) && isValid(first * second, binary) && first * second < 10000)
                            {
                                temp++;
                            }
                        }
                    }
                }
            }
        }
        return temp;
    }

    public static boolean isValid(int input, boolean[] list)
    {
        while (input != 0)
        {
            int digit = input % 10;
            if (list[digit] != true)
            {
                 return false;
            }
            input = input/10; 
        }
        return true;
    }
}