package isel.adeetc.poo.helloandroid;

public class Counter {

    public interface Listener {
        void valueChanged(Counter counter);
    }

    private int value;
    private int modulo;
    private Listener listener;

    private void fireEvent() {
        if (listener != null)
            listener.valueChanged(this);
    }

    public Counter(int initialValue, int modulo) {
        this.value = initialValue;
        this.modulo = modulo;
        this.listener = null;
    }

    public Counter increment() {
        value = (value + 1) % modulo;
        fireEvent();
        return this;
    }

    public Counter decrement() {
        // TODO: Implement
        value -= 1;
        fireEvent();
        return this;
    }

    public int getValue() {
        return value;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }
}
