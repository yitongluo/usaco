/*
ID: yitongl1
LANG: JAVA
TASK: herding
*/
import java.io.*;
import java.util.*;

class herding
{
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("herding.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
                  // Get line, break into tokens
        int i1 = Integer.parseInt(st.nextToken());    // first integer
        int i2 = Integer.parseInt(st.nextToken());
        int i3 = Integer.parseInt(st.nextToken());
        int[] list = {i1, i2, i3};
        for (int i = 0; i < 3; i++)
        {
            for (int j = i + 1; j < 3; j++)
            {
                if (list[i] > list[j])
                {
                    int temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
        }
        out.println(getMini(list));
        out.println(getMax(list));                        
        out.close();                               
        f.close();
    }

    public static int getMini(int[] list)
    {
        if (list[1] + 1 == list[2] && list[2] - 1 == list[1])
        {
            return 0;
        }
        if (list[1] + 1 == list[2] - 1)
        {
            return 1;
        }
        else
        {
            return 2;
        }
    }

    public static int getMax(int[] list)
    {
        if (list[1] - list[0] >= list[2] - list[1])
        {
            return list[1] - list[0] - 1;
        }
        else
        {
            return list[2] - list[1] - 1;
        }
    }

}