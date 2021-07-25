import java.io.*;
import java.util.*;

class prob1
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("prob1.out")));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int population = Integer.parseInt(st.nextToken());
        int[][] cowinformation = new int[population][2];
        for (int a = 0; a < cowinformation.length; a++)
        {
            StringTokenizer x = new StringTokenizer(in.readLine());
            cowinformation[a][0] = Integer.parseInt(x.nextToken()) + 500;
            cowinformation[a][1] = Integer.parseInt(x.nextToken()) + 500;
        }
        boolean[][] orifield = new boolean[2000][2000];
        int temp = 0;
        for (int b = 0; b < population; b++)
        {
            if (orifield[cowinformation[b][0]][cowinformation[b][1]])
            {
                //out.println(temp);
                temp--;
            }
            else
            {
                //out.println(temp);
                temp += getnetadd(cowinformation[b][0], cowinformation[b][1], orifield);
            }
            System.out.println(temp);
        }
        out.close();
        // orifield[1000][1001] = true;
        // orifield[1001][1000] = true;
        // orifield[1001][1001] = true;
        // orifield[1001][1002] = true;
        //System.out.println(Arrays.toString(changeaddfield(1001, 1001, orifield)));
    }
    public static int getnetadd(int x, int y, boolean[][] orifield)
    {
        int result = 0;
        orifield[x][y] = true;
        int[] current;
        
        if (getsurround(x, y, orifield) == 3)
        {
            current = changeaddfield(x, y, orifield);
            orifield[current[0]][current[1]] = true;
            result++;
            result+=getnetadd(current[0], current[1], orifield);
        }
        if (orifield[x + 1][y] && getsurround(x + 1, y, orifield) == 3)
        {
            current = changeaddfield(x + 1, y, orifield);
            //System.out.println(current[0] + " " + current[1]);
            orifield[current[0]][current[1]] = true;
            result++;
            result+=getnetadd(current[0], current[1], orifield);
        }
        if (orifield[x - 1][y] && getsurround(x - 1, y, orifield) == 3)
        {
            current = changeaddfield(x - 1, y, orifield);
            orifield[current[0]][current[1]] = true;
            result++;
            result+=getnetadd(current[0], current[1], orifield);
        }
        if (orifield[x][y - 1] && getsurround(x, y - 1, orifield) == 3)
        {
            current = changeaddfield(x, y - 1, orifield);
            orifield[current[0]][current[1]] = true;
            result++;
            result+=getnetadd(current[0], current[1], orifield);
        }
        if (orifield[x][y + 1] && getsurround(x, y + 1, orifield) == 3)
        {
            current = changeaddfield(x, y + 1, orifield);
            orifield[current[0]][current[1]] = true;
            result++;
            result+=getnetadd(current[0], current[1], orifield);
        }
        return result;
    }
    public static int getsurround(int x, int y, boolean[][] orifield)
    {
        int result = 0;
        if (orifield[x - 1][y])
        {
            result++;
        }
        if (orifield[x + 1][y])
        {
            result++;
        }
        if (orifield[x][y - 1])
        {
            result++;
        }
        if (orifield[x][y + 1])
        {
            result++;
        }
        return result;
    }
    public static int[] changeaddfield(int x, int y, boolean[][] orifield)
    {
        int[] result = new int[2];
        if (!orifield[x - 1][y] )
        {
            orifield[x - 1][y] = true;
            result[0] = x -1;
            result[1] = y;
            return result;
        }
        if (!orifield[x + 1][y])
        {
            orifield[x + 1][y] = true;
            result[0] = x  + 1;
            result[1] = y;
            return result;
        }
        if (!orifield[x][y - 1])
        {
            orifield[x][y - 1] = true;
            result[0] = x;
            result[1] = y - 1;
            return result;
        }
        if (!orifield[x][y + 1])
        {
            orifield[x][y + 1] = true;
            result[0] = x;
            result[1] = y + 1;
            return result;
        }
        result[0] = -1;
        result[1] = -1;
        return result;

    }
}