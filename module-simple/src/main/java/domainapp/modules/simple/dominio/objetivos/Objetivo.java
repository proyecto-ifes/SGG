package domainapp.modules.simple.dominio.objetivos;


import domainapp.modules.simple.dominio.meta.Meta;
import lombok.AccessLevel;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.message.MessageService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.apache.isis.applib.services.title.TitleService;
import org.joda.time.LocalDate;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable(identityType= IdentityType.DATASTORE, schema="gimnasio", table="objetivos")
@javax.jdo.annotations.DatastoreIdentity(strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY, column="idObjetivo")
@DomainObject(auditing = Auditing.ENABLED)
@DomainObjectLayout()
@lombok.Getter @lombok.Setter
public class Objetivo {

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property()
    private Meta meta;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @lombok.NonNull
    @Property()
    @Title(prepend = "Objetivo: ")
    private String descripcion;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @lombok.NonNull
    @Property()
    private LocalDate fechaObjetivo;

    @Action()
    @ActionLayout(named = "Editar")
    public Objetivo update(
            @ParameterLayout(named = "Descripcion: ")
            final String descripcion,

            @ParameterLayout(named = "Fecha: ")
            final LocalDate fechaObjetivo
    ){
        this.setDescripcion(descripcion);
        this.setFechaObjetivo(fechaObjetivo);
        return this;
    }
    public String default0Update() { return getDescripcion(); }
    public LocalDate default1Update()  { return getFechaObjetivo(); }



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
