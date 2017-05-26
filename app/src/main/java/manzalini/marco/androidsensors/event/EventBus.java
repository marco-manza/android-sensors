package manzalini.marco.androidsensors.event;

/**
 * @author Marco Manzalini, marco.manzalini@gmail.com
 */

public class EventBus {

    private static EventBus instance;

    public static EventBus getInstance() {
        if (instance == null) {
            synchronized (EventBus.class) {
                if (instance == null) {
                    instance = new EventBus();
                }
            }
        }
        return instance;
    }
}
