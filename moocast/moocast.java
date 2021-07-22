/*
ID: yitongl1
LANG: JAVA
TASK: moocast
*/
import java.io.*;
import java.util.*;

class moocast
{
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("moocast.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
        int population = Integer.parseInt(f.readLine());
        int[][] cowinformation = new int[population][3];
        for (int i = 0; i < population; i++)
        {
            StringTokenizer st = new StringTokenizer(f.readLine());
            for (int j = 0; j < 3; j++)
            {
                cowinformation[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] connection = new int[population][population];
        for (int a = 0; a < population; a++)
        {
            for (int b = 0; b < population; b++)
            {
                connection[a][b] = -1;
            }
        }
        for (int c = 0; c < population; c++)
        {
            int count = 0;
            for (int d = 0; d < population; d++)
            {
                int x1 = cowinformation[c][0];
                int y1 = cowinformation[c][1];
                int power = cowinformation[c][2];
                int x2 = cowinformation[d][0];
                int y2 = cowinformation[d][1];
                if (isconnected(x1, y1, x2, y2, power))
                {
                    connection[c][count] = d;
                    count++;
                }
            }
        }
        int max = -1;
        for (int x = 0; x < population; x++)
        {
            boolean[] connected = new boolean[population];
            for (int e = 0; e < connected.length; e++)
            {
                connected[e] = false;
            }
            int temp = getallconnection(connection, x, connected);
            if (temp > max)
            {
                max = temp;
            }
        }
        out.println(max);
        f.close();
        out.close();
    }
    public static int getallconnection (int[][] connection, int from, boolean[] connected)
    {
        int result = 0;
        if (connected[from] == false)
        {
            result++;
            connected[from] = true;
        }
        for (int i = 0; connection[from][i] != -1; i++)
        {
            int current = connection[from][i];
            if (connected[current] == false)
            {
                connected[current] = true;
                result++;
                result = result + getallconnection(connection, current, connected);
            }
        }
        return result;
    }

    public static boolean isconnected (int x1, int y1, int x2, int y2, int power)
    {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) <= power * power;
    }
}