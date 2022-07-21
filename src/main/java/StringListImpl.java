import java.util.Objects;

public class StringListImpl implements StringList {

    private final String[] data;

    private int capacity;

    private static final int INITIAL_SIZE = 15;

    public StringListImpl() {
    data = new String[INITIAL_SIZE];
    capacity = 0;
    }

    public StringListImpl(int n) {
        if (n<=0) {
            throw new IllegalArgumentException("Size of the list must be > 0");
        }
    data = new String[n];
        capacity = 0;
    }


    @Override
    public String add(String item) {
        if (capacity >= data.length) {
            throw new IllegalArgumentException("List is full!");
        }
         if (Objects.isNull(item)) {
            throw new IllegalArgumentException("U can't add Null to the list");
        }
         return data[capacity++] = item;
    }
    @Override
    public String add(int index, String item) {
        if (capacity >= data.length) {
            throw new IllegalArgumentException("List is full!");
        }
        if (Objects.isNull(item)){
            throw new IllegalArgumentException("U can't add Null to the list");
        }
        if (index < 0) {
            throw new IllegalArgumentException("Index must be > 0");
        }
        if (index > capacity) {
            throw new IllegalArgumentException("Index: " + index + " , size: " + capacity);
        }
        for (int i = capacity; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = item;
        capacity++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("U can't add Null to the List");
        }
        if (index < 0) {
            throw new IllegalArgumentException("Index must be > 0");
        }
        if (index > capacity) {
            throw new IllegalArgumentException("Index: " + index + " , size: " + capacity);
        }
        return data[index] = item;
    }


    @Override
    public String remove(String item) {
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("U can't add Null to the List");
        }
        int indexForRemoving = -1;
        for (int i = 0; i < capacity; i++) {
            if (data[i].equals(item)) {
                indexForRemoving = 1;
                break;
            }
        }
        if (indexForRemoving == -1); {
            throw new IllegalArgumentException("Element didn't found!");
        }
    }

    @Override
    public String remove(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index must be > 0");
        }
        if (index >= capacity) {
            throw new IllegalArgumentException("Index: " + index + " , size: " + capacity);
        }
        String removed = data[index];
        for (int i = index; i < capacity - 1; i++) {
            data[i] = data[i +1];
        }
        data[--capacity] = null;
        return removed;
    }

    @Override
    public boolean contains(String item) {
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("U can't add Null to the List");
        }
        for (int i = 0; i < capacity; i++) {
            if (data[i]. equals(item)) {
                return true;
            }
         }
        return false;
    }

    @Override
    public int indexOf(String item) {
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("U can't add Null to the List");
        }
        int index = -1;
        for (int i = 0; i < capacity; i++) {
            if (data[i]. equals(item)) {
                index = 1;
                break;
            }
        }
        return  index;
    }

    @Override
    public int lastIndexOf(String item) {
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("U can't add Null to the List");
        }
        int index = -1;
        for (int i = capacity - 1; i >= 0; i--) {
            if (data[i].equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public String get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index must be > 0");
        }
        if (index >= capacity) {
            throw new IllegalArgumentException("Index: " + index + " , size: " + capacity);
        }
        return data[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (size() != otherList.size()) {
            return false;
        }
        for (int i = 0; i < capacity; i++) {
            if (!data[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return capacity ;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        for (int i = 0 ; i <capacity; i++);
    }

    @Override
    public String[] toArray() {
        String[] reslut = new String[capacity];
        for (int i = 0; i < capacity; i++) {
            reslut[i] = data[i];
        }
        return reslut;
     }
}
