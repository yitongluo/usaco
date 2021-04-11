/*
ID: yitongl1
LANG: JAVA
TASK: ride
*/
import java.io.*;

class ride
{
    public static void main (String [] args) throws IOException
    {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        String s1 = f.readLine();
        String s2 = f.readLine();
        if (StayorGo(s1, s2))
        {
            out.println("GO");
        }
        else
        {
            out.println("STAY");
        }
        out.close();                                  
        f.close();
    }

    public static boolean StayorGo(String i1, String i2)
    {
        return (calculate(i1) == calculate(i2));
    }

    public static int calculate(String input)
    {
        int n = 1;
        for (int i=0; i<input.length(); i++)
        {
            char temp = input.charAt(i);
            n = n * (temp - 'A' + 1);
        }
        return n % 47;
    }
}
