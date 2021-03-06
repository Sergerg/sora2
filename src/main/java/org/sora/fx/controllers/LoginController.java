package org.sora.fx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 15.08.2016
 * Time: 9:10
 */
public class LoginController extends AbstractController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @FXML
    Button btnOk;

    public void cancel(ActionEvent actionEvent) {
        log.debug("cancel");
        // TODO!!!
        ((Stage)btnOk.getScene().getWindow()).close();
    }

    public void ok(ActionEvent actionEvent) {
        log.debug("ok");
        // TODO!!!
        ((Stage)btnOk.getScene().getWindow()).close();
    }

}
