package fr.futurskill.tutorial.jpa.rs;

import fr.futurskill.tutorial.jpa.bo.AutoEvaluationBean;
import fr.futurskill.tutorial.jpa.model.AutoEvaluation;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/auto-eval")
public class AutoEvaluationService {

    @Inject
    AutoEvaluationBean autoEvaluationBean;

    @Path("/modifie")
    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public AutoEvaluation modifie(AutoEvaluation ae) {
        return autoEvaluationBean.modifie(ae);
    }

    @Path("liste")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<AutoEvaluation> liste(String nomTicket, Long moduleCalendrierId) {
        if(nomTicket!=null) {
            return autoEvaluationBean.listeParNomTicket(nomTicket);
        }

        if(moduleCalendrierId!=null) {
            return autoEvaluationBean.listeParCalendrierModule(moduleCalendrierId);
        }

        return null;
    }
}
