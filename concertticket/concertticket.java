import java.io.BufferedReader;
import java.util.TreeMap;
import java.io.*;
import java.util.*;

public class concertticket {
    static TreeMap<Integer, Integer> multiset = new TreeMap<Integer, Integer>();
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int ticketnum = Integer.parseInt(st.nextToken());
        int people = Integer.parseInt(st.nextToken());
        StringTokenizer st1 = new StringTokenizer(in.readLine());
        for (int a = 0; a < ticketnum; a++)
        {
            add(Integer.parseInt(st1.nextToken()));
        }
        StringTokenizer st2 = new StringTokenizer(in.readLine());
        BufferedWriter log = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int b = 0; b < people; b++)
        {
            int current = Integer.parseInt(st2.nextToken());
            if (multiset.size() ==0 || multiset.firstKey() > current)
            {
                log.write(-1 + "\n");
            }
            else
            {
                int temp = multiset.floorKey(current);
                log.write(temp + "\n");
                remove(temp);
            }
        }
        log.flush();
        in.close();
    }

    public static void add (int x)
    {
        if(multiset.containsKey(x)){
            multiset.put(x, multiset.get(x) + 1);
        } else {
            multiset.put(x, 1);
        }
    }
    public static void remove (int x)
    {
        multiset.put(x, multiset.get(x) - 1);
	    if(multiset.get(x) == 0){
		multiset.remove(x);
        }
    }
}
