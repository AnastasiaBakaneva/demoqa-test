import org.junit.jupiter.api.*;


public class SimpleJUnitTest {

    int result;

    @BeforeAll
    static void beforeAll() {
        System.out.println("\n****     beforeAll\n");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("\n**  beforeEach");
        result = getRusult();
    }

    @AfterEach
    void afterEach() {
        System.out.println("**  afterEach");
        result = 0;
    }

    @AfterAll
    static void afterAll() {
        System.out.println("\n ***   afterAll\n");
    }

    @Test
    void firstTest() {
        int result = getRusult();
        System.out.println("***   firstTest()");
        Assertions.assertTrue(result > 2);
    }


    @Test
    void secondTest() {
        int result = getRusult();
        System.out.println("***   secondTest()");
        Assertions.assertTrue(result > 2);
    }
    @Test
    void thirdTest() {
        int result = getRusult();
        System.out.println("***   thirdTest()");
        Assertions.assertTrue(result> 2);
    }
    private int getRusult() {
        return 3;
    }
}
