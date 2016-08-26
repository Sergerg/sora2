package org.sora.fx.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sora.fx.controllers.AbstractController;
import org.sora.fx.controllers.MainScreenController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 25.08.2016
 * Time: 14:20
 */
@Component("mainScreenBean")
@Lazy
public class MainScreenBean extends AbstractScreenBean {

    private static final Logger log = LoggerFactory.getLogger(MainScreenBean.class);

    public MainScreenBean(
            @Value("${ui.main.title:JavaFX application}") String windowTitle,
            @Value("${spring.messages.basename}") String mainResource,
            @Value("main") String nameForm
    ) {
        setWindowTitle(windowTitle);
        setMainResource(mainResource);
        setNameForm(nameForm);
    }

    @Bean
    public AbstractController getController() {
        AbstractController abstractController = new MainScreenController();
        log.debug("getController = " + abstractController);
        return abstractController;
    }

}
