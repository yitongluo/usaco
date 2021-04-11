/*
ID: yitongl1
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.*;

class gift1
{
    public static void main (String [] args) throws IOException
    {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
                                                      // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
                  // Get line, break into tokens
        int np = Integer.parseInt(f.readLine());
        Person[] people = new Person[np];
        for (int i = 0; i < np; i ++)
        {
            people[i] = new Person(f.readLine(), 0);

        }

        for (int i = 0; i < np; i++)
        {
            String giver = f.readLine();
            StringTokenizer st = new StringTokenizer(f.readLine());
            int money = Integer.parseInt(st.nextToken());
            int number_of_reciever = Integer.parseInt(st.nextToken());
            Person.match(giver, people).give(number_of_reciever, money); 
            for (int j = 0; j < number_of_reciever; j++)
            {
                String reciever = f.readLine();
                Person.match(reciever, people).recieve(number_of_reciever, money);    
            }
        }
        for (int i = 0; i < people.length; i++)
        {
            out.println(people[i].toString());
        }
        out.close();                                  // close the output file
        f.close();    
    }
}

class Person
{
    private final String name;
    private int balance;
    
    public Person (String name, int balance)
    {
        this.name = name;
        this.balance = balance;
    }

    public static Person match(String x, Person[] people)
    {
        for (int i = 0; i < people.length; i++)
        {
            if (people[i].name.equals(x))
            {
                return people[i];
            }
        }
        return null;
    }

    public void give(int np_reciever, int money)
    {
        if (np_reciever!=0)
        {
            balance = balance - money + money % np_reciever;
        }
    }

    public void recieve(int np_reciever, int money)
    {
        if (np_reciever != 0)
        {
            balance = balance + money / np_reciever;
        }
    }
   
    public String toString()
    {
        return (name + " " + balance);
    }
}

   