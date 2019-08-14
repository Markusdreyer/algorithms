package org.pg4200.ex01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.pg4200.ex01.TriangleClassification.Classification.EQUILATERAL;
import static org.pg4200.ex01.TriangleClassification.Classification.ISOSCELES;
import static org.pg4200.ex01.TriangleClassification.Classification.NOT_A_TRIANGLE;

public class TriangleClassificationTest {

    private TriangleClassification triangle = new TriangleClassification();

    @Test
    public void testNotATriangle() {
        assertEquals(NOT_A_TRIANGLE, triangle.classify(-1, -1, -1));
        assertEquals(NOT_A_TRIANGLE, triangle.classify(1, 1, 2));
    }

    @Test
    public void testEquilateralTriangle() {
        assertEquals(EQUILATERAL, triangle.classify(1, 1, 1));
    }
}
