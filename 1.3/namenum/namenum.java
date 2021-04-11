/*
ID: yitongl1
LANG: JAVA
TASK: namenum
*/
import java.io.*;
import java.util.*;

class namenum
{
    public static void main (String [] args) throws IOException
    {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
        getName(Long.parseLong(f.readLine()), out);
        out.close();                               
        f.close();
    }

                                //   A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z }
    private static int[] numbers = { 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 0, 7, 7, 8, 8, 8, 9, 9, 9, 0 };

    private static int getNumber(char ch)
    {
        return numbers[ch - 'A'];
    }

    private static void getName(long brand, PrintWriter out) throws IOException
    {
        boolean empty = true;
        BufferedReader dict = new BufferedReader(new FileReader("dict.txt"));
        for (String line = dict.readLine(); line != null; line = dict.readLine())
        {
            if (turnToLong(line) == brand)
            {
                out.println(line);
                empty = false;
            }
        }
        if (empty)
        {
            out.println("NONE");
        }

    }

    private static long turnToLong(String name)
    {
        long result = 0;
        for (int i = 0; i < name.length(); i++)
        {
            int digit = getNumber(name.charAt(i));
            result = result * 10 + digit;
        }
        return result;
    }
}