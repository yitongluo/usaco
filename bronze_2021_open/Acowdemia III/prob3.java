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
            String line = a.nextToken();
            for (int j = 1; j < col + 1; j++)
            {
                char current = line.charAt(j - 1);
                if (current == 'C') 
                {
                    grassland[i][j] = -1;
                    construct(grassland, i, j);
                }   
                if (current == '.')    
                {
                    grassland[i][j] = -2;
                }     
                if (current == 'G')
                {
                    xcoorgrass[grasscount] = i;
                    ycoorgrass[grasscount] = j;
                    grasscount++;
                }
                //cow is -1, . is -2, grass is the number with cow adjacent
            }
        }
        // for (int a = 0; a < row + 1; a++)
        // {
        //     System.out.println(Arrays.toString(grassland[a]));
        // }
        //System.out.println(Arrays.toString(xcoorgrass));
        //System.out.println(Arrays.toString(ycoorgrass));
        System.out.println(count(grassland, xcoorgrass, ycoorgrass, grasscount));
    }

    public static int count(int[][] mat, int[]a, int[] b, int count)
    {
        int result = 0;
        int conflict = 0;
        for (int i = 1; i <= count; i++)
        {
            if (mat[a[i]][b[i]] >= 3)
            {
                result++;
            }
            if (mat[a[i]][b[i]] == 2)
            {
                if (isConflict(mat, a[i], b[i]))
                {
                    conflict++;
                }
                else
                {
                    result++;
                }
            }
        }
        return result + conflict/2;
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
    
    public static boolean isConflict(int[][] mat, int x, int y)
    {

        //int up = mat[x - 1][y];
        //int down = mat[x + 1][y];
        //int left = mat[x][y - 1];
        //int right = mat[x][y + 1];
        if (x - 1 >= 1 && y - 1 >= 1 && mat[x - 1][y - 1] == 2 && mat[x - 1][y] == -1 && mat[x][y - 1] == -1)
        {
            return true;
        }
        if (x - 1 >= 1 && y + 1 < mat[0].length && mat[x - 1][y + 1] == 2 &&  mat[x - 1][y] == -1 
        && mat[x][y + 1] == -1)
        {
            return true;
        }
        if (x + 1 < mat.length && y - 1 >= 1 && mat[x + 1][y - 1] == 2 && mat[x + 1][y] == -1 
        &&  mat[x][y - 1] == -1)
        {
            return true;
        }
        if (x + 1 < mat.length && y + 1 < mat[0].length && mat[x + 1][y + 1] == 2 && mat[x + 1][y] == -1 
        && mat[x][y + 1] == -1)
        {
            return true;
        }
        return false;
    }
}