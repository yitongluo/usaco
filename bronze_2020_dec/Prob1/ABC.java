import java.io.*;
import java.util.*;

class ABC
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int [] list = new int[7];
        for(int i = 0; i < 7; i++)
        {
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        System.out.println(list[0] + " " + list[1] + " " + (list[6] - list[0] - list[1]));
    }
}