package org.sora.fx;

import javafx.stage.Stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.sora.fx.beans.MainScreenBean;
import org.sora.fx.beans.ScreenBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = "org.sora.fx.*")
public class Application extends javafx.application.Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    private static String[] args;

    // App start
    public static void main(String[] args) {
        log.debug("BEGIN main.");
        Application.args = args;

        launch(args);
        log.debug("END main.");
    }

    // Javafx runner?
    @Override
    public void start(Stage primaryStage) throws Exception {
        log.debug("BEGIN start.");
        // Start Spring container
        ApplicationContext context = SpringApplication.run(Application.class, args);
        log.debug("Spring context load ok.");

        // start JavaFX spring configuration
        ScreenBean mainScreenBean = context.getBean("mainScreenBean", ScreenBean.class);
        mainScreenBean.setStage(primaryStage);
        mainScreenBean.show();

        log.debug("END start.");
    }

}
