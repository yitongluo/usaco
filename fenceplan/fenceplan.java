/*
ID: yitongl1
LANG: JAVA
TASK: fenceplan
*/
import java.io.*;
import java.util.*;

class fenceplan
{
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("fenceplan.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fenceplan.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int population = Integer.parseInt(st.nextToken());
        int connectionnum = Integer.parseInt(st.nextToken());
        int[][] cowinformation = new int[population][2];
        boolean[] grouped = new boolean[population];
        for (int a = 0; a < population; a++)
        {
            StringTokenizer x = new StringTokenizer(f.readLine());
            cowinformation[a][0] = Integer.parseInt(x.nextToken());
            cowinformation[a][1] = Integer.parseInt(x.nextToken());
        }
        //System.out.println(Arrays.toString(cowinformation[2]));
        ArrayList<ArrayList<Integer>> connection = new  ArrayList<ArrayList<Integer>>();
        for (int b = 0; b < population; b++)
        {
            ArrayList<Integer> current = new ArrayList<Integer>();
            connection.add(current);
        }
        for (int c = 0; c < connectionnum; c++)
        {
            StringTokenizer s = new StringTokenizer(f.readLine());
            int first =Integer.parseInt(s.nextToken());
            int second = Integer.parseInt(s.nextToken());
            connection.get(first - 1).add(second - 1);
            connection.get(second - 1).add(first - 1);
        }

        // for (int e = 0; e <  connection.size(); e++)
        // {
        //     System.out.println(e + ":");
        //     for (int g = 0; g < connection.get(e).size(); g++)
        //     {
        //         System.out.println(connection.get(e).get(g) + "   ");
        //     }
        // }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < population; i++)
        {
            int[] extreme = {Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE };
            if (grouped[i] == false)
            {
                grouped[i] = true;
                changextreme(i, cowinformation, extreme);
                getgroup(connection, grouped, i, extreme, cowinformation);
                min = Integer.min(min, getperi(extreme));
            }
        } 
        
        out.println(min); 
        f.close();
        out.close(); 
    }

    public static void getgroup(ArrayList<ArrayList<Integer>> connection, boolean[] grouped, int from, 
    int[] extreme, int[][] cowinformation)
    {
        for (int i = 0; i < connection.get(from).size(); i++)
        {
            int current = connection.get(from).get(i);
            if (grouped[current] == false)
            {
                grouped[current] = true;
                //System.out.println(Arrays.toString(extreme));
                changextreme(current, cowinformation, extreme);
                getgroup(connection, grouped, current, extreme, cowinformation);
            }
        }
    }

    public static void changextreme(int current, int[][] cowinformation, int[] extreme)
    {
        int x = cowinformation[current][0];
        int y = cowinformation[current][1];
        //System.out.println(x + " " + y);
        extreme[0] = Integer.max(x, extreme[0]);
        extreme[1] = Integer.min(x, extreme[1]);
        extreme[2] = Integer.max(y, extreme[2]);
        extreme[3] = Integer.min(y, extreme[3]);
    }

    public static int getperi(int[] extreme)
    {
        int ans =  (extreme[0] - extreme[1]) + extreme[2] - extreme[3];
        return 2 * ans;
    }
}