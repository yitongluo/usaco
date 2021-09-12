import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.util.Map;

public class maximumsub 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        StringTokenizer st2 = new StringTokenizer(in.readLine());
        TreeMap<Long, Integer> map = new TreeMap<Long, Integer>();
        long[] prefix = new long[n + 1];
        long result = Integer.MIN_VALUE;
        for (int a = 1; a < n + 1; a++)
        {
            prefix[a] = prefix[a - 1] + Long.parseLong(st2.nextToken());
            //System.out.println(prefix[a - 1]);
            map.put(prefix[a - 1], 1);
            Long temp = prefix[a] - map.firstKey();
            if (temp > result)
            {
                result = temp;
            }
        }
        System.out.println(result);
        in.close();
    }
}
