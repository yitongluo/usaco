/*
ID: yitongl1
LANG: JAVA
TASK: milkvisits
*/
import java.io.*;
import java.util.*;

class milkvisits
{
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("milkvisits.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        StringTokenizer st1 = new StringTokenizer(f.readLine());
        int barnum = Integer.parseInt(f.readLine());
        String breed = f.readLine();
        ArrayList<ArrayList<Integer>> connection = new ArrayList<ArrayList<Integer>>();
        for (int a = 0; a < barnum; a++)
        {
            ArrayList<Integer> current = new ArrayList<Integer>();
            connection.add(current);
        }
        for (int b = 0;  b < barnum - 1; b++)
        {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int first = Integer.parseInt(st.nextToken()) - 1;
            int second = Integer.parseInt(st.nextToken()) - 1;
            connection.get(first).add(second);
            connection.get(second).add(first);
        }

    }
}