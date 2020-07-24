package domainapp.modules.simple.dom.impl.ejercicio;


import domainapp.modules.simple.dom.impl.rutina.Rutina;
import domainapp.modules.simple.dom.impl.socio.Socio;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.services.title.TitleService;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable(identityType= IdentityType.DATASTORE, schema="gimnasio", table="ejercicios")
@javax.jdo.annotations.DatastoreIdentity(strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY, column="idEjercicio")
@DomainObject(auditing = Auditing.ENABLED)
@DomainObjectLayout()
@lombok.Getter @lombok.Setter
public class Ejercicio {

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property()
    @Getter @Setter
    private Rutina rutina;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @lombok.NonNull
    @Property()
    @Title(prepend = "Ejercicio: ")
    private String nombreEjercicio;

    @javax.jdo.annotations.Column(allowsNull = "true")
    @Property()
    private Integer repeticion;

    @javax.jdo.annotations.Column(allowsNull = "true")
    @Property()
    private Integer peso;

    @javax.jdo.annotations.Column(allowsNull = "true")
    @Property()
    private Integer series;

    @Action()
    @ActionLayout(named = "Editar")
    public Ejercicio update(
            @ParameterLayout(named = "Nombre del ejercicio: ")
            final String nombreEjercicio,

            @ParameterLayout(named = "Repeticiones: ")
            final Integer repeticion,

            @ParameterLayout(named = "Peso: ")
            final Integer peso,

            @ParameterLayout(named = "Series: ")
            final Integer series

    ){

        this.setNombreEjercicio(nombreEjercicio);
        this.setRepeticion(repeticion);
        this.setPeso(peso);
        this.setSeries(series);
        return this;
    }

    public String default0Update() { return getNombreEjercicio(); }
    public Integer default1Update()  { return getRepeticion(); }
    public Integer default2Update() { return getPeso(); }
    public Integer default3Update() { return getSeries(); }

    @javax.inject.Inject
    @javax.jdo.annotations.NotPersistent
    @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
    RepositoryService repositoryService;

    @javax.inject.Inject
    @javax.jdo.annotations.NotPersistent
    @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
    TitleService titleService;

    @javax.inject.Inject
    @javax.jdo.annotations.NotPersistent
    @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
    MessageService messageService;
}
