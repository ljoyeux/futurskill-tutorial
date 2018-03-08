package fr.futurskill.tutorial.jpa.rs;

import fr.futurskill.tutorial.jpa.bo.ModuleBean;
import fr.futurskill.tutorial.jpa.model.Module;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/module")
public class ModuleService {

    @Inject
    ModuleBean moduleBean;

    /*
        ATTENTION : Il faut renseigner tous les noms des paramètres (@QueryParam())
     */

    @Path("/creer")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Module creer(@QueryParam("titre") String titre, @QueryParam("description") String description) {
        return moduleBean.creer(titre, description);
    }

    @Path("/liste")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Module> liste(@QueryParam("active") @DefaultValue("true") Boolean listeActive) {
        return listeActive ? moduleBean.listeActif() : moduleBean.listeInactif();
    }

    @Path("/modifie")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Module modifie(@QueryParam("id") Long id, @QueryParam("titre") String titre, @QueryParam("description") String description) {
        return moduleBean.modifie(id, titre, description);
    }

    @Path("/active")
    @GET
    public void active(@QueryParam("id") Long id) {
        moduleBean.activeModule(id, true);
    }

    @Path("/desactive")
    @GET
    public void desactive(@QueryParam("id") Long id) {
        moduleBean.activeModule(id, false);
    }

}
