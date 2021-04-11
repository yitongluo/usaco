/*
ID: yitongl1
LANG: JAVA
TASK: revegetate
*/
import java.io.*;
import java.util.*;

class revegetate
{
    public static void main (String [] args) throws IOException
    {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("revegetate.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
                  // Get line, break into tokens
        int x = Integer.parseInt(st.nextToken()) + 1;  //grass number 
        int y = Integer.parseInt(st.nextToken());  //cow number 
        int [][] grasspair= new int[x][3];
        boolean[][] choice = new boolean[x][4];
        for (int i = 0; i < x; i++)
        {
            for (int k = 0; k < 4; k++)
            {
                choice[i][k] = true;
            }
            for (int a = 0; a < 3; a++)
            {
                grasspair[i][a] = -1;
            }
        }   

        for (int a = 0; a < y; a++)
        {
            StringTokenizer r = new StringTokenizer(f.readLine());
            int i1 = Integer.parseInt(r.nextToken());   
            int i2 = Integer.parseInt(r.nextToken());
            for (int b = 0; b < 3; b++)
            {
                if (grasspair[i1][b] == -1)
                {
                    grasspair[i1][b] = i2;
                    break;
                }
            }

            for (int c = 0; c < 3; c++)
            {
                if (grasspair[i2][c] == -1)
                {
                    grasspair[i2][c] = i1;
                    break;
                }
            }
        }
        for (int d = 1; d < x; d++)
        {
            out.print(getAnswer(d, choice, grasspair));
        }
        out.close();                                  
        f.close();
    }
    public static int getAnswer(int index, boolean[][] choice, int[][]grasspair)
    {
        int result = 0;
        for (int i = 0; i < 4; i++)
        {
            if (choice[index][i] == true)
            {
                result = i + 1;
                for (int k = 0; k < grasspair[index].length; k++)
                {
                    int jump = grasspair[index][k];
                    if (jump != -1)
                    {
                        choice[jump][i] = false;
                    }
                }
                break;
            }
        }
        return result;
    }
}