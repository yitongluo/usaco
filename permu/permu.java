import java.util.Arrays;
import java.util.Currency;

class permu
{
    public static void main (String [] args)
    {
        int[] list = {0, 1, 2, 3};
        boolean[] used = {false, false, false, false};
        int[] current = new int[4];
        getpermu(list, used, current, 0);
    }

    public static void getpermu(int[]list, boolean[] used, int[] current, int idx)
    {
        if (idx == list.length)
        {
            System.out.println(Arrays.toString(current));
        }
        for (int i = 0; i < list.length; i++)
        {
            if (used[i] == false)
            {
                int[] current2 = Arrays.copyOf(current, current.length);
                boolean[] used2 = Arrays.copyOf(used, used.length);
                current2[idx] = list[i];
                used2[i] = true;
                getpermu(list, used2, current2, idx + 1);
            }
        }
    }
}