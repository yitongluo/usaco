/*
ID: yitongl1
LANG: JAVA
TASK: pails
*/
import java.io.*;
import java.util.*;


class pails
{
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("pails.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));
        StringTokenizer s = new StringTokenizer(f.readLine());
        int bucketa = Integer.parseInt(s.nextToken());
        int bucketb = Integer.parseInt(s.nextToken());
        int operation = Integer.parseInt(s.nextToken());
        int ideal = Integer.parseInt(s.nextToken());
        ArrayList<Integer>first = new ArrayList<Integer>();
        ArrayList<Integer>second = new ArrayList<Integer>();
        first.add(0);
        second.add(0);
        boolean[][] used= new boolean[bucketa + 1][bucketb + 1];
        changestate(first, second, bucketa, bucketb, 0, operation, used);
        int close = Integer.MAX_VALUE;
        for (int i = 0; i <= bucketa; i++)
        {
            for (int j = 0; j <= bucketb; j++)
            {
                int current = Integer.MAX_VALUE;
                if (used[i][j])
                {
                    current = i + j - ideal;
                }
                if (current < 0)
                {
                    current = current * -1;
                }
                close = Integer.min(current, close);
            }
        }
        out.println(close);
        out.close();
        f.close();
    }
    public static boolean[][] changestate(ArrayList<Integer>first, ArrayList<Integer>second, int acap, int bcap,
    int state, int total, boolean[][] used)
    {
        if (state == total)
        {
            return used;
        }
        int currentleng = first.size();
        ArrayList<Integer>first1 = new ArrayList<Integer>();
        ArrayList<Integer>second1 = new ArrayList<Integer>();
        for (int i = 0; i < currentleng; i++)
        {
            int currenta = first.get(i);
            int currentb = second.get(i);
            if (!used[currenta][0])
            {
                first1.add(currenta);
                second1.add(0);
                used[currenta][0] = true;
            }
            if (!used[0][currentb])
            {
                first1.add(0);
                second1.add(currentb);
                used[0][currentb] = true;
            }
            if (!used[currenta][bcap])
            {
                first1.add(currenta);
                second1.add(bcap);
                used[currenta][bcap] = true;
            }
            if (!used[acap][currentb])
            {
                first1.add(acap);
                second1.add(currentb);
                used[acap][currentb] = true;
            }
            int[] poura = pourto(currenta, currentb, acap, bcap, true);
            int[] pourb = pourto(currenta, currentb, acap, bcap, false);
            int a1 = poura[0];
            int b1 = poura[1];
            int a2 = pourb[0];
            int b2 = pourb[1];
            if (!used[a1][b1])
            {
                first1.add(a1);
                second1.add(b1);
                used[a1][b1] = true;
            }
            if(!used[a2][b2])
            {
                first1.add(a2);
                second1.add(b2);
                used[a2][b2] = true;
            }
        }
        // System.out.println("******************");
        // for (int j = 0; j < first1.size(); j++)
        // {
        //     System.out.println(first1.get(j) + " " + second1.get(j));
        // }
        return changestate(first1, second1, acap, bcap, state + 1, total, used);
    }


    public static int[] pourto(int a, int b, int ac, int bc, boolean to)
    {
        int[] result = new int[2];
        if (to)
        {
            result[0] = a + b;
            result[1] = 0;
            if (a + b > ac)
            {
                result[0] = ac;
                result[1] = a + b - ac;
            }
        }
        if (!to)
        {
            result[1] = a + b;
            result[0] = 0;
            if (a + b > bc)
            {
                result[1] = bc;
                result[0] = a + b - bc;
            }
        }
        return result;
    }
}