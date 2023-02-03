package com.example.jetbrainsaquareview;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UnitTestTest {

    @BeforeMethod
    public void setUp() {
    }

    @AfterMethod
    public void tearDown() {
    }
    @Test
    public void add() {
        assertEquals(5,5);
    }
    // just a dummy method to see a passing unit test
}
