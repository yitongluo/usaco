/*
ID: yitongl1
LANG: JAVA
TASK: cowcode
*/
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
class cowcode
{
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("cowcode.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowcode.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        String original = st.nextToken();
        int length = original.length();
        long n = Long.parseLong(st.nextToken());
        ArrayList<Long> re = getbinary(length, n);
        for (long x : re)
        {
            System.out.println(x);
        }
        long current = n;
        int count = re.size() - 1;
        if (current == 2 * re.get(count) + 1)
        {
            current--;
        }
        while (current > length)
        {
            if (current < re.get(count))
            {
                count--;
            }
            else
            {
                current = current - re.get(count) - 1;
                count--;
            }
        }
        Long result = current;
        Integer result2 = result.intValue();
        out.println(original.substring(result2 - 1, result2));
        out.close();
        f.close();
    }
    public static ArrayList<Long> getbinary(int length, long n)
    {
        ArrayList<Long> result = new ArrayList<Long>();
        long current = length;
        while (true)
        {
            if (current < n)
            {
                result.add(current);
                current = current * 2;
            }
            else
            {
                break;
            }
        }
        return result;
    }
}