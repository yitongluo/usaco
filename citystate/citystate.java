/*
ID: yitongl1
LANG: JAVA
TASK: citystate
*/
import java.io.*;
import java.util.*;


class citystate
{
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("citystate.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));
        int amount = Integer.parseInt(f.readLine());
        int[][][][] cities = new int[26][26][26][26];
        int paired = 0;
        for (int a = 0; a < amount; a++)
        {
            String current = f.readLine();
            char state1 = current.charAt(current.length() - 2);
            char state2 = current.charAt(current.length() - 1);
            char citi1 = current.charAt(0);
            char citi2 = current.charAt(1);
            cities[state1 - 65][state2 - 65][citi1 - 65][citi2 - 65]++;
            if ((state1 != citi1 || state2 != citi2) && cities[citi1 - 65][citi2 - 65][state1 - 65][state2 - 65] != 0)
            {
                paired = paired + cities[citi1 - 65][citi2 - 65][state1 - 65][state2 - 65];
            }
        }
        out.println(paired);
        out.close();
        f.close();
    }
}