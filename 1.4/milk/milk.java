/*
ID: yitongl1
LANG: JAVA
TASK: milk
*/
import java.io.*;
import java.util.*;

class milk
{
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("milk.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int milkAmount = Integer.parseInt(st.nextToken());    
        int farmer = Integer.parseInt(st.nextToken());    
        int[][] priceList = new int[farmer][2];   
        for (int i = 0; i < farmer; i++)
        {
            StringTokenizer x = new StringTokenizer(f.readLine());
            priceList[i][0] = Integer.parseInt(x.nextToken());
            priceList[i][1] = Integer.parseInt(x.nextToken());
        } 

        quickSort(priceList, 0, farmer - 1);  
        // for (int i = 0; i < priceList.length; i++)
        // {
        //     out.println(Arrays.toString(priceList[i]));
        // }
        int currentMilk = 0;
        int moneySpend = 0;
        for (int i = 0; i < priceList.length; i++)
        {
            int price = priceList[i][0];
            int currentSupply = priceList[i][1];
            if (currentMilk + currentSupply < milkAmount)
            {
                moneySpend = moneySpend + currentSupply * price;
                currentMilk = currentMilk + currentSupply;
            }
            else
            {
                moneySpend += (milkAmount - currentMilk) * price;
                break; 
            }
        }   
        out.println(moneySpend);           
        out.close();                                 
        f.close();
    }

    public static void quickSort(int arr[][], int begin, int end) 
    {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
    
            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private static int partition(int arr[][], int begin, int end) 
    {
        int pivot = arr[end][0];
        int i = (begin-1);
    
        for (int j = begin; j < end; j++) {
            if (arr[j][0] <= pivot) {
                i++;
    
                int swapTemp = arr[i][0];
                int swapTempB = arr[i][1];
                arr[i][0] = arr[j][0];
                arr[i][1] = arr[j][1];
                arr[j][0] = swapTemp;
                arr[j][1] = swapTempB;

            }
        }
    
        int swapTemp = arr[i+1][0];
        int swapTempB = arr[i+1][1];
        arr[i+1][0] = arr[end][0];
        arr[i+1][1] = arr[end][1];
        arr[end][0] = swapTemp;
        arr[end][1] = swapTempB;
        return i+1;
    }
}