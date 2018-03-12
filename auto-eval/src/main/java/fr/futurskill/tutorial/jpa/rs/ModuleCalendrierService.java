package fr.futurskill.tutorial.jpa.rs;

import fr.futurskill.tutorial.jpa.bo.ModuleCalendrierBean;
import fr.futurskill.tutorial.jpa.model.ModuleCalendrier;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Path("/calendrier")
public class ModuleCalendrierService {

    @Inject
    private ModuleCalendrierBean moduleCalendrierBean;

    private static final String DATE_FORMAT = "dd/MM/yyyy";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);

    @Path("/creer")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public ModuleCalendrier creer(@QueryParam("moduleId") Long moduleId, @QueryParam("debut") String debut, @QueryParam("fin") String fin) {
        try {
            return moduleCalendrierBean.ajoute(moduleId,  dateFormat.parse(debut),  dateFormat.parse(fin));
        } catch (ParseException ex) {
            return null;
        }
    }


    @Path("/liste")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<ModuleCalendrier> liste(@QueryParam("debut") String debut, @QueryParam("fin") String fin) {
        try {
            return moduleCalendrierBean.liste( (debut!=null) ? dateFormat.parse(debut) : null, (fin!=null) ? dateFormat.parse(fin) : null);
        } catch (ParseException ex) {
            return null;
        }
    }

    @Path("/supprime")
    @GET
    @SuppressWarnings("VoidMethodAnnotatedWithGET")
    public void supprime(@QueryParam("moduleCalendrirerId") Long moduleCalendrirerId) {
        moduleCalendrierBean.supprime(moduleCalendrirerId);
    }
}
