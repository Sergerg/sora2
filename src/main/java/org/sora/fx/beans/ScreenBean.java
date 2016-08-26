package org.sora.fx.beans;

import javafx.stage.Stage;
import org.sora.fx.controllers.AbstractController;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 26.08.2016
 * Time: 8:58
 */
public interface ScreenBean {

    String getWindowTitle();
    void setWindowTitle(String title);
    String getMainResource();
    void setMainResource(String mainResource);
    String getNameForm();
    void setNameForm(String nameForm);
    void setStage(Stage stage);
    Stage getStage();
    AbstractController getController();

    void show();

}
