import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class MyArrayList<E> {

    private Object[] elements;
    private int size;

    public MyArrayList() {
        elements = new Object[10];
        size = 0;
    }

    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) elements[index];
    }

    public int size() {
        return size;
    }

    public void add(E element) {
        ensureCapacity(size + 1);
        elements[size] = element;
        int idx = size;
        size++;
    }

    public void addAll(E ... elementsToAdd) {
        ensureCapacity(size + elementsToAdd.length);
        System.arraycopy(elementsToAdd, 0, elements, size, elementsToAdd.length);
        size += elementsToAdd.length;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity - elements.length > 0) {
            int oldCapacity = elements.length;
            int newCapacity = oldCapacity + (oldCapacity / 2);
            if (newCapacity - minCapacity < 0) {
                newCapacity = minCapacity;
            }
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E oldValue = (E) elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            /*public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
                src: Исходный массив, из которого копируются элементы.
                srcPos: Начальная позиция в исходном массиве, с которой начнется копирование.
                dest: Массив назначения, в который будут копироваться элементы.
                destPos: Начальная позиция в массиве назначения, с которой начнется вставка скопированных элементов.
                length: Количество элементов для копирования.*/
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
    }
    public void remove(Object o) {
        //Определяется индекс удаляемого элемента
        for (int index = 0; index < size; index++) {
            if (Objects.equals(o, elements[index])) {
                fastRemove(index);
                return;
            }
        }
    }

    private void fastRemove(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
    }

    public void sort(Comparator<? super E> c) {
        E[] array = (E[]) Arrays.copyOf(elements, size, Object[].class);
        quickSort(array, 0, size - 1, c);
        System.arraycopy(array, 0, elements, 0, size);
    }

    private void quickSort(E[] array, int low, int high, Comparator<? super E> c) {
        if (low < high) {
            int pi = partition(array, low, high, c);
            quickSort(array, low, pi - 1, c);
            quickSort(array, pi + 1, high, c);
        }
    }

    private int partition(E[] array, int low, int high, Comparator<? super E> c) {
        E pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (c.compare(array[j], pivot) <= 0) {
                i++;
                E temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        E temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}