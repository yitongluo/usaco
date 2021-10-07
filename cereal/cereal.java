/*
ID: yitongl1
LANG: JAVA
TASK: cereal
*/
import java.io.*;
import java.util.*;

class cereal
{
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("cereal.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cereal.out")));
        StringTokenizer st1 = new StringTokenizer(f.readLine());
        int cows = Integer.parseInt(st1.nextToken());
        int cereals = Integer.parseInt(st1.nextToken());
        int[][] cow_prefer = new int[cows + 1][2];
        int[] eachcereal = new int[cereals + 1];
        for (int a = 1; a <= cows; a++)
        {
            StringTokenizer st2 = new StringTokenizer(f.readLine());
            cow_prefer[a][0] = Integer.parseInt(st2.nextToken());
            cow_prefer[a][1] = Integer.parseInt(st2.nextToken());
        }
        int result = 0;
        int[] answer = new int[cows];
        int count = cows - 1;
        for (int i = cows; i >= 1; i--)
        {
            int take = cow_prefer[i][0];
            int victim = eachcereal[take];
            result++;
            eachcereal[take] = i;
            while (true)
            {
                if (victim == 0)
                {
                    break;
                }
                if (eachcereal[cow_prefer[victim][0]] == victim)
                {
                    break;
                }
                if (eachcereal[cow_prefer[victim][1]] > victim || eachcereal[cow_prefer[victim][1]] == 0)
                {
                    int temp = victim;
                    take = cow_prefer[victim][1];
                    victim = eachcereal[take];
                    eachcereal[take] = temp;
                }
                else
                {
                    result--;
                    break;
                }
            }
            answer[count] = result;
            count--;
        }
        for (int x : answer)
        {
            out.println(x);
        }
        out.close();
        f.close();
    }
}