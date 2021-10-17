package io.github.sakiRoot.springProject.configuration.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

//Wstrzykiwanie wartosci z drzewka task w application.yml
@Configuration //-> przed wersja 2.2 ta adnotacja musi wystepowac zeby zadzialalo
@ConfigurationProperties(prefix = "task")
public class TaskConfigurationProperties {
    private TemplateConfigurationProperties templateConfigurationProperties;

    @Autowired
    public TaskConfigurationProperties(TemplateConfigurationProperties templateConfigurationProperties) {
        this.templateConfigurationProperties = templateConfigurationProperties;
    }

    public TemplateConfigurationProperties getTemplateConfigurationProperties() {
        return templateConfigurationProperties;
    }

    public void setTemplateConfigurationProperties(TemplateConfigurationProperties templateConfigurationProperties) {
        this.templateConfigurationProperties = templateConfigurationProperties;
    }

}
