package org.sora.fx.beans;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sora.fx.controllers.MainScreenController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 05.08.2016
 * Time: 18:33
 */
public class MainForm {

    private static final Logger log = LoggerFactory.getLogger(MainScreenConfiguration.class);

    private String mainView;
    private String windowTitle;
    private String mainResource;

    public MainForm(String mainView, String windowTitle, String mainResource) {
        this.mainView = mainView;
        this.windowTitle = windowTitle;
        this.mainResource = mainResource;
    }

    @Autowired
    AppGuiConfiguration appGuiConfiguration;

    @Bean
    MainScreenController controller() {
        return new MainScreenController();
    }

    public Scene getScene() {
        log.info("MainForm getParent");
        try {
            URL fxmlUrl = getClass().getResource(appGuiConfiguration.nameFxmlConverter(mainView));
            FXMLLoader loader = new FXMLLoader(fxmlUrl, ResourceBundle.getBundle(mainResource)); // Может как-то по-умолчанию из spring?
            loader.setControllerFactory(aClass -> controller());
            Parent view = loader.load();

            Scene scene = new Scene(view);
            scene.getStylesheets().add(getClass().getResource(
                    appGuiConfiguration.nameCssConverter(mainView)).toExternalForm());

            return scene;
        } catch (IOException e) {
            log.error("Can't load resource", e);
            throw new RuntimeException(e);
        }
    }

}
