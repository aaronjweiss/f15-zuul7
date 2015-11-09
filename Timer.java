
/**
 * This keeps track of in-game time
 * 
 * @author Colin P. Goss
 * @version 2015.11.08
 */
public class Timer
{
    // instance variables - replace the example below with your own
    private int time;

    /**
     * Constructor for objects of class Timer, with time 0
     */
    public Timer()
    {
        time = 0;
    }
    
    /**
     * Constructor that accepts a starting time
     * @param the time to start
     */
    public Timer(int startingTime)
    {
        time = startingTime;
    }
    
    /**
     * Increase time by one
     */
    public void advanceTime()
    {
        time++;
    }
    
    /**
     * Increase time by a given amount
     * @param the amount of time to increase the timer by
     */
    public void advanceTime(int amtOfTime)
    {
        time += amtOfTime;
    }
    
    /**
     * Decrease time by 1
     */
    public void reverseTime()
    {
        time--;
    }
    
    /**
     * Decrease time by a given amount
     * @param amount of time to decrease the timer by
     */
    public void reverseTime(int amtOfTime)
    {
        time -= amtOfTime;
    }
    
    /**
     * Returns the amount of time passed on the timer
     * @return the amount of time passed so far
     */
    public int getTime()
    {
        return time;
    }
    
    /**
     * Sets the timer to a specific time
     * @param The amount of time to set the timer to
     */
    public void setTime(int amtOfTime)
    {
        time = amtOfTime;
    }
}
