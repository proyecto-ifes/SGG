package domainapp.modules.simple.dom.impl.asistencia;

import domainapp.modules.simple.dom.impl.enums.TipoTurno;
import domainapp.modules.simple.dom.impl.socio.Socio;
import org.apache.isis.applib.annotation.*;
import org.joda.time.LocalDateTime;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable(identityType= IdentityType.DATASTORE, schema="gimnasio", table="asistenciasSocio")
@DomainObject(auditing = Auditing.ENABLED)
@DomainObjectLayout()  // causes UI events to be triggered
@lombok.Getter @lombok.Setter
public class AsistenciaSocio {

    @javax.jdo.annotations.Column(allowsNull = "false")
    @lombok.NonNull
    @Property()
    @Title(prepend = "Asistencia de ")
    private Socio socio;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @lombok.NonNull
    @Property()
    private TipoTurno tipoTurno;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @lombok.NonNull
    @Property()
    private LocalDateTime fechaYHora;

}
