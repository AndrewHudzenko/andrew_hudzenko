package technical.task.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import technical.task.join.JoinOperation;
import technical.task.join.data.DataRow;
import technical.task.join.data.JoinedDataRow;
import technical.task.join.impl.InnerJoinOperation;
import technical.task.join.impl.LeftJoinOperation;
import technical.task.join.impl.RightJoinOperation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class JoinOperationTest<R, K extends Comparable<K>, V> {
    private JoinOperation<DataRow<K, V>, DataRow<K, V>, R> innerJoin = new InnerJoinOperation<>();
    private JoinOperation<DataRow<K, V>, DataRow<K, V>, R> leftJoin = new LeftJoinOperation<>();
    private JoinOperation<DataRow<K, V>, DataRow<K, V>, R> rightJoin = new RightJoinOperation<>();
    private List<DataRow<K, V>> leftCollection;
    private List<DataRow<K, V>> rightCollection;

    private final DataRow<K, V> leftDataRow0 = new DataRow(0, "Ukraine");
    private final DataRow<K, V> leftDataRow1 = new DataRow(1, "Germany");
    private final DataRow<K, V> leftDataRow2 = new DataRow(2, "France");

    private final DataRow<K, V> rightDataRow0 = new DataRow(0, "Kyiv");
    private final DataRow<K, V> rightDataRow1 = new DataRow(1, "Berlin");
    private final DataRow<K, V> rightDataRow2 = new DataRow(3, "Budapest");

    @BeforeEach
    void setUp() {
        leftCollection = new ArrayList<>();
        rightCollection = new ArrayList<>();

        leftCollection.add(leftDataRow0);
        leftCollection.add(leftDataRow1);
        leftCollection.add(leftDataRow2);

        rightCollection.add(rightDataRow0);
        rightCollection.add(rightDataRow1);
        rightCollection.add(rightDataRow2);
    }

    @AfterEach
    void tearDown() {
        leftCollection.clear();
        rightCollection.clear();
        innerJoin = null;
        leftJoin = null;
        rightCollection = null;
    }

    @Test
    void leftCollection_isNull_notOk() {
        assertThrows(NullPointerException.class, () -> {
            innerJoin.join(null, rightCollection);});
    }

    @Test
    void rightCollection_isNull_notOk() {
        assertThrows(NullPointerException.class, () -> {
            innerJoin.join(leftCollection, null);});
    }

    @Test
    void innerJoinOperation_Ok() {
        Collection<R> actual = innerJoin.join(leftCollection, rightCollection);
        Collection<R> expected = new ArrayList<>();
        expected.add((R) new JoinedDataRow(0, "Ukraine", "Kyiv"));
        expected.add((R) new JoinedDataRow(1, "Germany", "Berlin"));
        assertEquals(expected, actual);
        /**
         * we can simply check with a string(in all tests), but need to call toString() method for actual variable
         * String expected = "[JoinedDataRow(0,\"Ukraine\",\"Kyiv\"), "
                + "JoinedDataRow(1,\"Germany\",\"Berlin\")]";
         * but i guess it's better to compare collections instead of strings
         */
    }

    @Test
    void leftJoinOperation_Ok() {
        Collection<R> actual = leftJoin.join(leftCollection, rightCollection);
        Collection<R> expected = new ArrayList<>();
        expected.add((R) new JoinedDataRow(0, "Ukraine", "Kyiv"));
        expected.add((R) new JoinedDataRow(1, "Germany", "Berlin"));
        expected.add((R) new JoinedDataRow(2, "France", null));
        assertEquals(expected, actual);
    }

    @Test
    void rightJoinOperation_Ok() {
        Collection<R> actual = rightJoin.join(leftCollection, rightCollection);
        Collection<R> expected = new ArrayList<>();
        expected.add((R) new JoinedDataRow(0, "Ukraine", "Kyiv"));
        expected.add((R) new JoinedDataRow(1, "Germany", "Berlin"));
        expected.add((R) new JoinedDataRow(3, null, "Budapest"));
        assertEquals(expected, actual);
    }
}
