package core;

public abstract class Runner
{
    protected boolean isStopped = true;

    public boolean getIsStopped()
    {
        return isStopped;
    }

    public abstract void start();

    public abstract void stop();
}
