/*
ID: yitongl1
LANG: JAVA
TASK: mountains
*/
import java.io.*;
import java.util.*;

class mountains
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("mountains.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mountains.out")));
        int length = Integer.parseInt(f.readLine());
        ArrayList<interval> view= new ArrayList<interval>();
        for (int i = 0; i < length; i++)
        {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            interval x = new interval(a - b, a + b);
            view.add(x);
        }
        Collections.sort(view, new IntervalCompare());
        for (interval it: view)
        {
            System.out.println(it.tostring());
        }
        out.println(length - count(view));
        f.close();
        out.close();
    }

    public static int count(ArrayList<interval> view)
    {
        interval current = view.get(0);
        int min = current.getstart();
        int max = current.getend();
        int result = 0;
        for (int i = 1; i < view.size(); i++)
        {
            current = view.get(i);
            int tstr = current.getstart();
            int tend = current.getend();
            if (tstr >= min && tend <= max)
            {
                //System.out.println(current.tostring());
                result++;
            }
            if (tend > max)
            {
                min = tstr;
                max = tend;
            }
        }
        return result;
    }
}

class IntervalCompare implements Comparator<interval> 
{
    public int compare(interval o1, interval o2) {
        if (o1.getstart() < o2.getstart())
        {
            return -1;
        }
        if (o1.getstart() == o2.getstart())
        {
            if (o1.getend() > o2.getend())
            {
                return -1;
            }
            else
            {
                return 1;
            }
        }
        else
        {
            return 1;
        }

    }
}

class interval
{
    private int start;
    private int end;

    public interval (int a, int b)
    {
        start = a;
        end = b;
    }
    public int getstart()
    {
        return start;
    }
    public int getend()
    {
        return end;
    }
    public String tostring()
    {
        return start + " " + end;
    }

}