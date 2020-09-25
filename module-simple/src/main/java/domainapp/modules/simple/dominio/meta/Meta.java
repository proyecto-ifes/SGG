package domainapp.modules.simple.dominio.meta;

import domainapp.modules.simple.dominio.enums.EstadoMeta;
import domainapp.modules.simple.dominio.socio.Socio;
import lombok.AccessLevel;
import org.apache.isis.applib.annotation.*;

import org.apache.isis.applib.services.repository.RepositoryService;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;


@PersistenceCapable(identityType= IdentityType.DATASTORE, schema="gimnasio", table="metas")
@javax.jdo.annotations.DatastoreIdentity(strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY, column="idMeta")
@DomainObject(auditing = Auditing.ENABLED)
@DomainObjectLayout()  // causes UI events to be triggered
@lombok.Getter @lombok.Setter
public class Meta {

    @javax.jdo.annotations.Column(allowsNull = "false")
    @Property()
    private Socio socio;

    @javax.jdo.annotations.Column(allowsNull = "true")
    @Title(prepend = "Meta: ")
    @Property()
    private String descripcion;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @lombok.NonNull
    @Property()
    private EstadoMeta estadoMeta;

    public Meta() {
    }

    @Action()
    @ActionLayout(named = "Editar")
    public Meta update(
            @ParameterLayout(named = "Descripcion: ")
            final String descripcion
    ){
        this.setDescripcion(descripcion);
        return this;
    }

    public String default0Update() { return getDescripcion(); }

    @Programmatic
    public void CambiarEstado(EstadoMeta estadoMeta){
        this.setEstadoMeta(estadoMeta);
    }

    @Action()
    @ActionLayout(named = "Iniciado")
    public Meta Iniciado(){
        CambiarEstado(EstadoMeta.Iniciado);
        return this;
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT_ARE_YOU_SURE)
    @ActionLayout(named = "Completado")
    public Meta Completado(){
        CambiarEstado(EstadoMeta.Completado);
        return this;
    }

    @javax.inject.Inject
    @javax.jdo.annotations.NotPersistent
    @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
    RepositoryService repositoryService;

}
