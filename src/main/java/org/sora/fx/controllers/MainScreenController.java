package org.sora.fx.controllers;

import javafx.fxml.FXML;
import javafx.stage.Modality;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.sora.fx.beans.ScreenConfiguration;
import org.sora.fx.services.ContactService;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 03.09.2015
 * Time: 8:42
 */
public class MainScreenController extends AbstractController {

    private static final Logger log = LoggerFactory.getLogger(MainScreenController.class);

    private ScreenConfiguration screenConfiguration;

    private ContactService contactService;

//    @FXML
//    MenuBar menuBar;

    public MainScreenController(ScreenConfiguration screenConfiguration, ContactService contactService) {
        log.debug("MainScreenController()");
        this.contactService = contactService;
        this.screenConfiguration = screenConfiguration;
    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        log.debug("initialize() ");
        if (contactService != null) {
            contactService.loadData();
            log.info("size of contacts = " + contactService.getData().size());
        }
    }

    public void showErrorDialog() {
        log.debug("showErrorDialog() ");

        if (screenConfiguration != null) {
            screenConfiguration.dialog("Error", "error", Modality.APPLICATION_MODAL, false);
        }

    }

    public void test() {
        log.debug("test() ");

        if (screenConfiguration != null) {
            screenConfiguration.dialog("Login", "login", Modality.APPLICATION_MODAL, false);
        }
    }
}
