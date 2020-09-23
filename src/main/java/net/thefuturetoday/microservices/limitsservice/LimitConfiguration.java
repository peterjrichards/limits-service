package net.thefuturetoday.microservices.limitsservice;

public class LimitConfiguration {
    private int maximum;
    private int minimum;

    // no-argument constructor
    public LimitConfiguration() {
    }

    public LimitConfiguration(int maximum, int minimum) {
        this();
        this.maximum = maximum;
        this.minimum = minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }
}
