/*
ID: yitongl1
LANG: JAVA
TASK: planting
*/
import java.io.*;
import java.util.*;

class planting
{
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("planting.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("planting.out")));
        int fields = Integer.parseInt(f.readLine());
        ArrayList<ArrayList<Integer>> connection = new ArrayList<ArrayList<Integer>>();
        for (int a = 0; a < fields; a++)
        {
            ArrayList<Integer> empty =  new ArrayList<Integer>();
            connection.add(empty);
        }
        for (int b = 0; b < fields - 1; b++)
        {
            StringTokenizer x = new StringTokenizer(f.readLine());
            int first = Integer.parseInt(x.nextToken()) - 1;
            int second = Integer.parseInt(x.nextToken()) - 1;
            connection.get(first).add(second);
            connection.get(second).add(first);
        }
        boolean[] went = new boolean[fields];
        int[] min = {1};
        went[0] = true;
        getresult(0, connection, min, went);
        out.println(min[0]);
        out.close();
        f.close();
    }
    public static void getresult(int from, ArrayList<ArrayList<Integer>> connection, int[] min, boolean[]
    went)
    {
        ArrayList<Integer> current = connection.get(from);
        int related = current.size() + 1;
        min[0] = getmin(related, min[0]);
        for (int j = 0; j < current.size(); j++)
        {
            if (!went[current.get(j)])
            {
                went[current.get(j)] = true;
                getresult(current.get(j), connection, min, went);
            }
        }
    }

    public static int getmin(int related, int min)
    {
        int temp = Integer.max(related, min);
        return temp;
    }
}