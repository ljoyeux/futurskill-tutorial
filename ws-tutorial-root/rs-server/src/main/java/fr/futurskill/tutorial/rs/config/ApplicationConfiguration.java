package fr.futurskill.tutorial.rs.config;

import fr.futurskill.tutorial.rs.ImageService;
import fr.futurskill.tutorial.rs.SimpleService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

@ApplicationPath("/rs")
public class ApplicationConfiguration extends Application 
{

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(SimpleService.class);
        resources.add(ImageService.class);
    }

}
