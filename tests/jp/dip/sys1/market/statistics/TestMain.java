package jp.dip.sys1.market.statistics;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMain {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        try{
            Main.main(null);
        }catch(Exception e){
            e.printStackTrace();
            fail(e.getMessage());
        }
    }   
}
