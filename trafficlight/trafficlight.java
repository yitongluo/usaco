import java.io.BufferedReader;
import java.util.TreeMap;
import java.io.*;
import java.util.*;

public class trafficlight 
{
    static TreeMap<Long, Integer> map = new TreeMap<Long, Integer>();
    static TreeMap<Long, Integer> multiset = new TreeMap<Long, Integer>();
    public static void main(String[]args)throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        long road = Long.parseLong(st.nextToken());
        int lights = Integer.parseInt(st.nextToken());
        long first = 1;
        map.put(first, 1);
        map.put(road, 1);
        add(road - 1);
        StringTokenizer st2 = new StringTokenizer(in.readLine());
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int a = 0; a < lights; a++)
        {
            Long current = Long.parseLong(st2.nextToken());
            if (current == 1 || current == road)
            {
                log.write(multiset.lastKey() + " ");
                continue;
            }
            map.put(current, 1);
            long right = map.higherKey(current);
            long left = map.lowerKey(current);
            remove(right - left);
            add(current - left);
            add(right - current);
            log.write(multiset.lastKey() + "\n");
        }
        in.close();
        log.flush();
    }
    public static void add (Long x)
    {
        if(multiset.containsKey(x)){
            multiset.put(x, multiset.get(x) + 1);
        } else {
            multiset.put(x, 1);
        }
    }
    public static void remove (Long x)
    {
        multiset.put(x, multiset.get(x) - 1);
	    if(multiset.get(x) == 0){
		multiset.remove(x);
        }
    }
}
