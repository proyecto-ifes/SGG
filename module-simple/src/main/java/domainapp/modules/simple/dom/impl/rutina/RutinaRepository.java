package domainapp.modules.simple.dom.impl.rutina;

import domainapp.modules.simple.dom.impl.ejercicio.Ejercicio;
import domainapp.modules.simple.dom.impl.socio.Socio;
import domainapp.modules.simple.dom.impl.socio.SocioRepository;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.Programmatic;
import org.apache.isis.applib.services.repository.RepositoryService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@DomainService(nature = NatureOfService.DOMAIN, repositoryFor = Rutina.class)
public class RutinaRepository {

    public List<Rutina> listAll() {
        return repositoryService.allInstances(Rutina.class);
    }

    @Inject
    RepositoryService repositoryService;
}
