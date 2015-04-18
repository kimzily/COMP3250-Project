package rentawheel.test;

public class TestSuite {
    public static void main(String[] args) {
        System.out.println("Starting Tests...");
        System.out.println("Testing Database Connection:");
        org.junit.runner.JUnitCore.main("rentawheel.test.DatabaseConnectionTest");
        
        System.out.println("Testing Employee Model:");
        org.junit.runner.JUnitCore.main("rentawheel.test.EmpployeeModelTest");
        
        System.out.println("Testing Member Model:");
        org.junit.runner.JUnitCore.main("rentawheel.test.MemberModelTest");

        System.out.println("Tests done.");
    }
}