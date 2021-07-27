/*
ID: yitongl1
LANG: JAVA
TASK: mootube
*/
import java.io.*;
import java.util.*;

class mootube
{
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("mootube.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
        StringTokenizer s = new StringTokenizer(f.readLine());
        int cows = Integer.parseInt(s.nextToken());
        int quest = Integer.parseInt(s.nextToken());
        ArrayList<ArrayList<Integer>> connection = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> relevance = new ArrayList<ArrayList<Integer>>();
        for (int a = 0; a < cows; a++)
        {
            ArrayList<Integer> empty =  new ArrayList<Integer>();
            ArrayList<Integer> empty2 =  new ArrayList<Integer>();
            connection.add(empty);
            relevance.add(empty2);
        }

        for (int b = 0; b < cows - 1; b++)
        {
            StringTokenizer x = new StringTokenizer(f.readLine());
            int first = Integer.parseInt(x.nextToken()) - 1;
            int second = Integer.parseInt(x.nextToken()) - 1;
            int third = Integer.parseInt(x.nextToken());
            connection.get(first).add(second);
            connection.get(second).add(first);
            relevance.get(first).add(third);
            relevance.get(second).add(third);
        }
        for (int j : connection.get(1))
        {
            System.out.println(j);
        }
        for (int c = 0; c < quest; c++)
        {
            StringTokenizer y = new StringTokenizer(f.readLine());
            boolean[]went = new boolean[cows];
            int min = Integer.MAX_VALUE;
            int k = Integer.parseInt(y.nextToken());
            int from = Integer.parseInt(y.nextToken()) - 1; 
            went[from] = true;
            out.println(search(connection, relevance, went, from, k, min));
        }  
        out.close();
        f.close();  
    }

    public static int search(ArrayList<ArrayList<Integer>> connection, ArrayList<ArrayList<Integer>> relevance,
    boolean[] went, int from, int k, int min)
    {   
        int result = 0;
        ArrayList<Integer> current = connection.get(from);
        ArrayList<Integer> temprele = relevance.get(from);
        for (int i = 0; i < current.size(); i++)
        {
            int rele = Integer.min(temprele.get(i), min);
            if (!went[current.get(i)] && rele >= k)
            {
                went[current.get(i)] = true;
                result++;
                result += search(connection, relevance, went, current.get(i), k, rele);
            }
        }
        return result;
    }
}