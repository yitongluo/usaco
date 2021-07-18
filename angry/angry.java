/*
ID: yitongl1
LANG: JAVA
TASK: angry
*/
import java.io.*;
import java.util.*;

class angry
{
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("angry.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
        StringTokenizer s = new StringTokenizer(f.readLine());
        int haynum = Integer.parseInt(s.nextToken());
        int cownum = Integer.parseInt(s.nextToken());
        int[] list = new int[haynum];
        int[] toleft = new int[haynum];
        int[] toright = new int[haynum];
        toleft[0] = 0;
        for (int i = 0; i < haynum; i++)
        {
            list[i] = Integer.parseInt(f.readLine());
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

        for (int j = haynum - 2; j >= 0; j--)
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
        out.println(getresult(list, 1, 1000000000, cownum, toright, toleft));    
        f.close();
        out.close();   
    }

    public static boolean isok(int[] haylist, int explorange, int cownum, int[] toright, int[] toleft)
    {
        int length = haylist.length;
        int leftbound = haylist[0];
        int rightbound = haylist[0] + 2 * explorange;
        for (int a = 1; a <= cownum; a++)
        {
            if (rightbound >= haylist[length - 1])
            {
                return true;
            }
            int left = binarySearch(haylist, 0, length, leftbound, true);
            int right = binarySearch(haylist, 0, length, rightbound, false);
            int first = binary_Search(haylist, 0, length - 1, leftbound);
            int second = binary_Search(haylist, 0, length - 1, rightbound);
            int result = right - left;
            int count = length;
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
            count = count - result;
            if (count == 0)
            {
                return true;
            }
            if (second == -1)
            {
                leftbound = haylist[binarySearch(haylist, 0, length - 1, rightbound, false)];
            }
            else
            {
                leftbound = haylist[second + toright[second] + 1];
            }
            rightbound = leftbound + 2 * explorange;
        }
        return false;
    }

    public static int getresult(int[] haylist, int low, int high, int cownum, int[] toright, int[] toleft)
    {
        int mid = low + (high - low)/2;  
        boolean current = isok(haylist, mid, cownum, toright, toleft);
        boolean left = isok(haylist, mid - 1, cownum, toright, toleft);
        boolean right = isok(haylist, mid + 1, cownum, toright, toleft);
        if (current == true && left == false)
        {
            return mid;
        }
        if (current == false && right == true)
        {
            return mid + 1;
        }
        if (current == true && left == true)
        {
            return getresult(haylist, low, mid-1, cownum, toright, toleft);
        }
        if (current == false && right == false)
        {
            return getresult(haylist, mid + 1, high, cownum, toright, toleft);
        }
        return -1;
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