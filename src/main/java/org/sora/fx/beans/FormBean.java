package org.sora.fx.beans;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 12.08.2016
 * Time: 14:25
 */
public class FormBean implements FormInterface {

    private static final Logger log = LoggerFactory.getLogger(MainScreenConfiguration.class);

    private String viewName;
    private String resourceName;

    public FormBean(String viewName, String mainResource) {
        this.viewName = viewName;
        this.resourceName = mainResource;
    }

    @Autowired
    AppGuiConfiguration appGuiConfiguration;

    @Override
    public String getView() {
        return viewName;
    }

    @Override
    public String getResource() {
        return resourceName;
    }

    @Override
    public Scene getScene() {
        log.info("MainFormBean getParent");
        try {
            URL fxmlUrl = getClass().getResource(appGuiConfiguration.nameFxmlConverter(getView()));
            FXMLLoader loader = new FXMLLoader(fxmlUrl, ResourceBundle.getBundle(getResource())); // Может как-то по-умолчанию из spring?
//            loader.setControllerFactory(aClass -> controller());
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
