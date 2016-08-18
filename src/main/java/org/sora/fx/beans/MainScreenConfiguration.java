package org.sora.fx.beans;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.io.IOException;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 04.08.2016
 * Time: 9:37
 */
@Configuration
@Lazy
public class MainScreenConfiguration {

    private static final Logger log = LoggerFactory.getLogger(MainScreenConfiguration.class);

    @Value("${ui.main.viewName:main}")
    private String mainView;

    @Value("${ui.main.title:JavaFX приложение}")
    private String windowTitle;

    @Value("${spring.messages.basename}") // Явно брать из настроек Spring!
    private String mainResource;

    @Bean
    @Qualifier("mainForm")
    public SceneInterface mainForm() {
        return new MainSceneBean(mainView, mainResource);
    }

    @Autowired
    ScreenConfiguration screenConfiguration;

    public void initMainScreen(Stage primaryStage) throws IOException {
        log.debug("ScreensConfiguration initMainScreen");

        Scene scene = mainForm().getScene();

        primaryStage.setOnCloseRequest(event -> {
            log.info("primaryStage.setOnCloseRequest");

            ResourceBundle lngBndl = ResourceBundle.getBundle(mainResource);
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            try {
                a.setTitle(lngBndl.getString("exitconfirmation.title"));
                a.setHeaderText(lngBndl.getString("exitconfirmation.text"));
            } catch (MissingResourceException e) {
                log.warn("Resource not found: " + e.getMessage());
                a.setTitle("Confirmation");
                a.setHeaderText("Do you really want to leave?");
            }
            a.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    Platform.exit();
                } else {
                    event.consume();
                }
            });
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle(windowTitle);
        primaryStage.show();

//        if (screenConfiguration != null) {
//            screenConfiguration.dialog("Login", "login", Modality.APPLICATION_MODAL, false);
//        }

    }

}
