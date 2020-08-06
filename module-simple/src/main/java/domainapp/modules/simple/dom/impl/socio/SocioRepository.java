package domainapp.modules.simple.dom.impl.socio;

import domainapp.modules.simple.dom.impl.enums.Estado;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.Programmatic;
import org.apache.isis.applib.services.jdosupport.IsisJdoSupport;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.datanucleus.query.typesafe.TypesafeQuery;
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

    @Programmatic
    public List<Socio> findByApellido(
            //@ParameterLayout(named = "Apellido")
            final String apellido
    ) {
        TypesafeQuery<Socio> q = isisJdoSupport.newTypesafeQuery(Socio.class);
        final QSocio cand = QSocio.candidate();
        q = q.filter(
                cand.apellido.indexOf(q.stringParameter("apellido")).ne(-1)
        );
        return q.setParameter("apellido", apellido)
                .executeList();
    }

    @Programmatic
    public List<Socio> findByDni(
            //@ParameterLayout(named = "Dni")
            final Integer dni
    ) {
        TypesafeQuery<Socio> q = isisJdoSupport.newTypesafeQuery(Socio.class);
        final QSocio cand = QSocio.candidate();
        q = q.filter(
                cand.dni.eq(q.integerParameter("dni"))
        );
        return q.setParameter("dni", dni)
                .executeList();
    }


    @Inject
    RepositoryService repositoryService;

    @javax.inject.Inject
    IsisJdoSupport isisJdoSupport;

}
