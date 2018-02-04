package com.ionivation.libs.system;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testklasse fuer GetAppPath aus dem Paket com.ionivation.libs.system;
 * @author Adam Jaquet
 */
public class GetAppPathTest
{
    private GetAppPath instance;
            
    public GetAppPathTest()
    {
        // TODO:
    }
    
    @BeforeClass
    public static void setUpClass()
    {
        // TODO:
    }
    
    @AfterClass
    public static void tearDownClass()
    {
        // TODO:
    }
    
    @Before
    public void setUp()
    {
        instance = new GetAppPath();
    }
    
    @After
    public void tearDown()
    {
        instance = null;
    }

    /**
     * Test of getCurrentJarPath method, of class GetAppPath.
     */
    @Test
    public void testGetCurrentJarPath()
    {
        System.out.println("getCurrentJarPath");
    }

    /**
     * Test of getJarPath method, of class GetAppPath.
     */
    @Test
    public void testGetJarPath()
    {
        System.out.println("getJarPath");
    }

    /**
     * Test of toString method, of class GetAppPath.
     */
    @Test
    public void testToString()
    {
        System.out.println("toString");
    }    
}
