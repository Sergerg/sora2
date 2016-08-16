package org.sora.fx.controllers;

import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.sora.fx.beans.SceneInterface;
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
            SceneInterface sceneInterface = screenConfiguration.form("login");

            Stage stage = new Stage();
            Scene scene = sceneInterface.getScene();
            stage.setScene(scene);
            stage.setTitle("Login");
            // TODO: make modal
            // !!! stage.initOwner(scene.getWindow());
            stage.initModality(Modality.NONE); // !!!
            stage.setResizable(true);
            stage.show();
        }

    }

    public void showErrorDialog() {
        log.debug("showErrorDialog() ");

        // TODO: move into specific class
        if (screenConfiguration != null) {
            SceneInterface sceneInterface = screenConfiguration.form("error");

            Stage stage = new Stage();
            stage.setScene(sceneInterface.getScene());
            stage.setTitle("Error");
            // TODO: make modal
            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();
        }

    }

    public void test() {
        log.debug("test() ");
    }
}
