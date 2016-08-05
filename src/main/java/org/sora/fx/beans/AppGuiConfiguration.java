package org.sora.fx.beans;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Created with IntelliJ IDEA.
 * User: Serger
 * Date: 05.08.2016
 * Time: 19:03
 */
@Configuration
@Lazy
public class AppGuiConfiguration {

    public String nameCssConverter(String part) {
        return "/css/"+part+".css";
    }

    public String nameFxmlConverter(String part) {
        return "/fxml/"+part+".fxml";
    }

}
