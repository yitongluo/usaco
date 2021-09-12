/*
ID: yitongl1
LANG: JAVA
TASK: socdist1
*/
import java.io.*;
import java.util.*;

class socdist1
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new FileReader("socdist1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("socdist1.out")));
        
        int length = Integer.parseInt(in.readLine());
        boolean[] map = new boolean[length];
        String road = in.readLine();
        for (int i = 0; i < map.length; i++)
        {
            int current = Integer.parseInt(road.substring(i, i + 1));
            if (current == 0)
            {
                map[i] = false;
            }
            else
            {
                map[i] = true;
            }
        }
        int[] x = getanswer(map);
        int y = getanswer(map)[1]; 
        int min = getanswer(map)[2];
        if (y < min)
        {
            out.println(y);
        }
        else
        {
            out.println(min);
        }
        
        in.close();
        out.close();
    }

    public static int[] getanswer(boolean[] map)
    {
        int[] result = {0, 0, 0};
        int last = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < map.length; i++)
        {
            int currentgap = 0;
            if (map[i])
            {
                if (last == -1)
                {
                    last = i;
                    continue;
                }
                currentgap = i - last;
                min = Integer.min(min, currentgap);
                if (currentgap >= result[0])
                {
                    int temp = result[0];
                    result[0] = currentgap;
                    result[1] = temp;
                    last = i;
                }
                if (currentgap < result[0] && currentgap >= result[1])
                {
                    result[1] = currentgap;
                    last = i;
                }
            }
        }
        result[0]= result[0] / 2;
        result[1]/= result[1]/2;
        result[2] = min;
        return result;
    }
}