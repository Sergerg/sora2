package org.sora.fx;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sora.fx.entity.Contact;
import org.sora.fx.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 10.08.2016
 * Time: 8:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestContacts {

    private static final Logger log = LoggerFactory.getLogger(TestContacts.class);

    @Autowired
    private ContactService contactService;

    @Test
    public void testAdd() throws Exception {
        log.info("testAdd");
        Contact contact1 = new Contact("a", "b", "c", "d");
        contactService.addContact(contact1);
        Contact contact2 = contactService.get("a");
        assertNotNull(contact2);
//        log.info(contact1.toString());
//        log.info(contact2.toString());
        assertEquals("Error", contact1, contact2);
        assertTrue("Error", contact1.equals(contact2));
    }

}