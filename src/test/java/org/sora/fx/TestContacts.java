package org.sora.fx;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sora.fx.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 10.08.2016
 * Time: 8:55
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class TestContacts {// extends Application {
    @Autowired
    private ContactService contactService;

    @Before
    public void setUp() throws Exception {
        contactService.loadData();
        System.out.println("before test");
    }

    @Test
    public void testInitShema() throws Exception {
        System.out.println("test");
        assertEquals(contactService.getData().size(), 1);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("after test");
    }

}