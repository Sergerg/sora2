package org.sora.fx.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 12.08.2016
 * Time: 14:56
 */
public class ErrorController extends AbstractController {

    private static final Logger log = LoggerFactory.getLogger(ErrorController.class);

    @FXML
    Button btn;

    @FXML
    TextArea txtText;

    @FXML
    public void cancel() {
        //dialog.cancel();
        // TODO!!!
        ((Stage)btn.getScene().getWindow()).close();
    }
}
