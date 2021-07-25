import java.io.*;
import java.util.*;

class prob1
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int population = Integer.parseInt(st.nextToken());
        int[][] cowinformation = new int[population][2];
        for (int a = 0; a < cowinformation.length; a++)
        {
            StringTokenizer x = new StringTokenizer(in.readLine());
            cowinformation[a][0] = Integer.parseInt(x.nextToken()) + 1;
            cowinformation[a][1] = Integer.parseInt(x.nextToken()) + 1;
        }
        //System.out.println(cowinformation[0][0] + "  " + cowinformation[0][1]);
        boolean[][] occupied = new boolean[1005][1005];
        int comfort = 0;
        for (int b = 0; b < population; b++)
        {
            comfort  = comfort + getnetchange(occupied, cowinformation[b][0], cowinformation[b][1]);
            System.out.println(comfort);
        }
    }

    public static int getnetchange(boolean[][] occupied, int x, int y)
    {  
        int result = 0;
        occupied[x][y] = true;
        if (getsurround(occupied, x, y) == 3)
        {
            result++;
        }
        if (x - 1 > 0 && getsurround(occupied, x - 1, y) == 3)
        {
            result++;
        }
        if (getsurround(occupied, x + 1, y) == 3)
        {
            result++;
        }
        if (y - 1 > 0 && getsurround(occupied, x, y - 1) == 3)
        {
            result++;
        }
        if (getsurround(occupied, x, y + 1) == 3)
        {
            result++;
        }
        // if (getsurround(occupied, x, y) == 4)
        // {
        //     result--;
        // }
        if (x - 1 > 0 && getsurround(occupied, x - 1, y) == 4)
        {
            result--;
        }
        if (getsurround(occupied, x + 1, y) == 4)
        {
            result--;
        }
        if (y - 1 > 0 && getsurround(occupied, x, y - 1) == 4)
        {
            result--;
        }
        if (getsurround(occupied, x, y + 1) == 4)
        {
            result--;
        }
        return result;
    }

    public static int getsurround(boolean[][] occupied, int x, int y)
    {
        //System.out.println(x + "  " + y);
        int result = 0;
        if (x > 0 && y > 0 &&  occupied[x][y])
        {
            if (occupied[x - 1][y])
            {
                result++;
            }
            if (occupied[x + 1][y])
            {
                result++;
            }
            if (occupied[x][y - 1])
            {
                result++;
            }
            if (occupied[x][y + 1])
            {
                result++;
            }
        }
        
        return result;
    }
}