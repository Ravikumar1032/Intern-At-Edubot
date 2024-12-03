package com.example;

import static org.junit.Assert.*;
import org.junit.Test;

public class AppTest {

    @Test
    public void testEquality() {
        String str1 = "hello";
        String str2 = "hello";
        assertEquals(str1, str2);
    }

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testTrueAssertion() {
        assertTrue(true);
    }

    @Test
    public void testFalseAssertion() {
        assertFalse(false);
    }

    @Test
    public void testNullAssertion() {
        Object obj = null;
        assertNull(obj);
    }

    @Test
    public void testNotNullAssertion() {
        Object obj = new Object();
        assertNotNull(obj);
    }

    @Test
    public void testInequality() {
        String str1 = "hello";
        String str2 = "world";
        assertNotEquals(str1, str2);
    }

    @Test(timeout = 100)
    public void testTimeout() {
        // Test that should execute within 100 milliseconds
        assertTrue(true);
    }

    @Test(expected = ArithmeticException.class)
    public void testExceptionThrown() {
        int result = 1 / 0; // This should throw ArithmeticException
    }

    @Test
    public void testArrayEquality() {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        assertArrayEquals(arr1, arr2);
    }

    @Test
    public void testBooleanTrue() {
        boolean condition = (5 > 1);
        assertTrue(condition);
    }

    @Test
    public void testBooleanFalse() {
        boolean condition = (1 > 5);
        assertFalse(condition);
    }

    @Test
    public void testSameObject() {
        Object obj1 = new Object();
        Object obj2 = obj1;
        assertSame(obj1, obj2);
    }

    @Test
    public void testNotSameObject() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        assertNotSame(obj1, obj2);
    }

    @Test
    public void testStringContains() {
        String str = "hello world";
        assertTrue(str.contains("world"));
    }

    @Test
    public void testStringStartsWith() {
        String str = "hello world";
        assertTrue(str.startsWith("hello"));
    }

    @Test
    public void testStringEndsWith() {
        String str = "hello world";
        assertTrue(str.endsWith("world"));
    }

    @Test
    public void testStringLength() {
        String str = "hello";
        assertEquals(5, str.length());
    }

    @Test
    public void testObjectEqualityWithEqualsMethod() {
        String str1 = new String("hello");
        String str2 = new String("hello");
        assertTrue(str1.equals(str2));
    }
}
