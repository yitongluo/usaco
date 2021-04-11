/*
ID: yitongl1
LANG: JAVA
TASK: skidesign
*/
import java.io.*;
class skidesign
{
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("skidesign.in"));
                                                  
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
        int x = Integer.parseInt(f.readLine());    
        int[] cost = new int[x];
        int[]height  = new int[x];
        int answer = 0;
        for (int i = 0; i < x; i++)
        {
            cost[i] = 0;
            height[i] = Integer.parseInt(f.readLine());   
        }
        quickSort(height, 0, x - 1);
        compute(height, cost);
        for (int i = 0; i < cost.length; i++)
        {
            answer = answer + cost[i] * cost[i];
        }  
        System.out.println(answer);  
        f.close();  
        out.close();                                 
    }
    public static void compute(int[] height, int[] cost)
    {
        int firstIndex = 0;
        int lastIndex = height.length - 1;
        int lowcount = getcount(height, firstIndex, 1);
        int topcount = getcount(height, lastIndex, -1);
        
        while (true)
        {
            if (height[lastIndex] - height[0] == 17)
            {
                break;
            }
            if (getmargin(firstIndex, lowcount, cost) <= getmargin(lastIndex + topcount , -topcount, cost))
            {
                increment(firstIndex, lowcount, height, cost, 1);
                lowcount = lowcount + getcount(height, firstIndex, 1);
                continue;
            }

            if (getmargin(firstIndex, lowcount, cost) > getmargin(lastIndex + topcount, -topcount, cost))
            {
                increment(lastIndex + topcount, topcount, height, cost, -1);
                topcount = topcount + getcount(height, lastIndex + topcount, -1);
            }
        }
    }

    public static int getcount(int[] height, int index, int direction)
    {
        int temp = 0;
        for (int i = 1;;i++)
        {
            if (height[index + direction * i]!= height[index])
            {
                break;
            }
            temp = temp + direction;
        }
        return temp;
    }
    public static void increment(int index, int n, int[] list, int[] cost, int direction)
    { 
        for (int i = index; i <= index + n; i++)
        {
            list[i] = list[i] + direction;
            cost[i]++;
        }
    }

    public static int getmargin(int index, int n, int[]cost)
    {
        int margincost = 0;

        for (int i = index; i <= index + n; i++)
        {
            margincost = margincost + 2 * cost[i] + 1;
        }
        return margincost;
    }

    public static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) 
        {
            int partitionIndex = partition(arr, begin, end);
    
            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);
    
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
    
        swap(arr, i + 1, end);
    
        return i+1;
    }

    private static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
