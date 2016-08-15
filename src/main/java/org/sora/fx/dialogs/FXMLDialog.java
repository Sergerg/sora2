package org.sora.fx.dialogs;

//import org.sora.fx.controllers.DialogController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 03.09.2015
 * Time: 8:34
 */
// TODO: Make
public class FXMLDialog extends Stage {

    private static final Logger log = LoggerFactory.getLogger(FXMLDialog.class);

    public FXMLDialog() {
        super();
        // for manual form - Autowired!
    }
/*
    public FXMLDialog(String mainResource, DialogController controller, String name, Window owner) {
        this(mainResource, controller, name, owner, Modality.WINDOW_MODAL, StageStyle.DECORATED, false);
    }

    public FXMLDialog(String mainResource, DialogController controller, String name, Window owner, StageStyle style) {
        this(mainResource, controller, name, owner, Modality.WINDOW_MODAL, style, false);
    }

    public FXMLDialog(String mainResource, DialogController controller, String name, Window owner, Modality modality) {
        this(mainResource, controller, name, owner, modality, StageStyle.DECORATED, true);
    }

    public FXMLDialog(String mainResource, final DialogController controller, String name, Window owner, Modality modality, StageStyle style, boolean resizable) {
        super(style);
        log.debug("FXMLDialog");

        URL fxml = getClass().getResource("/fxml/"+name+".fxml");
        URL css = getClass().getResource("/css/" + name + ".css");
        log.debug("FXMLDialog.css = " + css);
        initOwner(owner);
        initModality(modality);
        setResizable(resizable);
        ResourceBundle bundle = null;
        try {
            bundle = ResourceBundle.getBundle(name);
        } catch (MissingResourceException e) {
            log.info("Resource not found: " + e.getMessage());
            log.info("Try found global resources: " + mainResource);
            bundle = ResourceBundle.getBundle(mainResource);
        }
        FXMLLoader loader = new FXMLLoader(fxml, bundle);
        try {
            loader.setControllerFactory(aClass -> controller);
            controller.setDialog(this);
            Scene s = new Scene(loader.load());
            if (css != null) {
                s.getStylesheets().add(css.toExternalForm());
            }
            setScene(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    */
}
