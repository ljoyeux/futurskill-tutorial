package fr.futurskill.tutorial.jpa.rs.config;

import fr.futurskill.tutorial.jpa.model.TicketAutoEvaluation;
import fr.futurskill.tutorial.jpa.rs.AutoEvaluationService;
import fr.futurskill.tutorial.jpa.rs.ModuleService;
import fr.futurskill.tutorial.jpa.rs.TicketsAutoEvaluationService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rs")
public class ApplicationConfig extends Application {


    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();

        classes.addAll(Arrays.asList(AutoEvaluationService.class, ModuleService.class, TicketsAutoEvaluationService.class));

        return super.getClasses();
    }
}
