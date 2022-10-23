package technical.task.join.impl;

import technical.task.join.JoinOperation;
import technical.task.join.data.DataRow;
import technical.task.join.data.JoinedDataRow;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LeftJoinOperation<D1, D2, R, K extends Comparable<K>, V, V1, V2> implements JoinOperation<D1, D2, R> {
    @Override
    public Collection<R> join(Collection<D1> leftCollection, Collection<D2> rightCollection) {
        List<DataRow<K, V>> leftData = (List<DataRow<K, V>>) leftCollection;
        List<DataRow<K, V>> rightData = (List<DataRow<K, V>>) rightCollection;

        List<R> result = new ArrayList<>();

        for (DataRow<K, V> value : leftData) {
            JoinedDataRow<K, V1, V2> joinedData = new JoinedDataRow<>();

            joinedData.setId(value.getId());
            joinedData.setLeftDataValue((V1) value.getValue());

            for (DataRow<K, V> secondValue : rightData) {
                if (value.getId().equals(secondValue.getId())) {
                    joinedData.setRightDataValue((V2) secondValue.getValue());
                }
            }
            result.add((R) joinedData);
        }
        return result;
    }
}
