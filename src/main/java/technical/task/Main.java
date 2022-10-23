package technical.task;

import technical.task.join.data.DataRow;
import technical.task.join.JoinOperation;
import technical.task.join.impl.InnerJoinOperation;
import technical.task.join.impl.LeftJoinOperation;
import technical.task.join.impl.RightJoinOperation;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataRow leftDataRow0 = new DataRow(0, "Ukraine");
        DataRow leftDataRow1 = new DataRow(1, "Germany");
        DataRow leftDataRow2 = new DataRow(2, "France");

        DataRow rightDataRow0 = new DataRow(0, "Kyiv");
        DataRow rightDataRow1 = new DataRow(1, "Berlin");
        DataRow rightDataRow2 = new DataRow(3, "Budapest");

        List<DataRow> leftCollection = new ArrayList();
        leftCollection.add(leftDataRow0);
        leftCollection.add(leftDataRow1);
        leftCollection.add(leftDataRow2);

        List<DataRow> rightCollection = new ArrayList();
        rightCollection.add(rightDataRow0);
        rightCollection.add(rightDataRow1);
        rightCollection.add(rightDataRow2);

        JoinOperation innerJoin = new InnerJoinOperation();
        System.out.println(innerJoin.join(leftCollection, rightCollection));

        JoinOperation leftJoin = new LeftJoinOperation();
        System.out.println(leftJoin.join(leftCollection, rightCollection));

        JoinOperation rightJoin = new RightJoinOperation();
        System.out.println(rightJoin.join(leftCollection, rightCollection));
    }
}
