package domainapp.application.services.health;

import domainapp.modules.simple.dom.impl.persona.PersonaMenu;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.services.health.Health;
import org.apache.isis.applib.services.health.HealthCheckService;

import javax.inject.Inject;

@DomainService(nature = NatureOfService.DOMAIN)
public class HealthCheckServiceImpl implements HealthCheckService {

    @Override
    public Health check() {

        try {
            personaMenu.ping();
            return Health.ok();
        } catch (Exception ex) {
            return Health.error(ex.getMessage());
        }

    }

    @Inject
    PersonaMenu personaMenu;
}

