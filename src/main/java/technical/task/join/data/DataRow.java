package technical.task.join.data;

import java.util.Objects;

public class DataRow<K extends Comparable<K>, V> {
    private K id;
    private V value;

    public DataRow(K id, V value) {
        this.id = id;
        this.value = value;
    }

    public K getId() {
        return id;
    }

    public void setId(K id) {
        this.id = id;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataRow<?, ?> dataRow = (DataRow<?, ?>) o;
        return Objects.equals(id, dataRow.id) && Objects.equals(value, dataRow.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }
}
