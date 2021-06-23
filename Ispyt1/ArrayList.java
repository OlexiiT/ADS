package ispyt1;

import java.util.Comparator;

public class ArrayList implements List {

    private Object[] data = new Object[10];
    private int arraySize = 10;
    private int currentSize = 0;

    public void sort(Comparator c) {
        Object min;
        int index;
        for (int i = 0; i < size() - 1; i++) {
            min = data[i];
            index = i;
            for (int j = i; j < size() - 1; j++) {
                if (c.compare(min, data[j]) > 0) {
                    min = data[j];
                    index = j;
                }
            }
            data[index] = data[i];
            data[i] = min;
        }
    }
    
    private void exchange() {
        
    }
    
    private void checkSize() {
        if (currentSize == arraySize) {
            extendArray();
        } else if (currentSize < arraySize / 4 && arraySize > 10) {
            cutArray();
        }
    }

    private void extendArray() {
        Object[] newData = new Object[arraySize * 2];
        for (int i = 0; i < arraySize; i++) {
            newData[i] = data[i];
        }
        data = newData;
        arraySize *= 2;
    }

    private void cutArray() {
        Object[] newData = new Object[arraySize / 2];
        arraySize /= 2;
        for (int i = 0; i < arraySize; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public void addFirst(Object o) {
        for (int i = currentSize; i > 0; i--) {
            data[i] = data[i - 1];
        }
        data[0] = o;
        currentSize++;
        checkSize();
    }

    @Override
    public void addLast(Object o) {
        data[currentSize] = o;
        currentSize++;
        checkSize();
    }

    @Override
    public void add(Object o, int index) {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(o);
        } else if (index == currentSize) {
            addLast(o);
        } else {
            for (int i = currentSize; i > index; i--) {
                data[i] = data[i - 1];
            }
            data[index] = o;
            currentSize++;
            checkSize();
        }
    }

    @Override
    public void removeFirst() {
        for (int i = 0; i < currentSize; i++) {
            data[i] = data[i + 1];
        }
        currentSize--;
        checkSize();
    }

    @Override
    public void removeLast() {
        data[currentSize - 1] = null;
        currentSize--;
        checkSize();
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            removeFirst();
        } else if (index == currentSize - 1) {
            removeLast();
        } else {
            for (int i = index; i < currentSize; i++) {
                data[i] = data[i + 1];
            }
            currentSize--;
            checkSize();
        }
    }

    @Override
    public void changeFirst(Object o) {
        data[0] = o;
    }

    @Override
    public void changeLast(Object o) {
        data[currentSize - 1] = o;
    }

    @Override
    public void change(Object o, int index) {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException();
        }
        data[index] = o;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public int index(Object value) {
        if (value == null) {
            for (int i = 0; i < currentSize; i++) {
                if (data[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < currentSize; i++) {
                if (value.equals(data[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException();
        }
        return data[index];
    }

    @Override
    public int sum() {
        int result = 0;
        for (int i = 0; i < currentSize; i++) {
            result += (int) data[i];
        }
        return result;
    }

    @Override
    public void clean() {
        data = new Object[10];
        arraySize = 10;
        currentSize = 0;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < size(); i++) {
            s += ((Film) (data[i])).toString() + ", ";
        }
        return s;
    }

}
