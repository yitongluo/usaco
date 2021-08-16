/*
ID: yitongl1
LANG: JAVA
TASK: diamond
*/
import java.io.*;
import java.util.*;

class diamond
{
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("diamond.in"));                                              // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int l = Integer.parseInt(st.nextToken());
        int differ = Integer.parseInt(st.nextToken());
        int[] diamonds = new int[l];
        for (int i = 0; i < l; i++)
        {
            diamonds[i] = Integer.parseInt(f.readLine());
        }
        Arrays.sort(diamonds);
        int same = 0;
        int last = -1;
        ArrayList<Integer> store = new ArrayList<>();
        boolean isok = true;
        for (int j = 0; j < l; j++)
        {
            if (diamonds[j] != last)
            {
                last = diamonds[j];
                store.add(diamonds[j]);
                isok = true;
            }
            else if (diamonds[j] == last && isok)
            {
                same++;
                isok = false;
            }
        }
        
        out.println(count(store, differ) + same);
        f.close();
        out.close();
    }

    public static int count(ArrayList<Integer> diamonds, int differ)
    {
        int left = 0;
        int right = 0;
        int n = diamonds.size() ;
        int result = 0;
        while (left < n && right < n)
        {
            while (right < n)
            {
                if (right == n - 1)
                {
                    break;
                }
                if ((diamonds.get(right + 1) - diamonds.get(left)) <= differ)
                {
                    right++;
                } 
                else
                {
                    break;
                }
            }
            int temp = right - left;
            result += temp;
            if (temp != 0)
            {
                System.out.println(left + "  " + right);
            }
            if (left == right)
            {
                left = left + 1;
                right = left;
            }
            else
            {
                left = right;
            }
        }
        return result;
    }
}