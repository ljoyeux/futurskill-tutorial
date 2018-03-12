package fr.futurskill.tutorial.jpa.rs.config;

import fr.futurskill.tutorial.jpa.rs.AutoEvaluationService;
import fr.futurskill.tutorial.jpa.rs.ModuleCalendrierService;
import fr.futurskill.tutorial.jpa.rs.ModuleService;
import fr.futurskill.tutorial.jpa.rs.TicketsAutoEvaluationService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rs")
public class ApplicationConfig extends Application {


    @Override
    public Set<Class<?>> getClasses() {
        return  new HashSet<>(Arrays.asList(AutoEvaluationService.class, ModuleService.class, TicketsAutoEvaluationService.class, ModuleCalendrierService.class));
    }
}
