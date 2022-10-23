package technical.task.join.impl;

import technical.task.join.JoinOperation;
import technical.task.join.data.DataRow;
import technical.task.join.data.JoinedDataRow;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class InnerJoinOperation implements JoinOperation {
    @Override
    public Collection join(Collection leftCollection, Collection rightCollection) {
        List<DataRow> leftData = (List<DataRow>) leftCollection;
        List<DataRow> rightData = (List<DataRow>) rightCollection;

        List<JoinedDataRow> result = new ArrayList<>();

        for (int i = 0; i < leftData.size(); i++) {
            for (int j = 0; j < rightCollection.size(); j++) {
                if (leftData.get(i).getId().equals(rightData.get(j).getId())) {
                    JoinedDataRow joinedData = new JoinedDataRow();
                    joinedData.setId(leftData.get(i).getId());
                    joinedData.setLeftDataValue(leftData.get(i).getValue());
                    joinedData.setRightDataValue(rightData.get(j).getValue());
                    result.add(joinedData);
                }
            }
        }
        return result;
    }
}
