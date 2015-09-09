import junit.framework.TestCase;

public class TestCalculator2 extends TestCase {
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
        int result = c.add(2,2);
        assertEquals(4, result, 0);
    }
}
