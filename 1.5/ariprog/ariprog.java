/*
ID: yitongl1
LANG: JAVA
TASK: ariprog
*/
import java.io.*;
import java.util.*;

class ariprog
{
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("ariprog.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")))
        int a = Integer.parseInt(f.readLine());   
        int b = Integer.parseInt(f.readLine());   
        out.close();                                  
        f.close();
        boolean[] allbisquare = new boolean[b * b + 1];
        for (int i = 0; i <= b; i++)
        {
            for (int j = 0; j <= b; j++)
            {
                allbisquare[i * i + j * j] = true;
            }
        }
    }

    
}