import junit.framework.TestCase;

public class TestCalculator1 extends TestCase {
    Calculator c = new Calculator();

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        c.setA(2);
        c.setB(1);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        c = null;
    }

    public void testAdd(){
        int result = c.add(1,2);
        assertEquals(3, result, 0);
    }
}
