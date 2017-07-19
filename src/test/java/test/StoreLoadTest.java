package test;

import livestore.StoreLoader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StoreLoadTest {
     StoreLoader storeLoader;
    @Before
    public void setUp() {
        storeLoader = new StoreLoader("mydb1", "root", "password");
    }
    
    @Test
    public void testGetItem() {
        Assert.assertEquals(1, storeLoader.getItem(1).getId());
    }
    
    @Test
    public void testGetItems() {
        Assert.assertEquals(3, storeLoader.getItems().size());
    }
}
