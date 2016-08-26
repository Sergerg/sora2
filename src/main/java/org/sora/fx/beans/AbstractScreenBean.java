package org.sora.fx.beans;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 26.08.2016
 * Time: 9:03
 */
abstract public class AbstractScreenBean implements ScreenBean {

    private static final Logger log = LoggerFactory.getLogger(AbstractScreenBean.class);

    private String windowTitle;
    private String mainResource;
    private String nameForm;
    private Stage stage;

    @Autowired
    AppGuiConfiguration appGuiConfiguration;

    @Override
    public String getWindowTitle() {
        return windowTitle;
    }

    @Override
    public void setWindowTitle(String title) {
        windowTitle = title;
    }

    @Override
    public String getMainResource() {
        return mainResource;
    }

    @Override
    public void setMainResource(String mainResource) {
        this.mainResource = mainResource;
    }

    @Override
    public String getNameForm() {
        return nameForm;
    }

    @Override
    public void setNameForm(String nameForm) {
        this.nameForm = nameForm;
    }

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() { return stage; }

    @Override
    public void show() {
        Scene scene;
        try {
            URL fxmlUrl = getClass().getResource(appGuiConfiguration.nameFxmlConverter(getNameForm()));
            FXMLLoader loader = new FXMLLoader(fxmlUrl, ResourceBundle.getBundle(getMainResource()));
            loader.setControllerFactory(aClass -> getController());
            Parent view = loader.load();

            scene = new Scene(view);
            scene.getStylesheets()
                    .add(getClass()
                    .getResource(appGuiConfiguration.nameCssConverter(getNameForm()))
                    .toExternalForm());
        } catch (IOException e) {
            log.error("Can't load resource", e);
            throw new RuntimeException(e);
        }

        stage.setTitle(getWindowTitle());
        if (scene != null)
            stage.setScene(scene);
        stage.show();
    }
}
