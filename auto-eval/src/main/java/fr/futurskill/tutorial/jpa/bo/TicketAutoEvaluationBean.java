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

        return jpaToBean(em.merge(ticketAutoEvaluation));
    }


    public TicketAutoEvaluation get(Long ticketAutoEvaluationId) {
        return jpaToBean(em.find(TicketAutoEvaluation.class, ticketAutoEvaluationId));
    }

    public static TicketAutoEvaluation jpaToBean(TicketAutoEvaluation entity) {
        TicketAutoEvaluation bean = new TicketAutoEvaluation();

        bean.setId(entity.getId());
        bean.setNombreTickets(entity.getNombreTickets());
        bean.setNom(entity.getNom());
        bean.setExpiration(entity.getExpiration());
        bean.setModuleCalendrier(ModuleCalendrierBean.jpaToBean(entity.getModuleCalendrier()));
        bean.setAutoEvaluations(AutoEvaluationBean.jpaToBean(entity.getAutoEvaluations()));

        return bean;
    }
}
