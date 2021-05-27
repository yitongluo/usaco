/*
ID: yitongl1
LANG: JAVA
TASK: milk3
*/
import java.io.*;
import java.util.*;

class milk3
{
    public static void main (String [] args) throws IOException
    {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("milk3.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
                  // Get line, break into tokens
        int a_cap = Integer.parseInt(st.nextToken());    
        int b_cap = Integer.parseInt(st.nextToken());  
        int c_cap = Integer.parseInt(st.nextToken());
        boolean[][][] used = new boolean[a_cap + 1][b_cap + 1][c_cap + 1];
        boolean[] result = new boolean[c_cap + 1];
        for (int i = 0; i < used.length; i++)
        {
            for (int j = 0; j < used[0].length; j++)
            {
                for (int k = 0; k < used[0][0].length; k++)
                {
                    used[i][j][k] = false;
                }
            }
        }
        //System.out.println(Arrays.toString(getmoveresult(1, 9, 9)));
        for (int i = 0; i < result.length; i++)
        {
            result[i] = false;
        }
        getresult(0, 0, c_cap, used, result);

        for (int i = 0; i < result.length - 1; i++)
        {
            if (result[i])
            {
                out.print(i + " ");
            }
        }
        out.print(c_cap);
        out.println();
        f.close();
        out.close();
    }

    public static void getresult(int a, int b, int c, boolean[][][]used, boolean[]result)
    {
        System.out.println("*******************");
        System.out.println(a +" " + b + " " +c);
        if (a == 0)
        {
           result[c] = true; 
        }
        int[] store = {a, b, c};
        int[] capa = {used.length - 1, used[0].length - 1, used[0][0].length - 1};
        int[] temp = new int[3];
        for (int i = 0; i < store.length; i++)
        {
            for (int j = 0; j < store.length; j++)
            {
                if (i != j && canmove(store[i], store[j], capa[j]))
                {
                    temp[i] = getfirst(store[i], store[j], capa[j]);
                    temp[j] = getsecond(store[i], store[j], capa[j]);
                    temp[3 - i - j] = store [3 - i -j];
                    if (used[temp[0]][temp[1]][temp[2]] == false)
                    {
                        used[temp[0]][temp[1]][temp[2]] = true;
                        getresult(temp[0], temp[1], temp[2], used, result);
                    }
                }
            }
        }
    }
    
    public static boolean canmove(int from, int to, int tocapacity)
    {
        return from != 0 && to < tocapacity;
    }
    
    public static int getfirst (int a, int b, int bcap)
    {
        if (a + b - bcap < 0)
        {
            return 0;
        }
        return a + b -bcap;
    }

    public static int getsecond  (int a, int b, int bcap)
    {
        if (b + a > bcap)
        {
            return bcap;
        }
        return b + a;
    }
}