/*
ID: yitongl1
LANG: JAVA
TASK: triangles
*/
import java.io.*;
import java.util.*;

class triangles
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("triangles.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));
        int n = Integer.parseInt(f.readLine());
        int[][] points = new int[n][2];
        for (int a = 0; a < n; a++)
        {
            StringTokenizer st = new StringTokenizer(f.readLine());
            points[a][0] = Integer.parseInt(st.nextToken());
            points[a][1] = Integer.parseInt(st.nextToken());
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                for (int k = 0; k < n; k++)
                {
                    if (i != j && j != k && i != k)
                    {
                        int current = getarea(points[i], points[j], points[k]);
                        if (current < 0)
                        {
                            current = current * -1;
                        }
                        max= Integer.max(max, current);
                    }
                }
            }
        }
        out.println(max);
        f.close();
        out.close();
    }

    public static int getarea (int[] point1, int[] point2, int[] point3)
    {

        if ((point1[0] == point2[0] && point1[1] == point3[1]))
        {
            return (point1[1] - point2[1]) * (point1[0] - point3[0]);
        }
        if ((point1[1] == point2[1] && point1[0] == point3[0]))
        {
            return (point1[0] - point2[0]) * (point1[1] - point3[1]);
        }
        if ((point1[0] == point2[0] && point2[1] == point3[1]))
        {
            return (point2[1] - point1[1]) * (point2[0] - point3[0]);
        }
        if ((point1[1] == point2[1] && point2[0] == point3[0]))
        {
            return (point2[0] - point1[0]) * (point2[1] - point3[1]);
        }
        if ((point1[0] == point3[0] && point2[1] == point3[1]))
        {
            return (point3[1] - point1[1]) * (point3[0] - point2[0]);
        }
        if ((point1[1] == point3[1] && point2[0] == point3[0]))
        {
            return (point3[0] - point1[0]) * (point3[1] - point2[1]);
        }
        return -1;
    } 
}