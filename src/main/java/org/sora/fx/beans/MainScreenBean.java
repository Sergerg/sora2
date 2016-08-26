package org.sora.fx.beans;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sora.fx.controllers.MainScreenController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 25.08.2016
 * Time: 14:20
 */
@Configuration
@Lazy
public class MainScreenBean {

    private static final Logger log = LoggerFactory.getLogger(MainScreenBean.class);

    @Value("${ui.main.title:JavaFX application}")
    private String windowTitle;

    @Value("${spring.messages.basename}") // Явно брать из настроек Spring!
    private String mainResource;

    @Value("main")
    private String nameForm;

    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Autowired
    AppGuiConfiguration appGuiConfiguration;

    @Bean
    MainScreenController getController() {
        return new MainScreenController();
    }

    public void show() {
        Scene scene;
        try {
            URL fxmlUrl = getClass().getResource(appGuiConfiguration.nameFxmlConverter(nameForm));
            FXMLLoader loader = new FXMLLoader(fxmlUrl, ResourceBundle.getBundle(mainResource));
            loader.setControllerFactory(aClass -> getController());
            Parent view = loader.load();

            scene = new Scene(view);
            scene.getStylesheets().add(getClass().getResource(appGuiConfiguration.nameCssConverter(nameForm)).toExternalForm());
        } catch (IOException e) {
            log.error("Can't load resource", e);
            throw new RuntimeException(e);
        }

        primaryStage.setTitle(windowTitle);
        if (scene != null)
            primaryStage.setScene(scene);
        primaryStage.show();
    }
}
