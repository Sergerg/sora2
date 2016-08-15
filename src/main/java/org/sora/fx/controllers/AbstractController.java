package org.sora.fx.controllers;

import javafx.fxml.Initializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 15.08.2016
 * Time: 9:46
 */
public class AbstractController implements Initializable {

    private static final Logger log = LoggerFactory.getLogger(AbstractController.class);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.debug("initialize");
    }
}
