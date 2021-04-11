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
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int i1 = Integer.parseInt(st.nextToken());   
        int i2 = Integer.parseInt(st.nextToken());   
        out.close();                                  
        f.close();
    }

    
}