package utils;

import java.util.concurrent.TimeUnit;

public class WaitUtil
{
    public static void waitFor(long milliseconds)
    {
        try
        {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();

        }
    }
}
