package com.infinity.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.infinity.Calculator;

public class CalculatorTest 
{
    private Calculator cal;

    @BeforeEach
    public void setUp() 
    {
        cal = new Calculator();
    }

    @Test
    public void testAdd() 
    {
        assertEquals(15, cal.add(7, 8), "The addition of 7 and 8 should be 15");
    }

    @Test
    public void testDiff()
    {
        assertEquals(5, cal.diff(12, 7), "The difference between 12 and 7 should be 5");
    }
    
  
}