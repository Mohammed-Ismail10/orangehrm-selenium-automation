package org.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyTest {

    @Test
    public void firstTest() {

        System.out.println("First Test");

        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "firstTest")
    public void secondTest() {

        System.out.println("Second Test");

        Assert.assertTrue(true);
    }
}