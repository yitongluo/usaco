import java.io.*;
import java.util.*;

class prob3
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int[][] grassland = new int[row + 1][col + 1];
        int[] xcoorgrass = new int [row * col];
        int[] ycoorgrass = new int [row * col];
        int grasscount = 1;
        for (int i = 1; i < row + 1; i++)
        {
            StringTokenizer a = new StringTokenizer(in.readLine());
            for (int j = 1; j < col + 1; j++)
            {
                String current = a.nextToken();
                if (current.equals("C")) 
                {
                    grassland[i][j] = -1;
                    construct(grassland, i, j);
                }   
                if (current.equals("."))    
                {
                    grassland[i][j] = -2;
                }     
                else
                {
                    xcoorgrass[grasscount] = i;
                    ycoorgrass[grasscount] = j;
                    grasscount++;
                }
                //cow is -1, . is -2, grass is the number with cow adjacent
            }
        }
        for (int a = 1; a < row + 1; a++)
        {
            System.out.println(Arrays.toString(grassland[a]));
        }
    }

    public static int[][] construct(int[][] input, int x, int y)
    {
        if (x - 1 >= 1 && input[x - 1][y] >= 0)
        {
            input[x - 1][y]++;
        }
        if (y - 1 >= 1 && input[x][y - 1] >= 0)
        {
            input[x][y - 1]++;
        }
        if (x + 1 < input.length && input[x + 1][y] >= 0)
        {
            input[x + 1][y]++;
        }
        if (y + 1 < input[0].length && input[x][y+1] >= 0)
        {
            input[x][y + 1]++;
        }
        return input;
    }
}