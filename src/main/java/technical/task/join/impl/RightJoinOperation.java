package technical.task.join.impl;

import technical.task.join.JoinOperation;
import technical.task.join.data.DataRow;
import technical.task.join.data.JoinedDataRow;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RightJoinOperation implements JoinOperation {
    @Override
    public Collection join(Collection leftCollection, Collection rightCollection) {
        List<DataRow> leftData = (List<DataRow>) leftCollection;
        List<DataRow> rightData = (List<DataRow>) rightCollection;

        List<JoinedDataRow> result = new ArrayList<>();

        for (int i = 0; i < rightData.size(); i++) {
            JoinedDataRow joinedData = new JoinedDataRow();

            joinedData.setId(rightData.get(i).getId());
            joinedData.setRightDataValue(rightData.get(i).getValue());

            for (int j = 0; j < leftData.size(); j++) {
                if (rightData.get(i).getId().equals(leftData.get(j).getId())) {
                    joinedData.setLeftDataValue(leftData.get(j).getValue());
                }
            }
            result.add(joinedData);
        }
        return result;
    }
}
