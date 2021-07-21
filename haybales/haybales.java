/*
ID: yitongl1
LANG: JAVA
TASK: haybales
*/
import java.io.*;
import java.util.*;

class haybales
{
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("haybales.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
        StringTokenizer s = new StringTokenizer(f.readLine());
        int length = Integer.parseInt(s.nextToken());
        int q = Integer.parseInt(s.nextToken());
        int[] list = new int[length];
        int[] toleft = new int[length];
        int[] toright = new int[length];
        toleft[0] = 0;
        StringTokenizer st = new StringTokenizer(f.readLine());
        for (int a = 0; a < list.length; a++)
        {
            list[a] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);

        for (int i = 0; i < list.length; i++)
        {
            if (i > 0 && list[i] == list[i - 1])
            {
                toleft[i] = toleft[i - 1] + 1;
            }
            if (i > 0 && list[i] != list[i - 1])
            {
                toleft[i] = 0;
            }
        }

        for (int j = length - 2; j >= 0; j--)
        {
            if (list[j] == list[j + 1])
            {
                toright[j] = toright[j + 1] + 1;
            }
            if (list[j] != list[j + 1])
            {
                toright[j] = 0;
            }
        }

        for (int c = 1; c <= q; c++)
        {
            StringTokenizer qreader = new StringTokenizer(f.readLine());
            int left = Integer.parseInt(qreader.nextToken());
            int right = Integer.parseInt(qreader.nextToken());
            int result = binarySearch(list, 0, length - 1, right, false) - 
            binarySearch(list, 0, length - 1, left, true);
            //out.println(result);
            int first = binary_Search(list, 0, length - 1, left);
            int second = binary_Search(list, 0, length - 1, right);
            if (first == -1 && second == -1)
            {
                result--;
            }
            if (first != -1 && second != -1)
            {
                result++;
            }
            if (first != -1)
            {
                result = result + toleft[first];
            }
            if (second != -1)
            {
                result = result + toright[second];
            }
            out.println(result);
        }
        f.close();
        out.close();
    }

    public static int binarySearch(int[] intArray, int low, int high, int key, boolean takeleft){  
        if (high>=low){  
            int mid = low + (high - low)/2;  
            if (intArray[mid] == key)
            {  
            return mid;  
            }  
            if (intArray[mid] > key)
            {  
            return binarySearch(intArray, low, mid-1, key, takeleft);  
            }
            else       //key is in right half of the array
            {  
            return binarySearch(intArray, mid+1, high, key, takeleft);
            }  
        }  
        else
        {
            if (takeleft)
            {
                return high;
            }
            else
            {
                return low;
            }
        }  
    }
    public static int binary_Search(int intArray[], int low, int high, int key){  
        if (high>=low){  
            int mid = low + (high - low)/2;  
            if (intArray[mid] == key){  
            return mid;  
            }  
            if (intArray[mid] > key){  
            return binary_Search(intArray, low, mid-1, key);
            }else       
            {  
            return binary_Search(intArray, mid+1, high, key);
            }  
        }  
        return -1;  
    }
}