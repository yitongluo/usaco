/*
ID: yitongl1
LANG: JAVA
TASK: moobuzz
*/
import java.io.*;
import java.util.*;

class moobuzz
{
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("moobuzz.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moobuzz.out")));
        int[] list = {1, 2, 4, 7, 8, 11, 13, 14};
        int input = Integer.parseInt(f.readLine());
        int a = input/ 8* 15;
        int b = input % 8;
        if (b == 0)
        {
            out.println(a);
        }
        else
        {
            out.println(a + list[b - 1]);
        }
        f.close();
        out.close();
    }
}