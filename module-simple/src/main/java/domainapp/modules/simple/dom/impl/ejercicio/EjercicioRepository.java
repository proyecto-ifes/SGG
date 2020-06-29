package domainapp.modules.simple.dom.impl.ejercicio;


import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.services.repository.RepositoryService;

import javax.inject.Inject;


@DomainService(nature = NatureOfService.DOMAIN, repositoryFor = Ejercicio.class)
public class EjercicioRepository {

    public Ejercicio create(
            final String nombreEjercicio,
            final String grupoMuscular

    ){
        final Ejercicio object = new Ejercicio(
                nombreEjercicio,
                grupoMuscular);
        repositoryService.persist(object);
        return object;
    }

    @Inject
    RepositoryService repositoryService;
}
