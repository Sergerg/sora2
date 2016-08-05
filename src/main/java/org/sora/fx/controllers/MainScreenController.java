package org.sora.fx.controllers;

import org.sora.fx.beans.MainScreenConfiguration;
import javafx.fxml.Initializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    public MainScreenController() {
        log.debug("MainScreenController()");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.debug("initialize() ");
    }

    public void showErrorDialog() {
        log.debug("showErrorDialog() ");
    }

    public void test() {
        log.debug("test() ");
    }
}
