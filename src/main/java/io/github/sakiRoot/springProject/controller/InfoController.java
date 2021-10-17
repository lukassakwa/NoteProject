package io.github.sakiRoot.springProject.controller;

import io.github.sakiRoot.springProject.configuration.properties.TaskConfigurationProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class InfoController{
    //Mozna wykorzystac te klasy do przypisania zmiennym wartosci z application.properties
    //W metodach tej klasy zwracamy wartosci pliku application.properties
    private final DataSourceProperties dataSourceProperties;
    private final TaskConfigurationProperties taskConfigurationProperties;

    @Autowired
    InfoController(DataSourceProperties dataSourceProperties, TaskConfigurationProperties taskConfigurationProperties) {
        this.dataSourceProperties = dataSourceProperties;
        this.taskConfigurationProperties = taskConfigurationProperties;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/info/url")
    public String getUrl(){
        return dataSourceProperties.getUrl();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/info/allowMultipleTasksFromTemplate")
    public boolean getAllowMultipleTasksFromTemplate(){
        return taskConfigurationProperties.getTemplateConfigurationProperties().isAllowMultipleTasks();
    }
}
