package org.sora.fx.beans;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sora.fx.controllers.MainScreenController;
import org.sora.fx.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class MainSceneBean implements SceneInterface {

    private static final Logger log = LoggerFactory.getLogger(MainScreenConfiguration.class);

    private String mainView;
    private String mainResource;

    public MainSceneBean(String mainView, String mainResource) {
        this.mainView = mainView;
        this.mainResource = mainResource;
    }

    @Autowired
    private AppGuiConfiguration appGuiConfiguration;

    @Autowired
    private ScreenConfiguration screenConfiguration;

    @Autowired
    @Qualifier("contactService")
    ContactService contactService;

    @Bean
    MainScreenController controller() {
        return new MainScreenController(screenConfiguration, contactService);
    }

    @Override
    public String getView() {
        return mainView;
    }

    @Override
    public String getResource() {
        return mainResource;
    }

    @Override
    public Scene getScene() {
        log.info("MainSceneBean getParent");
        try {
            URL fxmlUrl = getClass().getResource(appGuiConfiguration.nameFxmlConverter(getView()));
            FXMLLoader loader = new FXMLLoader(fxmlUrl, ResourceBundle.getBundle(getResource())); // Может как-то по-умолчанию из spring?
            loader.setControllerFactory(aClass -> controller());
            Parent view = loader.load();

            Scene scene = new Scene(view);
            scene.getStylesheets().add(getClass().getResource(
                    appGuiConfiguration.nameCssConverter(getView())).toExternalForm());

            return scene;
        } catch (IOException e) {
            log.error("Can't load resource", e);
            throw new RuntimeException(e);
        }
    }

}
