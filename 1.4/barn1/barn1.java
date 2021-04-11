/*
ID: yitongl1
LANG: JAVA
TASK: barn1
*/
import java.io.*;
import java.util.*;

class barn1
{
    public static void main (String [] args) throws IOException
    {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
                  // Get line, break into tokens
        int boards = Integer.parseInt(st.nextToken());    
        int stalls = Integer.parseInt(st.nextToken());  
        int stallWithCow= Integer.parseInt(st.nextToken());
        int[] distancebetween = new int[stallWithCow];
        int[]cow = new int[stallWithCow];
        int current;
        for (int i = 0; i < stallWithCow; i++)
        {
            StringTokenizer x = new StringTokenizer(f.readLine());
            current = Integer.parseInt(x.nextToken());
            cow[i] = current;
        }
        quickSort(cow, 0, stallWithCow - 1);
        //out.println(Arrays.toString(cow));
        for (int i = 0; i < stallWithCow; i++)
        {
            if (i > 0)
            {
                distancebetween[i] = cow[i] - cow[i - 1] - 1;
            }
        } 

        quickSort(distancebetween, 0, distancebetween.length - 1); 
        int first = cow[0];
        int last = cow[stallWithCow - 1];
        int total = last - first + 1;
        //out.println(total);
        for (int i = 1; i < boards; i++)
        {
            if (i == stallWithCow + 1)
            {
                break;
            }
            total -= distancebetween[stallWithCow - i];
            //out.println(distancebetween[stallWithCow - i]);
            //out.println(total);
        }
        out.println(total);
        //out.println(Arrays.toString(distancebetween));                    
        out.close();                                  
        f.close();
    }

    public static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) 
        {
            int partitionIndex = partition(arr, begin, end);
    
            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private static int partition(int arr[], int begin, int end) {
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