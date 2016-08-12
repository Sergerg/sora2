package org.sora.fx.controllers;

import javafx.fxml.Initializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.sora.fx.services.ContactService;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 03.09.2015
 * Time: 8:42
 */
public class MainScreenController implements Initializable {

    private static final Logger log = LoggerFactory.getLogger(MainScreenController.class);

    private ContactService contactService;

    public MainScreenController(ContactService contactService) {
        log.debug("MainScreenController()");
        this.contactService = contactService;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.debug("initialize() ");
        if (contactService != null) {
            contactService.loadData();
            log.info("size of contacts = " + contactService.getData().size());
        }
    }

    public void showErrorDialog() {
        log.debug("showErrorDialog() ");
    }

    public void test() {
        log.debug("test() ");
    }
}
