package domainapp.modules.simple.dominio.pagos;

import domainapp.modules.simple.dominio.enums.Estado;
import domainapp.modules.simple.dominio.socio.Socio;
import lombok.Getter;
import lombok.Setter;
import org.apache.isis.applib.annotation.*;
import org.isisaddons.wicket.fullcalendar2.cpt.applib.CalendarEvent;
import org.isisaddons.wicket.fullcalendar2.cpt.applib.CalendarEventable;
import org.joda.time.LocalDate;

import javax.jdo.annotations.*;



@PersistenceCapable(identityType= IdentityType.DATASTORE, schema="gimnasio", table="pagos")
@javax.jdo.annotations.DatastoreIdentity(strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY, column="idPago")
@Queries({
        @Query(
                name = "findByEstado", language = "JDOQL",
                value = "SELECT "
                        + "FROM domainapp.modules.simple.dominio.pagos.Pago "
                        + "WHERE estado == :estado "
                        + "ORDER BY fechaDePago DESC"),
        @Query(
                name = "findBySocio", language = "JDOQL",
                value = "SELECT "
                        + "FROM domainapp.modules.simple.dominio.pagos.Pago "
                        + "WHERE socio == :socio && estado == 'Activo' "
                        + "ORDER BY fechaDePago DESC")

})


@DomainObject(auditing = Auditing.ENABLED)
@DomainObjectLayout()
@lombok.Getter @lombok.Setter
public class Pago implements CalendarEventable {

    @javax.jdo.annotations.Column(allowsNull = "false")
    @lombok.NonNull
    @Property()
    @Getter @Setter
    private Socio socio;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @lombok.NonNull
    @Property()
    //cantidad de dias que entrena a la semana
    private int diasPorSem;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @lombok.NonNull
    @Property()
    //total a pagar
    private int monto;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @lombok.NonNull
    @Property()
    @Title(prepend = "Pago: ")
    private LocalDate fechaDePago;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @lombok.NonNull
    @Property()
    private LocalDate proximoPago;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @lombok.NonNull
    @Property()
    private Estado estado;

    @Programmatic
    public void CambiarEstado(Estado estado){
        this.setEstado(estado);
    }


    @Action(semantics = SemanticsOf.IDEMPOTENT_ARE_YOU_SURE)
    @ActionLayout(named = "Activar/Desactivar")
    public Pago Estado(){
        if(this.getEstado()==Estado.Activo){
            CambiarEstado(Estado.Inactivo);
        }else {
            CambiarEstado(Estado.Activo);
        }

        return this;
    }


    @Programmatic
    @Override
    public String getCalendarName() {
        return Integer.toString(getDiasPorSem());
    }

    @Programmatic
    public String getNotes() {
        return socio.getNombre()+" "+ socio.getApellido();
    }

    @Programmatic
    @Override
    public CalendarEvent toCalendarEvent() {
        return new CalendarEvent(getFechaDePago().toDateTimeAtStartOfDay(), getCalendarName(), getNotes());
    }

}
