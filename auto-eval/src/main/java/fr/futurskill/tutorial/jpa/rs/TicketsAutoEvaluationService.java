package fr.futurskill.tutorial.jpa.rs;

import fr.futurskill.tutorial.jpa.bo.TicketAutoEvaluationBean;
import fr.futurskill.tutorial.jpa.model.TicketAutoEvaluation;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/tickets")
public class TicketsAutoEvaluationService {

    @Inject
    private TicketAutoEvaluationBean ticketAutoEvaluationBean;

    @Path("/creer")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public TicketAutoEvaluation creer(@QueryParam("nom") String nom, @QueryParam("nombreTickets") Integer nombreTickets, @QueryParam("nbJours") @DefaultValue("2") Integer nbJours, @QueryParam("moduleCalendrierId") Long moduleCalendrierId) {
        return ticketAutoEvaluationBean.ajoute(nom, nombreTickets, nbJours, moduleCalendrierId);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public TicketAutoEvaluation creer(@QueryParam("ticketAutoEvaluationId") Long ticketAutoEvaluationId) {
        return ticketAutoEvaluationBean.get(ticketAutoEvaluationId);
    }
}
