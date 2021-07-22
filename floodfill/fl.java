class moocast
{
    public static void main (String [] args)
    {
        int[][] input = new int[5][5];
        boolean[] connected = new boolean[5];
    }

    public static int getallconnection (int[][] connection, int from, boolean[] connected)
    {
        int result = 0;
        if (connected[from] == false)
        {
            result++;
            connected[from] = true;
        }
        for (int i = 0; connection[from][i] != -1; i++)
        {
            int current = connection[from][i];
            if (connected[current] == false)
            {
                connected[current] = true;
                result++;
                result = result + getallconnection(connection, current, connected);
            }
        }
        return result;
    }
}