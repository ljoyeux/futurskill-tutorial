package fr.futurskill.tutorial.jpa;

import fr.futurskill.tutorial.jpa.model.AutoEvaluation;
import fr.futurskill.tutorial.jpa.model.Module;
import fr.futurskill.tutorial.jpa.model.ModuleCalendrier;
import fr.futurskill.tutorial.jpa.model.TicketAutoEvaluation;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Date;

public class ModuleIntegrationCase {
    @Test
    public void dummy() {
        System.out.println("ModuleIntegrationCase.dummy");
    }

    @Test
    public void scenario1() {
        try {
            Module module = creerModule();
            System.out.println(module);

            ModuleCalendrier moduleCalendrier = creerModuleCalendrier(module);
            System.out.println(moduleCalendrier);

            TicketAutoEvaluation ticketAutoEvaluation = creerTicketAutoEvaluation(moduleCalendrier);
            System.out.println(ticketAutoEvaluation);

            AutoEvaluation autoEvaluation = creerAutoEvaluation(ticketAutoEvaluation);
            System.out.println(autoEvaluation);

        } catch (InternalServerErrorException ex) {
            System.out.println(ex.getResponse().readEntity(String.class));
            throw ex;
        }
    }

    private Module creerModule() {
        WebTarget webTarget = AutoEvalIntegrationTestSuite.getBaseRestService();
        Module module =
                webTarget.path("/module/creer")
                        .queryParam("titre", "Web Service")
                        .queryParam("description", "Tutoriel Web services JAX-WS & JAX-RS")
                        .request(MediaType.APPLICATION_JSON)
                        .get(Module.class);

        assert module != null;
        assert module.getId() != null;
        assert module.getId() != 0;

        assert module.getTitre()!=null;
        assert ! module.getTitre().isEmpty();

        assert module.getDescription()!=null;
        assert ! module.getDescription().isEmpty();



        System.out.println(module);

        return module;
    }


    private ModuleCalendrier creerModuleCalendrier(Module module) {

        Date date = new Date(System.currentTimeMillis());

        WebTarget webTarget = AutoEvalIntegrationTestSuite.getBaseRestService();
        ModuleCalendrier moduleCalendrier =
                webTarget.path("/calendrier/creer")
                        .queryParam("moduleId", module.getId())
                        .queryParam("debut", Constantes.DATE_FORMATTER.format(date))
                        .queryParam("fin", Constantes.DATE_FORMATTER.format(date))
                        .request(MediaType.APPLICATION_JSON)
                        .get(ModuleCalendrier.class);

        assert moduleCalendrier != null;
        assert moduleCalendrier.getId() != null;
        assert moduleCalendrier.getId() != 0;

        return moduleCalendrier;
    }

    private TicketAutoEvaluation creerTicketAutoEvaluation(ModuleCalendrier mc) {
        WebTarget webTarget = AutoEvalIntegrationTestSuite.getBaseRestService();
        TicketAutoEvaluation ticketAutoEvaluation =
                webTarget.path("/tickets/creer")
                        .queryParam("nom", "LJOY" + mc.getId())
                        .queryParam("nombreTickets", 5)
                        .queryParam("moduleCalendrierId", mc.getId())
                        .request(MediaType.APPLICATION_JSON)
                        .get(TicketAutoEvaluation.class);

        assert ticketAutoEvaluation!=null;

        assert ticketAutoEvaluation.getId()!=null;
        assert ticketAutoEvaluation.getId()!=0;

        assert ticketAutoEvaluation.getNombreTickets()!=null;
        assert ticketAutoEvaluation.getNombreTickets()==5;

        assert ticketAutoEvaluation.getExpiration()!=null;
        assert System.currentTimeMillis() < ticketAutoEvaluation.getExpiration().getTime(); // dans le futur

        assert mc.equals(ticketAutoEvaluation.getModuleCalendrier());
        assert ("LJOY" + mc.getId()).equals(ticketAutoEvaluation.getNom());

        return ticketAutoEvaluation;
    }

    private AutoEvaluation creerAutoEvaluation(TicketAutoEvaluation ticketAutoEvaluation) {
        WebTarget webTarget = AutoEvalIntegrationTestSuite.getBaseRestService();
        AutoEvaluation autoEvaluation =
                webTarget.path("/auto-eval/creer")
                        .queryParam("nomTicket", ticketAutoEvaluation.getNom())
                        .request(MediaType.APPLICATION_JSON)
                        .get(AutoEvaluation.class);

        assert autoEvaluation!=null;
        assert autoEvaluation.getId()!=null;
        assert autoEvaluation.getId()!=0;
        assert autoEvaluation.getDate()!=null;

        return autoEvaluation;
    }
}
