package technical.task;

import technical.task.join.data.DataRow;
import technical.task.join.JoinOperation;
import technical.task.join.impl.InnerJoinOperation;
import technical.task.join.impl.LeftJoinOperation;
import technical.task.join.impl.RightJoinOperation;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static <R, K extends Comparable<K>, V> void main(String[] args) {
        DataRow<K, V> leftDataRow0 = new DataRow(0, "Ukraine");
        DataRow<K, V> leftDataRow1 = new DataRow(1, "Germany");
        DataRow<K, V> leftDataRow2 = new DataRow(2, "France");

        DataRow<K, V> rightDataRow0 = new DataRow(0, "Kyiv");
        DataRow<K, V> rightDataRow1 = new DataRow(1, "Berlin");
        DataRow<K, V> rightDataRow2 = new DataRow(3, "Budapest");

        List<DataRow<K, V>> leftCollection = new ArrayList<>();
        leftCollection.add(leftDataRow0);
        leftCollection.add(leftDataRow1);
        leftCollection.add(leftDataRow2);

        List<DataRow<K, V>> rightCollection = new ArrayList<>();
        rightCollection.add(rightDataRow0);
        rightCollection.add(rightDataRow1);
        rightCollection.add(rightDataRow2);

        JoinOperation<DataRow<K, V>, DataRow<K, V>, R> innerJoin = new InnerJoinOperation<>();
        System.out.println(innerJoin.join(leftCollection, rightCollection));

        JoinOperation<DataRow<K, V>, DataRow<K, V>, R> leftJoin = new LeftJoinOperation<>();
        System.out.println(leftJoin.join(leftCollection, rightCollection));

        JoinOperation<DataRow<K, V>, DataRow<K, V>, R> rightJoin = new RightJoinOperation<>();
        System.out.println(rightJoin.join(leftCollection, rightCollection));
    }
}
