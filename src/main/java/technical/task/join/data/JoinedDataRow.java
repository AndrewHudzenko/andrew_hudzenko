package technical.task.join.data;

import java.util.Objects;

public class JoinedDataRow<K extends Comparable<K>, V1, V2> {
    private K id;
    private V1 leftDataValue;
    private V2 rightDataValue;

    public JoinedDataRow() {

    }

    public JoinedDataRow(K id, V1 leftDataValue, V2 rightDataValue) {
        this.id = id;
        this.leftDataValue = leftDataValue;
        this.rightDataValue = rightDataValue;
    }

    public K getId() {
        return id;
    }

    public void setId(K id) {
        this.id = id;
    }

    public V1 getLeftDataValue() {
        return leftDataValue;
    }

    public void setLeftDataValue(V1 leftDataValue) {
        this.leftDataValue = leftDataValue;
    }

    public V2 getRightDataValue() {
        return rightDataValue;
    }

    public void setRightDataValue(V2 rightDataValue) {
        this.rightDataValue = rightDataValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JoinedDataRow<?, ?, ?> that = (JoinedDataRow<?, ?, ?>) o;
        return Objects.equals(id, that.id) && Objects.equals(leftDataValue, that.leftDataValue) && Objects.equals(rightDataValue, that.rightDataValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, leftDataValue, rightDataValue);
    }

    @Override
    public String toString() {
        return "JoinedDataRow("
                + id + ","
                + "\"" + leftDataValue + "\"" + ","
                + "\"" + rightDataValue + "\"" + ")";
    }
}
