/**
 * @author Ariel Oscar id: 209341684
 */
public class Counter {
    private int counter;

    /**
     * Function constructs a new Counter.
     */
    public Counter() {
        this.setCounter(0);
    }

    /**
     * Function sets a counter with a given counter.
     * @param counter
     */
    public void setCounter(int counter) {
        this.counter = counter;
    }

    /**
     * @return counter.
     */
    public int getCounter() {
        return counter;
    }

    /**
     * Function adds number to current count.
     * @param number
     */
    void increase(int number) {
        this.counter += number;

    }
    /**
     * Function subtracts number from current count.
     * @param number
     */
    void decrease(int number) {
        this.counter -= number;
    }
}