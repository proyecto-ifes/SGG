package domainapp.modules.simple.dominio.profesor;

import domainapp.modules.simple.dominio.enums.Estado;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.Programmatic;
import org.apache.isis.applib.services.jdosupport.IsisJdoSupport;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.datanucleus.query.typesafe.TypesafeQuery;
import org.joda.time.LocalDate;

import javax.inject.Inject;
import java.util.List;

@DomainService(nature = NatureOfService.DOMAIN, repositoryFor = Profesor.class)
public class ProfesorRepository {

    public Profesor create(
            final String nombre,
            final String apellido,
            final Integer dni,
            final Integer telefono,
            final String direccion,
            final LocalDate fechaNac,
            final Estado estado

    ){
        final Profesor object = new Profesor(
                nombre.toUpperCase(),
                apellido.toUpperCase(),
                dni,
                telefono,
                direccion,
                fechaNac,
                estado);
        repositoryService.persist(object);
        return object;
    }

    public List<Profesor> listAll() { return repositoryService.allInstances(Profesor.class); }


    @Programmatic
    public List<Profesor> findByApellido(
            final String apellido
    ) {
        TypesafeQuery<Profesor> q = isisJdoSupport.newTypesafeQuery(Profesor.class);
        final QProfesor cand = QProfesor.candidate();
        q = q.filter(
                cand.apellido.indexOf(q.stringParameter("apellido")).ne(-1)
        );
        return q.setParameter("apellido", apellido.toUpperCase())
                .executeList();
    }

    @Programmatic
    public List<Profesor> findByDni(
            final Integer dni
    ) {
        TypesafeQuery<Profesor> q = isisJdoSupport.newTypesafeQuery(Profesor.class);
        final QProfesor cand = QProfesor.candidate();
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
