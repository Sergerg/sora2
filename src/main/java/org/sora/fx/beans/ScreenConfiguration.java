package org.sora.fx.beans;

import javafx.scene.Scene;
import javafx.stage.Modality;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sora.fx.dialogs.BasicDialog;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 12.08.2016
 * Time: 14:38
 */
@Configuration
@Lazy
public class ScreenConfiguration {

    private static final Logger log = LoggerFactory.getLogger(ScreenConfiguration.class);

    @Bean
    @Qualifier("form")
    @Scope("prototype")
    public SceneInterface form(String name) {
        return new DefaultSceneBean(name, name);
    }

    @Bean
    @Qualifier("dialog")
    @Scope("prototype")
    public BasicDialog dialog(String title, String dialogName, Modality modal, boolean resizable) {
        SceneInterface sceneInterface = form(dialogName);

        BasicDialog stage = new BasicDialog();
        Scene scene = sceneInterface.getScene();
        stage.setScene(scene);
        stage.setTitle(title);
//            stage.initOwner(scene.getWindow());
        stage.initModality(modal);
        stage.setResizable(resizable);
        stage.show();
        return stage;
    }
}
