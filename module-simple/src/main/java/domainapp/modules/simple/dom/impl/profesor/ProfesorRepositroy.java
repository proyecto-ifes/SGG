package domainapp.modules.simple.dom.impl.profesor;

import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.joda.time.LocalDate;

import javax.inject.Inject;

@DomainService(nature = NatureOfService.DOMAIN, repositoryFor = Profesor.class)
public class ProfesorRepositroy {

    public Profesor create(
            final String nombre,
            final String apellido,
            final Integer dni,
            final Integer telefono,
            final String direccion,
            final LocalDate fechaNac,
            final Integer estado

    ){
        final Profesor object = new Profesor(
                nombre,
                apellido,
                dni,
                telefono,
                direccion,
                fechaNac,
                estado);
        repositoryService.persist(object);
        return object;
    }


    @Inject
    RepositoryService repositoryService;



}
