import junit.framework.TestCase;
import org.junit.Test;
import org.junit.platform.engine.support.hierarchical.Node;
import org.linkedlist.LinkedList;

public class LinkedListTest extends TestCase {

    private final static String testValue1 = "First Node";
    private LinkedList list;

    @Override
    protected void setUp () throws Exception{
        list = new LinkedList();
        list.insertInTheBeginning(testValue1);
        list.insertAtTheEnd("Last Node");
        list.insertAtPosition(2, "Middle Node");
        list.insertInTheBeginning("The Very First Node");
    }

    public void testInsertInTheBeginning_Value_ValueIsInsertedInTheBeginning (){
        var expected = "1";
        list.insertInTheBeginning(expected);

        var actual = list.getHead().getData();

        assertEquals(actual, expected);
    }

    public void testRemoveValue_Value_ValueIsRemoved(){

        list.removeValue(testValue1);

        var result = list.search(testValue1);
        assertFalse(result);
    }

    public void testRemoveByPosition_Value_ValueIsRemovedFromPosition(){
        int position = 3;
        var temp = list.getHead();
        for (int i = 1; temp != null && i < position; i++) {
            temp = temp.getNext();
        }

        list.removeByPosition(position);

        var result = list.search(temp.getData());
        assertFalse(result);
    }

    public void testSearch_Value_ValueIsFound(){
        var result = list.search(testValue1);

        assertTrue(result);
    }

    public void testLength_4Nodes_True (){
        int expected = 4;

        int actual = list.length();

        assertEquals(expected, actual);
    }

    public void testClear_List_Empty (){
        int expected = 0;

        list.clear();

        int actual = list.length();
        assertEquals(expected, actual);
    }
}
