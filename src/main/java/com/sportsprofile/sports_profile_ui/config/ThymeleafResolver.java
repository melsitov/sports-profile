package com.sportsprofile.sports_profile_ui.config;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.FileTemplateResolver;
import lombok.val;

@Configuration
public class ThymeleafResolver {

    @Autowired
    private SpringTemplateEngine templateEngine;

    @PostConstruct
    public void extension() {
        val resolver = new FileTemplateResolver();
        resolver.setPrefix("src/main/resources/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setOrder(templateEngine.getTemplateResolvers().size());
        resolver.setCacheable(false);
        resolver.setCharacterEncoding("UTF-8");
        templateEngine.addTemplateResolver(resolver);
    }
}