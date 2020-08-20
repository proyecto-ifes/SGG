package domainapp.modules.simple.dominio.asistencia;

import domainapp.modules.simple.dominio.enums.TipoTurno;
import domainapp.modules.simple.dominio.socio.Socio;
import org.apache.isis.applib.annotation.*;
import org.isisaddons.wicket.fullcalendar2.cpt.applib.CalendarEvent;
import org.isisaddons.wicket.fullcalendar2.cpt.applib.CalendarEventable;
import org.joda.time.LocalDateTime;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable(identityType= IdentityType.DATASTORE, schema="gimnasio", table="asistenciasSocio")
@DomainObject(auditing = Auditing.ENABLED)
@DomainObjectLayout()  // causes UI events to be triggered
@lombok.Getter @lombok.Setter
public class AsistenciaSocio implements CalendarEventable {

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

    @Programmatic
    @Override
    public String getCalendarName() { return tipoTurno.toString(); }

    @Programmatic
    public String getNotes() {
        return socio.getNombre()+" "+ socio.getApellido();
    }

    @Programmatic
    @Override
    public CalendarEvent toCalendarEvent() {
        return new CalendarEvent(getFechaYHora().toDateTime(), getCalendarName(), getNotes());
    }
}
