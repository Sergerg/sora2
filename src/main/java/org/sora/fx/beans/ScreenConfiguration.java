package org.sora.fx.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(MainScreenConfiguration.class);

    @Bean
    @Qualifier("form")
    @Scope("prototype")
    public FormInterface form(String name) {
        return new DefaultFormBean(name, name);
    }


}
