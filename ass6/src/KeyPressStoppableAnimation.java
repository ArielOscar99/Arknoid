import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
/**
 * @author Ariel Oscar id: 209341684
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean isAlreadyPressed;
    private boolean stop;

    /**
     *
     * @param sensor
     * @param key
     * @param animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.setSensor(sensor);
        this.setKey(key);
        this.setAnimation(animation);
        this.setAlreadyPressed(true);
        this.setStop(false);
    }

    /**
     * Function sets sensor with a given KeyboardSensor.
     * @param sensor
     */
    public void setSensor(KeyboardSensor sensor) {
        this.sensor = sensor;
    }

    /**
     * Function sets key with a given String.
     * @param key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Function sets animation with a given Animation.
     * @param animation
     */
    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    /**
     * Function sets alreadyPressed with a given boolean.
     * @param alreadyPressed
     */
    public void setAlreadyPressed(boolean alreadyPressed) {
        isAlreadyPressed = alreadyPressed;
    }

    /**
     * Function sets stop with a given boolean.
     * @param stop
     */
    public void setStop(boolean stop) {
        this.stop = stop;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        animation.doOneFrame(d);
        if (this.sensor.isPressed(this.key) && !this.isAlreadyPressed) {
            this.stop = true;
        } else {
            this.isAlreadyPressed = false;
        }

    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
    // ...
    // think about the implementations of doOneFrame and shouldStop.
}