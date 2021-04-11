/*
ID: yitongl1
LANG: JAVA
TASK: palsquare
*/
import java.io.*;
import java.util.*;

class palsquare
{
    public static void main (String [] args) throws IOException
    {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
                  // Get line, break into tokens
        int base= Integer.parseInt(st.nextToken()); 

        for (int i = 1; i<= 300; i++)
        {
            String s = toString(i * i, base);
            if (isPal(s))
            {
                out.println(toString(i, base) + " " + s);
            }
        }                          
        out.close();                                  
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