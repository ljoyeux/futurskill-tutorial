package fr.futurskill.tutorial.jpa.rs;

import fr.futurskill.tutorial.jpa.bo.TicketAutoEvaluationBean;
import fr.futurskill.tutorial.jpa.model.TicketAutoEvaluation;

import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/tickets")
public class TicketsAutoEvaluationService {

    @Inject
    TicketAutoEvaluationBean ticketAutoEvaluationBean;

    @Path("/creer")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public TicketAutoEvaluation creer(String nom, Integer nombreTickets, @DefaultValue("2") Integer nbJours, Long moduleCalendrierId) {
        return ticketAutoEvaluationBean.ajoute(nom, nombreTickets, nbJours, moduleCalendrierId);
    }

}
