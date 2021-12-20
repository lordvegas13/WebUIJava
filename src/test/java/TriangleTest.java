import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;


public class TriangleTest {
    private static  Logger logger=(Logger) LoggerFactory.getLogger(TriangleTest.class);

    @DisplayName("Площадь треугольника по трём сторонам")
    @Test
    public void testSquareTriangle() throws TriangleException {
        System.out.println(Triangle.squareTriangle(10, 5, 10));
        assertEquals(Triangle.squareTriangle(10, 5,10), Triangle.squareTriangle(10, 5, 10));


    }

    @DisplayName("Площадь треугольника по трём сторонам c недопустимым значением")
    @Test
    public void testSquareTriangleNegative () throws TriangleException {
        try{
            Triangle.squareTriangle(10, 20, 500);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }}



    @DisplayName("Является ли фигура треугольником + площадь")
    @Test
    public void getTriangleTest() throws TriangleException {
        assertTrue(Triangle.isTriangle(5, 5, 6));
    }

    @DisplayName("Является ли фигура треугольником + площадь(с недопустимым значением)")
    @Test
    public void getTriangleTestNegative() throws TriangleException {
        try{
            Triangle.isTriangle(-5, 5, 6);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    @DisplayName("Вид треугольника")
    @Test
    public void getTriangleTest2() throws TriangleException {
        assertTrue(Triangle.isTriangle2(9, 10, 11));

    }
}
