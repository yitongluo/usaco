/*
ID: yitongl1
LANG: JAVA
TASK: whereami
*/
import java.io.*;
import java.util.*;


class whereami
{
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("whereami.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("whereami.out")));
        int length = Integer.parseInt(f.readLine());
        String road = f.readLine();
        for (int i = 1; i <= length; i++)
        {
            if (isok(road, i))
            {
                out.println(i);
                break;
            }
        }
        f.close();
        out.close();
    }
    public static boolean isok(String road, int sublength)
    {
        for (int a = 0; a < road.length(); a++)
        {
            for (int b = a + sublength; b <road.length(); b++)
            {
                String currentsub =  road.substring(a, b);
                String rest = road.substring(b, road.length());
                if (rest.indexOf(currentsub) != -1)
                {
                    return false;
                }
            }
        }
        return true;
    }
}