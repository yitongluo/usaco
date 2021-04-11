/*
ID: yitongl1
LANG: JAVA
TASK: transform
*/
import java.io.*;
import java.util.*;


class transform
{
    public static void main (String [] args) throws IOException
    {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("transform.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        int size = Integer.parseInt(f.readLine());    
        char [] [] mat = new char [size][size]; 
        char [] [] input = new char[size][size];
        mat = read(f, mat);
        input = read(f, input);
        //rotate(mat);
        out.println(findLeast(mat, input));
        out.close();                                  
        f.close();
    }
    public static char[][] read(BufferedReader x, char[][]mat) throws IOException
    {
        for (int i = 0; i < mat.length; i++)
        {
            String currentline = x.readLine();
            for (int j = 0; j < mat[i].length; j++) 
            {
                mat [i][j] = currentline.charAt(j);
                //System.out.print(mat[i][j]);
            }
            //System.out.println();
        }
        return mat;
    }
    public static int findLeast(char[][]mat, char[] []input)
    {
        int size = mat.length;
        char[][]temp = new char[size][size];
        for (int i = 1; i<=5; i++)
        {
            if(i < 4)
            {
                temp = rotate(mat, i);
            }
            if (i == 4)
            {
                temp = reflect(mat);
            }
            if ( i== 5)
            {
                for (int j = 1; j <= 3; j++)
                {
                    temp = rotate(reflect(mat), j);
                    if (equals(temp, input))
                    {
                        return i;
                    }
                }
            }
            if (equals(temp, input))
            {
                return i;
            }
        }
        if (equals(mat, input))
        {
                return 6;
        }
        return 7;
    }

    public static char[][] rotate(char[][]mat, int n)
    {
        char[] [] temp = mat;
        for (int i = 0; i < n; i++)
        {
            temp = rotate(temp);
        }
        return temp;
    }

    private static char[][] rotate(char[][] mat)
    {
        int size = mat.length;
        char [][]output = new char[size][size];
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                output [i][j] = mat[size - 1 - j][i];
                //System.out.print(output[i][j]);
            }
           // System.out.println();
        } 
        return output;
    }

    public static char[][] reflect(char[][] mat)
    {
        int size = mat.length;
        char[][] mirror = new char[size][size];
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                if(j == (size - 1) / 2 && size % 2 == 1)
                {
                    mirror[i][j] = mat[i][j];
                    continue;
                }
                mirror[i][j] = mat[i][size - 1 - j];    
            }
        }
  
        return mirror;
    }

    public static boolean equals(char[][]a, char [][] b)
    {
        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a.length; j++)
            {
                if (a[i][j] != b[i][j])
                {
                    return false;
                }
            }
        }
        return true;
    }
}
