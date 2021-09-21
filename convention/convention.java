/*
ID: yitongl1
LANG: JAVA
TASK: convention
*/
import java.io.*;
import java.util.*;

class convention
{
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("convention.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("convention.out")));
        StringTokenizer s = new StringTokenizer(f.readLine());
        int cow = Integer.parseInt(s.nextToken());
        int cars = Integer.parseInt(s.nextToken());
        int eachcap =  Integer.parseInt(s.nextToken());
        int[] arrivetime = new int[cow];
        StringTokenizer st = new StringTokenizer(f.readLine());
        int max = Integer.MIN_VALUE;
        for (int a = 0; a < cow; a++)
        {
            int current =  Integer.parseInt(st.nextToken());
            arrivetime[a] = current;
            max = Integer.max(current, max);
        }
        Arrays.sort(arrivetime);
        //out.println(isok(99738, cars, eachcap, arrivetime));
        out.println(getresult(arrivetime, 0, max, cow, cars, eachcap));
        f.close();
        out.close();
    }
    public static int getresult(int[] arrivetime, int low, int high, int cownum, int cars, int eachcap)
    {
        int mid = low + (high - low)/2;  
        boolean current = isok(mid, cars, eachcap, arrivetime);
        boolean left = isok(mid - 1, cars, eachcap, arrivetime);
        if (current == true && left == false)
        {
            return mid;
        }
        if (current == true && left == true)
        {
            return getresult(arrivetime, low, mid - 1, cownum, cars, eachcap);
        }
        if (current == false && left == false)
        {
            return getresult(arrivetime, mid + 1, high, cownum, cars, eachcap);
        }
        return -1;
    }
    public static boolean isok(int wait, int cars, int eachcap, int[] arrivetime)
    {
        int usedcar = 0;
        int currentcar = eachcap;
        int currenttime = arrivetime[0];
        for (int i = 0; i < arrivetime.length; i++)
        {
            if (usedcar > cars)
            {
                return false;
            }
            if (arrivetime[i] - currenttime <= wait && currentcar < eachcap)
            {
                currentcar++;
                continue;
            }
            if (currentcar == eachcap)
            {
                usedcar++;
                currentcar = 1;
                currenttime = arrivetime[i];
                continue;
            }
            if (arrivetime[i] - currenttime > wait)
            {
                usedcar++;
                currentcar = 1;
                currenttime = arrivetime[i];
            }
        }
        return usedcar <= cars;
    }

}