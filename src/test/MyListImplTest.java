package test;

import main.Elem;
import main.MyList;
import main.MyListImpl;
import org.junit.*;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import static org.junit.Assert.*;

public class MyListImplTest {

    private static MyList<Integer> sut;
    private static int expectedSize;
    private static Properties prop;
    private static List<Integer> testSet;
    private static FileInputStream propFile;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        prop = new Properties();
        testSet = new LinkedList<Integer>();
        propFile = new FileInputStream("src/config.properties");
        prop.load(propFile);
        expectedSize = Integer.parseInt(prop.getProperty("taille"));

        sut = new MyListImpl<Integer>();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        propFile.close();
    }


    @Before
    public void setUp() throws Exception {
        String numbers = prop.getProperty("nombre");
        for (String i : numbers.split(" ")) {
            testSet.add(Integer.parseInt(i.trim()));
        }
        for (int i :
                testSet) {
            sut.add(new Integer(i));
        }
    }

    @After
    public void tearDown() throws Exception {
        sut.reset();
        testSet.clear();
    }

    @Test
    public void add() {
        assertEquals(expectedSize, sut.getSize());
        sut.add(new Integer(8));
        assertEquals(expectedSize+1, sut.getSize());
        for (int i = 0; i < testSet.size(); i++) {
            assertEquals(testSet.get(i), sut.getAt(i));
        }
    }

    @Test
    public void removeAt() {
        int indexToRemove = 2;
        sut.removeAt(indexToRemove);
        testSet.remove(indexToRemove);
        assertEquals(expectedSize - 1, sut.getSize());
        for (int i = 0; i < testSet.size(); i++) {
            assertEquals(testSet.get(i), sut.getAt(i));
        }
    }

    @Test
    public void removeAtIndexZero() {
        int indexToRemove = 0;
        sut.removeAt(indexToRemove);
        testSet.remove(indexToRemove);
        assertEquals(expectedSize - 1, sut.getSize());
        for (int i = 0; i < testSet.size(); i++) {
            assertEquals(testSet.get(i), sut.getAt(i));
        }
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void removeIndexLongerThanListSize() {
        sut.removeAt(sut.getSize() + 1);
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void SetIndexLongerThanListSize() {
        sut.getAt(sut.getSize() + 1);
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void setIndexLongerThanListSize() {
        sut.setAt(50,sut.getSize()+1);
    }

    @Test
    public void removeItem() {
        Integer intToRemove = new Integer(2);
        sut.removeItem(intToRemove);
        testSet.remove(intToRemove);
        assertEquals(expectedSize - 1, sut.getSize());
        for (int i = 0; i < testSet.size(); i++) {
            assertEquals(testSet.get(i), sut.getAt(i));
        }
    }

    @Test
    public void removeFirstItem() {
        Integer intToRemove = new Integer(1);
        sut.removeItem(intToRemove);
        testSet.remove(intToRemove);
        assertEquals(expectedSize - 1, sut.getSize());
        for (int i = 0; i < testSet.size(); i++) {
            assertEquals(testSet.get(i), sut.getAt(i));
        }
    }

    @Test
    public void setAt() {
        int indexTochange = 3;
        Integer newIntegerInsered = new Integer(50);
        sut.setAt(newIntegerInsered, indexTochange);
        testSet.set(indexTochange, newIntegerInsered);
        assertEquals(expectedSize , sut.getSize());
        for (int i = 0; i < testSet.size(); i++) {
            assertEquals(testSet.get(i), sut.getAt(i));
        }
    }

    @Test
    public void getAt() {
        int indexToGet = 3;
        Integer fromSut = sut.getAt(indexToGet);
        Integer fromTestSet = testSet.get(indexToGet);
        assertEquals(fromSut,fromTestSet);
    }

    @Test
    public void getSize() {
        assertEquals(expectedSize, sut.getSize());
    }

}