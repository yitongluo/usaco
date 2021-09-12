import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class orderset
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] values = new int[n];
        int target = scan.nextInt();
        for (int i = 0; i < n; i++)
        {
            values[i] = scan.nextInt();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < n; j++)
        {
            if (map.containsKey(target - values[j]))
            {
                System.out.println((j + 1) + " " + map.get(target - values[j]));
                scan.close();
                System.exit(0);
            }
            map.put(values[j], j + 1);
        }
        System.out.println("IMPOSSIBLE");
        scan.close();
    }
    
}