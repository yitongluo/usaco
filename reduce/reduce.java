/*
ID: yitongl1
LANG: JAVA
TASK: reduce
*/
import java.io.*;
import java.util.*;
class reduce
{
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("reduce.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("reduce.out")));
        int length = Integer.parseInt(f.readLine());
        ArrayList<point> mapbyx= new ArrayList<point>();
        ArrayList<point> mapbyy= new ArrayList<point>();
        for (int i = 0; i < length; i++)
        {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            point x = new point(a, b);
            mapbyx.add(x);
            mapbyy.add(x);
        }
        Collections.sort(mapbyx, new IntervalComparex());
        Collections.sort(mapbyy, new IntervalComparey());
        Integer min = Integer.MAX_VALUE;
        getresult(mapbyx, mapbyy, 0, min, 0, 0, 0, 0);
        System.out.println(min);
        f.close();
        out.close();
    }
    public static void getresult(ArrayList<point> mapbyx, ArrayList<point> mapbyy, int count, Integer min,
    int a, int b, int c, int d)
    {
        int length = mapbyx.size();
        if (count < 3)
        {
            getresult(mapbyx, mapbyy, count + 1, min, a + 1, b, c, d);
            getresult(mapbyx, mapbyy, count + 1, min, a, b + 1, c, d);
            getresult(mapbyx, mapbyy, count + 1, min, a, b + 1, c + 1, d);
            getresult(mapbyx, mapbyy, count + 1, min, a, b, c, d + 1);
        } 
        else
        {
            point rightmost = mapbyx.get(a + 1);
            point leftmost = mapbyx.get(length - 1 - b - 1);
            point downmost = mapbyy.get(c + 1);
            point upmost = mapbyy.get(length - 1 - d - 1);
            min = Integer.min(getarea(rightmost, leftmost, downmost, upmost), min);
            System.out.println(getarea(rightmost, leftmost, downmost, upmost));
        }
    }
    public static int getarea(point rightmost, point leftmost, point downmost, point upmost)
    {
        return (rightmost.getx() - leftmost.getx()) * (upmost.gety() - downmost.gety());
    }
    public static ArrayList<point> copy(ArrayList<point> input)
    {
        ArrayList<point>result = new ArrayList<point>();
        for (point x : input)
        {
            result.add(x);
        }
        return result;
    }
}










class IntervalComparex implements Comparator<point> 
{
    public int compare(point o1, point o2) {
        if (o1.getx() < o2.getx())
        {
            return -1;
        }
        else
        {
            return 1;
        }
    }
}
class IntervalComparey implements Comparator<point> 
{
    public int compare(point o1, point o2) {
        if (o1.gety() < o2.gety())
        {
            return -1;
        }
        else
        {
            return 1;
        }
    }
}

class point
{
    private int x;
    private int y;

    public point (int a, int b)
    {
        x = a;
        y = b;
    }
    public int getx()
    {
        return x;
    }
    public int gety()
    {
        return y;
    }
    public String tostring()
    {
        return x + " " + y;
    }

    public boolean equal(point a, point b)
    {
        return a.getx() == b.getx() && a.gety() == b.gety();
    }
}