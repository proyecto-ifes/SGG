package domainapp.modules.simple.dom.impl.ejercicio;


import domainapp.modules.simple.dom.impl.rutina.Rutina;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.services.repository.RepositoryService;

import javax.inject.Inject;
import java.util.List;


@DomainService(nature = NatureOfService.DOMAIN, repositoryFor = Ejercicio.class)
public class EjercicioRepository {

    public List<Ejercicio> listAll() {
        return repositoryService.allInstances(Ejercicio.class);
    }

    @Inject
    RepositoryService repositoryService;
}
