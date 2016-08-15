package org.sora.fx.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.sora.fx.beans.FormInterface;
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
public class MainScreenController implements Initializable {

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.debug("initialize() ");
        if (contactService != null) {
            contactService.loadData();
            log.info("size of contacts = " + contactService.getData().size());
        }

        // TODO: afterload
        // TODO: move into specific class
        if (screenConfiguration != null) {
            FormInterface formInterface = screenConfiguration.form("login");

            Stage stage = new Stage();
            stage.setScene(formInterface.getScene());
            stage.setTitle("Login");
            //stage.initOwner(((Stage)menuBar.getScene().getWindow()));
            stage.initModality(Modality.NONE); // !!!
            stage.show();
        }

    }

    public void showErrorDialog() {
        log.debug("showErrorDialog() ");

        // TODO: move into specific class
        if (screenConfiguration != null) {
            FormInterface formInterface = screenConfiguration.form("error");

            Stage stage = new Stage();
            stage.setScene(formInterface.getScene());
            stage.setTitle("Error");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();
        }

    }

    public void test() {
        log.debug("test() ");
    }
}
