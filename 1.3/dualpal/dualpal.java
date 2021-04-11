/*
ID: yitongl1
LANG: JAVA
TASK: dualpal
*/
import java.io.*;
import java.util.*;

class dualpal
{
    public static void main (String [] args) throws IOException
    {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
                  // Get line, break into tokens
        int nAfter = Integer.parseInt(st.nextToken());
        int number = Integer.parseInt(st.nextToken());
        int [] result = new int[nAfter];

        int count = 0;
        for (int j = number + 1; count <= result.length - 1; j++)
        {   
            if (isDualPal(j))
            {
                result[count] = j;
                count++;
            }
        }

        for (int x : result)
        {
            out.println(x);
        }
        f.close();
        out.close();
    }

    private static boolean isDualPal(int value)
    {
        int temp = 0;
        for (int k = 2; k <= 10; k++)
        {
            if (isPal(toString(value, k)))
            {
                temp++;
                if (temp == 2)
                {
                    return true;
                }  
            }         
        }
        return false;
    }

    private static char getChar(int digit)
    {
        return digit > 9 ? (char)('A' + digit - 10) : (char)('0' + digit);
    }

    private static String toString(int value, int base)
    {
        String result = "";
        while (value > 0)
        {
            result = getChar(value % base) + result;
            value = value / base;
        }
        return result;
    }

    public static boolean isPal(String s)
    {
        for (int i = 0; i <= s.length() / 2; i++)
        {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
            {
                return false;
            }
        }
        return true;
    }
}