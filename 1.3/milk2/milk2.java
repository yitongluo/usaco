/*
ID: yitongl1
LANG: JAVA
TASK: milk2
*/
import java.io.*;
import java.util.*;

class milk2
{
    public static void main (String [] args) throws IOException
    {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
        
        Interval[] list = new Interval [Integer.parseInt(f.readLine())];
        int range = 0;
        for (int i = 0; i < list.length; i++)
        {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int i1 = Integer.parseInt(st.nextToken());    
            int i2 = Integer.parseInt(st.nextToken()); 
            if (i2 > range)
            {
                range = i2;
            }
            list[i] = new Interval(i1, i2);
        }
        Arrays.sort(list);
        //System.out.println(Arrays.toString(list));
        out.println(calculateMilktime(list) + " " + calculateSpare(list));
        //test();                      
        out.close();                                  
        f.close();
    }

    public static int calculateSpare(Interval[] list)
    {
        int longest = 0;
        int maxEnd = list[0].End();
         //how many interval is i in
        for (int i = 1; i < list.length; i++)
        {
            if (list[i].Start() > maxEnd)
            {
                longest = Math.max(longest, list[i].Start() - maxEnd);
            }

            maxEnd = Math.max(maxEnd, list[i].End());
        }
        return longest;
    }

    public static int calculateMilktime(Interval[] list)
    {
        Interval temp = list[0];
        int longest = temp.length();
        for (int i = 1; i < list.length; i++)
        {
            //System.out.println(temp);
            if (list[i].Start() <= temp.End())
            {
                temp = temp.addInterval(list[i]);
            }
            else
            {
                temp = list[i];
            }
            longest = Math.max(longest, temp.length());
        }
        return longest;
    }
}

class Interval implements Comparable<Interval>
{
    private int start;
    private int end;

    public Interval(int Start, int end)
    {
        this.start = Start;
        this.end = end;
    }

    public int Start()
    {
        return this.start;
    }

    public int End()
    {
        return this.end;
    }

    @Override
    public String toString()
    {
        return "(" + this.start + "," + this.end + ")";
    }

    public void printout()
    {
        System.out.println(toString());
    }

    public int length()
    {
        return this.end - this.start;
    }

    public Interval addInterval(Interval o)
    {
        int start = Math.min(this.start, o.start);
        int end = Math.max(this.end, o.end);
        return new Interval(start, end);
    }

    @Override
    public int compareTo(Interval o) 
    {
        int result = Integer.compare(this.start, o.start);
        return result != 0 ? result : Integer.compare(this.end, o.end);
    }
}
