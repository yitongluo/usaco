import java.io.*;
import java.util.*;

class cowntagion
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int barnum = Integer.parseInt(in.readLine());
        ArrayList<ArrayList<Integer>> connection = new ArrayList<ArrayList<Integer>>();
        for (int a = 0; a < barnum; a++)
        {
            ArrayList<Integer> current = new ArrayList<Integer>();
            connection.add(current);
        }
        for (int b = 0;  b < barnum - 1; b++)
        {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int first = Integer.parseInt(st.nextToken()) - 1;
            int second = Integer.parseInt(st.nextToken()) - 1;
            connection.get(first).add(second);
            connection.get(second).add(first);
        }
        boolean[] went = new boolean[barnum];
        System.out.println(getdays(connection, 0, went));
    }

    public static int getdays (ArrayList<ArrayList<Integer>> connection, int currentbarn, boolean[] went)
    {
        went[currentbarn] = true;
        int result = 0;
        int connected;
        if (currentbarn == 0)
        {
            connected = connection.get(currentbarn).size();
        }
        else
        {
            connected = connection.get(currentbarn).size() - 1;
        }
        int cows = 1;
        while(cows < connected + 1)
        {
            cows = cows * 2;
            result++;
        }
        for (int i = 0; i < connection.get(currentbarn).size(); i++)
        {
            int temp = connection.get(currentbarn).get(i);
            if (went[temp] == false)
            {
                result++;
                result += getdays(connection, temp, went);
            }
        }
        return result;
    }
}