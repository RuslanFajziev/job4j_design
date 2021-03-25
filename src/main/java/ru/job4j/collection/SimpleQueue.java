package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    int counterIn = 0;
    int counterOut = 0;

    public T poll() {
        if (counterOut == 0) {
            while (counterIn != 0) {
                out.push(in.pop());
                counterOut++;
                counterIn--;
            }
        }
        counterOut--;
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
        counterIn++;
    }
}