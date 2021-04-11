/*
ID: yitongl1
LANG: JAVA
TASK: friday 
*/
import java.io.*;

class friday
{
    public static void main (String [] args) throws IOException
    {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("friday.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        int i1 = Integer.parseInt(f.readLine());   // first integer    // second integer
        int[] result = calculate(i1);
        for (int i = 0; i < result.length; i++)
        {
            if (i == result.length - 1)
            {
                out.print(result[i]);
            }
            else
            {
                out.print(result[i] + " ");
            }
        }
        out.println("");
        out.close();                                  // close the output file
        f.close();
    }

    private static int[] monthdaylist = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    public static int[] determine_leap(int input)
    {
        monthdaylist[1] = isLeapYear(1900 + input) ? 29 : 28;
        return monthdaylist;
    }

    private static boolean isLeapYear(int year)
    {
        return (year % 400 == 0) || (year % 100 != 0) && (year % 4 == 0);
    }

    private static int[] calculate(int input)
    {
        int temp = 0;
        int[] count = new int[7];
        for (int i = 0; i < input; i++)
        {
            for (int num : determine_leap(i))
            {
                count[(temp + 14) % 7]++;
                temp = temp + num;    
            }
        }
        return count;
    }  
}
    