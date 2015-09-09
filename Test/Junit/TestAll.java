
import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class TestAll extends TestSuite {
    public static Test suite(){
        TestSuite suite = new TestSuite("TestSuite");
        suite.addTestSuite(TestCalculator1.class);
        suite.addTestSuite(TestCalculator2.class);
        return suite;
    }

    public static void main(String[] args) {
        TestRunner.run(suite());
    }
}
