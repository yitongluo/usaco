import java.util.*;
import java.io.*;
class OddPhoto
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(in.readLine());
        int even = 0;
        int odd = 0;
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 1; i <= length; i++)
        {
            int current = Integer.parseInt(st.nextToken());
            if (current % 2 == 0)
            {
                even++;
            }
            else
            {
                odd++;
            }
        }
        System.out.println(getresult(even, odd));
    }
    public static int getresult(int even, int odd)
    {
        if (even == odd)
        {
            return 2 * even;
        }
        if (even > odd)
        {
            return 2 * odd + 1;
        }
        if (even < odd)
        {
            int a = (odd - even) % 3;
            if (a == 0)
            {
                return 2 * even + (odd - even)/3 * 2;
            }
            if (a == 2)
            {
                return 2 * even + (odd - even)/3 * 2 + 1;
            }
            else
            {
                return 2 * even + (odd - even)/3 * 2 - 1;
            }
        }
        return 0;
    }
}