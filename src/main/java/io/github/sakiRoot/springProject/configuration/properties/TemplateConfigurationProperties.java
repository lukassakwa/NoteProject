package io.github.sakiRoot.springProject.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "template")
public class TemplateConfigurationProperties {
    private boolean allowMultipleTasks;

    public boolean isAllowMultipleTasks() {
        return allowMultipleTasks;
    }

    public void setAllowMultipleTasks(boolean allowMultipleTasks) {
        this.allowMultipleTasks = allowMultipleTasks;
    }
}
