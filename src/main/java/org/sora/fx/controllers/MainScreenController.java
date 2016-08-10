package org.sora.fx.controllers;

import javafx.fxml.Initializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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

    @Autowired
    private ContactService contactService;

    public MainScreenController() {
        log.debug("MainScreenController()");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.debug("initialize() ");
        log.info("size of contacts = " + contactService);
    }

    public void showErrorDialog() {
        log.debug("showErrorDialog() ");
    }

    public void test() {
        log.debug("test() ");
    }
}
