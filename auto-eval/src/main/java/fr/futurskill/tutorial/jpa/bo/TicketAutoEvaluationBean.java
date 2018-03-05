package fr.futurskill.tutorial.jpa.bo;

import fr.futurskill.tutorial.jpa.model.ModuleCalendrier;
import fr.futurskill.tutorial.jpa.model.TicketAutoEvaluation;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

@Stateless
@LocalBean
public class TicketAutoEvaluationBean {
    @PersistenceContext
    EntityManager em;


    private static final long H24 = 24 * 3600 * 1000;

    public TicketAutoEvaluation ajoute(String nom, int nombreTickets, int nbJours, Long moduleCalendarId) {
        ModuleCalendrier moduleCalendrier = em.find(ModuleCalendrier.class, moduleCalendarId);

        TicketAutoEvaluation ticketAutoEvaluation = new TicketAutoEvaluation();
        ticketAutoEvaluation.setModuleCalendrier(moduleCalendrier);
        ticketAutoEvaluation.setNombreTickets(nombreTickets);
        ticketAutoEvaluation.setExpiration(new Date(System.currentTimeMillis() + nbJours * H24));
        ticketAutoEvaluation.setNom(nom);

        return em.merge(ticketAutoEvaluation);
    }

}
