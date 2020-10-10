import java.util.Arrays;

public class DynamicArray<T> {
    Object[] data;
    int size;

    public DynamicArray() {
        size = 0;
        data = new Object[1];
    }

    public int getSize() {
        return data.length;
    }

    public T getData(int index) {
        return (T) data[index];
    }

    public void add(Object object) {
        ensureCapacity(size + 1);
        data[size ++] = object;
    }

    public void ensureCapacity(int minCapacity) {
        int oldCapacity = getSize();
        if (minCapacity > oldCapacity) {
            int newCapacity = oldCapacity * 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            data = Arrays.copyOf(data, newCapacity);
        }
    }
}
