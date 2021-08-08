/*
ID: yitongl1
LANG: JAVA
TASK: convention
*/
import java.io.*;
import java.util.*;

class convention
{
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("perimeter.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));
        int n = Integer.parseInt(f.readLine());
        int[][] map = new int[n + 2][n + 2];
        for (int a = 0; a < n; a++)
        {
            String current = f.readLine();
            for (int b = 0; b < n; b++)
            {
                if (current.charAt(b) == '#')
                {
                    map[a + 1][b + 1]++;
                }
            }
        }
        for (int i = 0; i < n + 2; i++)
        {
            System.out.println(Arrays.toString(map[i]));
        }
        boolean[][]went = new boolean[n + 2][n + 2];
        int max = Integer.MIN_VALUE;
        // for (int c= 0; c < n; c++)
        // {
        //     for (int d = 0; d < n; d++)
        //     {
        //         max = Integer.max(getarea(map, went, c + 1, d + 1), max);
        //     }
        // }
        out.println(getarea(map, went, 2, 5));
        out.close();
        f.close();
    }

    public static int getarea(int[][] map, boolean[][] went, int x, int y)
    {
        int result = 0;
        System.out.println(map[x][y] == 1);
        if (!went[x][y] && map[x][y] == 1)
        {
            went[x][y] = true;
            if (!went[x - 1][y] && map[x - 1][y] == 1)
            {
                went[x - 1][y] = true;
                result++;
                result += getarea(map, went, x - 1, y);
            }
            if (!went[x + 1][y] && map[x + 1][y] == 1)
            {
                went[x + 1][y] = true;
                result++;
                result += getarea(map, went, x + 1, y);
            }
            if (!went[x][y - 1] && map[x][y - 1] == 1)
            {
                went[x][y - 1] = true;
                result++;
                result += getarea(map, went, x, y - 1);
            }
            if (!went[x][y + 1] && map[x][y + 1] == 1)
            {
                went[x][y + 1] = true;
                result++;
                result += getarea(map, went, x, y + 1);
            }
            return result;
        }
        return 1;
    }
}