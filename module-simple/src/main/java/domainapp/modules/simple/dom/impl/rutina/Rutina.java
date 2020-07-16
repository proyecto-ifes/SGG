package domainapp.modules.simple.dom.impl.rutina;

import domainapp.modules.simple.dom.impl.ejercicio.Ejercicio;
import domainapp.modules.simple.dom.impl.socio.Socio;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.factory.FactoryService;
import org.apache.isis.applib.services.repository.RepositoryService;

import javax.jdo.annotations.*;
import java.util.ArrayList;
import java.util.List;

@PersistenceCapable(identityType= IdentityType.DATASTORE, schema="gimnasio", table="rutinas")
@javax.jdo.annotations.DatastoreIdentity(strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY, column="idRutina")
@DomainObject(auditing = Auditing.ENABLED)
@DomainObjectLayout()  // causes UI events to be triggered
@lombok.Getter @lombok.Setter
public class Rutina {

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property(editing = Editing.ENABLED)
    @Getter @Setter
    private Socio socio;

    @javax.jdo.annotations.Column(allowsNull = "true")
    @Title(prepend = "Rutina: ")
    @Property(editing = Editing.ENABLED)
    private String nombre;

    @Persistent(mappedBy = "rutina", dependentElement = "true")
    @Collection()
    @Getter @Setter
    private List<Ejercicio> ejercicio = new ArrayList<Ejercicio>();

    public Rutina() {
    }

    public Rutina(Socio socio, String nombre, List<Ejercicio> ejercicio) {
        this.socio = socio;
        this.nombre = nombre;
        this.ejercicio = ejercicio;
    }

    @Action()
    public Rutina cargarEjercicio(
            @ParameterLayout(named="Nombre Ejercicio: ") final String nombreEjercicio,
            @ParameterLayout(named="Repeticion: ") final Integer repeticion,
            @ParameterLayout(named="Peso: ") final Integer peso,
            @ParameterLayout(named="Series: ") final Integer series

    ){
        final Ejercicio ejercicio = factoryService.instantiate(Ejercicio.class);
        ejercicio.setRutina(this);
        ejercicio.setNombreEjercicio(nombreEjercicio);
        ejercicio.setRepeticion(repeticion);
        ejercicio.setPeso(peso);
        ejercicio.setSeries(series);
        getEjercicio().add(ejercicio);
        repositoryService.persist(ejercicio);
        return this;
    }

    @javax.inject.Inject
    @javax.jdo.annotations.NotPersistent
    @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
    FactoryService factoryService;

    @javax.inject.Inject
    @javax.jdo.annotations.NotPersistent
    @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
    RepositoryService repositoryService;
}
