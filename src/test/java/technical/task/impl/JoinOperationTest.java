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

public class JoinOperationTest {
    private JoinOperation innerJoin = new InnerJoinOperation();
    private JoinOperation leftJoin = new LeftJoinOperation();
    private JoinOperation rightJoin = new RightJoinOperation();
    private List<DataRow> leftCollection;
    private List<DataRow> rightCollection;

    private DataRow leftDataRow0 = new DataRow(0, "Ukraine");
    private DataRow leftDataRow1 = new DataRow(1, "Germany");
    private DataRow leftDataRow2 = new DataRow(2, "France");

    private DataRow rightDataRow0 = new DataRow(0, "Kyiv");
    private DataRow rightDataRow1 = new DataRow(1, "Berlin");
    private DataRow rightDataRow2 = new DataRow(3, "Budapest");

    @BeforeEach
    void setUp() {
        leftCollection = new ArrayList();
        rightCollection = new ArrayList();

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
        Collection actual = innerJoin.join(leftCollection, rightCollection);
        Collection expected = new ArrayList<>();
        expected.add(new JoinedDataRow(0, "Ukraine", "Kyiv"));
        expected.add(new JoinedDataRow(1, "Germany", "Berlin"));
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
        Collection actual = leftJoin.join(leftCollection, rightCollection);
        Collection expected = new ArrayList<>();
        expected.add(new JoinedDataRow(0, "Ukraine", "Kyiv"));
        expected.add(new JoinedDataRow(1, "Germany", "Berlin"));
        expected.add(new JoinedDataRow(2, "France", null));
        assertEquals(expected, actual);
    }

    @Test
    void rightJoinOperation_Ok() {
        Collection actual = rightJoin.join(leftCollection, rightCollection);
        Collection expected = new ArrayList<>();
        expected.add(new JoinedDataRow(0, "Ukraine", "Kyiv"));
        expected.add(new JoinedDataRow(1, "Germany", "Berlin"));
        expected.add(new JoinedDataRow(3, null, "Budapest"));
        assertEquals(expected, actual);
    }
}
