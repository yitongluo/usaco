/*
ID: yitongl1
LANG: JAVA
TASK: closing
*/
import java.io.*;
import java.util.*;
class closing
{
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("closing.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("closing.out")));
        StringTokenizer s = new StringTokenizer(f.readLine());
        int barns = Integer.parseInt(s.nextToken());
        int roads = Integer.parseInt(s.nextToken());
        ArrayList<ArrayList<Integer>> connection = new ArrayList<ArrayList<Integer>>();
        for (int a = 0; a < barns; a++)
        {
            ArrayList<Integer> empty =  new ArrayList<Integer>();
            connection.add(empty);
        }
        for (int b = 0; b < roads; b++)
        {
            StringTokenizer x = new StringTokenizer(f.readLine());
            int first = Integer.parseInt(x.nextToken()) - 1;
            int second = Integer.parseInt(x.nextToken()) - 1;
            connection.get(first).add(second);
            connection.get(second).add(first);
        }
        boolean [] used = new boolean[barns];
        int[] closelist = new int[barns];
        for (int c = 0; c < closelist.length; c++)
        {
            int current = Integer.parseInt(f.readLine());
            closelist[c] = current - 1;
        }
        int last = closelist[barns - 1];
        run(connection, used, last);
        out.println(isconnect(used));
        boolean[] closed = new boolean[barns];
        for (int i = 0; i < barns - 2; i++)
        {
            closed[closelist[i]] = true;
            boolean[] copy = closed.clone();
            run(connection, copy, last);
            out.println(isconnect(copy));
        }
        out.println("YES");
        out.close();
        f.close();
    }
    public static void run(ArrayList<ArrayList<Integer>> connection, boolean[] used, int start)
    {
        //used[start] = true;
        ArrayList<Integer> current = connection.get(start);
        for (int i = 0; i < current.size(); i++)
        {
            int temp = current.get(i);
            if (!used[temp])
            {
                used[temp] = true;
                run(connection, used, temp);
            }
        }
    }
    public static String isconnect(boolean[] used)
    {
        for (boolean x : used)
        {
            if (!x)
            {
                return "NO";
            }
        }
        return "YES";
    }
}

    

 