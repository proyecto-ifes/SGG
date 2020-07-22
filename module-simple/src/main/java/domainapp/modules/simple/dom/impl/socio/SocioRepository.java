package domainapp.modules.simple.dom.impl.socio;

import domainapp.modules.simple.dom.impl.enums.Estado;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.joda.time.LocalDate;

import javax.inject.Inject;
import java.util.List;

@DomainService(nature = NatureOfService.DOMAIN, repositoryFor = Socio.class)
public class SocioRepository {

    public Socio create(
            final String nombre,
            final String apellido,
            final Integer dni,
            final Integer telefono,
            final String direccion,
            final LocalDate fechaNac,
            final Estado estado,
            final String historiaClinica,
            final Integer nroEmergencia,
            final Integer peso,
            final Integer altura,
            final Boolean asistencia
    ) {
        final Socio object = new Socio(
                nombre,
                apellido,
                dni,
                telefono,
                direccion,
                fechaNac,
                estado,
                historiaClinica,
                nroEmergencia,
                peso,
                altura,
                asistencia);
        repositoryService.persist(object);
        return object;
    }
    public List<Socio> listAll() {
        return repositoryService.allInstances(Socio.class);
    }

    @Inject
    RepositoryService repositoryService;

}
