import java.util.*;
import java.io.*;
class Cowphabet
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String alphabet = in.readLine();
        String word = in.readLine();
        int count = 0;
        int repeat = 0;
        while (count < word.length())
        {
            for (int i = 0; i < alphabet.length(); i++)
            {
                if (alphabet.charAt(i) == word.charAt(count))
                {
                    count++;
                }
                if (count == word.length())
                {
                    break;
                }
            }
            repeat++;
        }
        System.out.println(repeat);
    }
}