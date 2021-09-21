/*
ID: yitongl1
LANG: JAVA
TASK: angry
*/
import java.io.*;
import java.util.*;
class angry
{
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("cownomics.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
        StringTokenizer s = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(s.nextToken());
        int m = Integer.parseInt(s.nextToken());
        String[] spot = new String[n];
        String[] plain = new String[n];
        for (int a = 0; a < n; a++)
        {
            spot[a] = f.readLine();
        }
        for (int b = 0; b < n; b++)
        {
            plain[b] = f.readLine();
        }
        int result = 0;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < m; j++)
            {
                for (int k = 0; k < m; k++)
                {
                    boolean[][][]data = new boolean[4][4][4];
                    if (!(i == j || i == k || k == j))
                    {
                        for (int l = 0; l < n; l++)
                        {
                            String spotg = spot[l];
                            data[convert(spotg.charAt(i))][convert(spotg.charAt(j))][convert(spotg.charAt(k))] = true;
                        }
                        for (int o = 0; o < n; o++)
                        {
                            String plaing = spot[o];
                            int one = convert(plaing.charAt(i));
                            int second = convert(plaing.charAt(j));
                            int third = convert(plaing.charAt(k));
                            if (data[one][second][third] || data[one][third][second] || data[second][one][third]
                            || data[second][third][one] || data[third][one][second] || data[third][second][one])
                            {
                                result++;
                                break;
                            }
                        }
                    }
                    else
                    {
                        result++;
                    }
                }
            }
        }
        out.println(m * m * m - result);
        out.close();
        f.close();
    }
    public static int convert(char in)
    {
        if (in == 'A')
        {
            return 0;
        }
        if (in == 'C')
        {
            return 1;
        }
        if (in == 'G')
        {
            return 2;
        }
        if (in == 'T')
        {
            return 3;
        }
        return -1;
    }
}