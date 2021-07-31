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
        boolean[]canceled = new boolean[barns];
        int max = barns;
        
        for (int c = 1; c < barns - 2; c++)
        {
            int input = Integer.parseInt(f.readLine()) - 1;
            ArrayList<Integer> temp = connection.get(input);
            canceled[input] = true;
            max--;
            boolean[] used = Arrays.copyOf(canceled, barns);
            used[getnonclose(canceled)] = true;
            if (getallconnection(getnonclose(canceled), connection, used) == max)
            {
                out.println("YES");
            }
            else
            {
                out.println("NO");
            }
        }
        out.println("YES");
        out.close();
        f.close();
    }

    public static int getallconnection(int from, ArrayList<ArrayList<Integer>> connection, boolean[]
    used)
    {
        int result = 0;
        ArrayList<Integer> current = connection.get(from);
        for (int i = 0; i < current.size(); i++)
        {
            if (!used[current.get(i)])
            {
                used[current.get(i)] = true;
                result++;
                result = getallconnection(current.get(i), connection, used);
            }
        }
        return result;
    }

    public static int getnonclose(boolean[] canceled)
    {
        for (int i = 0; i < canceled.length; i++)
        {
            if (!canceled[i])
            {
                return i;
            }
        }
        return -1;
    }

}