package domainapp.modules.simple.dom.impl.socio;

import domainapp.modules.simple.dom.impl.persona.Persona;
import org.apache.isis.applib.annotation.*;
import org.joda.time.LocalDate;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable(identityType= IdentityType.DATASTORE, schema="gimnasio", table="socios")
@DomainObject(auditing = Auditing.ENABLED)
@DomainObjectLayout()  // causes UI events to be triggered
@javax.jdo.annotations.Unique(name="Socio_dni_UNQ", members = {"dni"})
@lombok.Getter @lombok.Setter
public class Socio extends Persona {

    @javax.jdo.annotations.Column(allowsNull = "false")
    @lombok.NonNull
    @Property(editing = Editing.ENABLED)
    private String historiaClinica;

    @javax.jdo.annotations.Column(allowsNull = "true")
    @Property(editing = Editing.ENABLED)
    private Integer nroEmergencia;

    @javax.jdo.annotations.Column(allowsNull = "true")
    @Property(editing = Editing.ENABLED)
    private Integer peso;

    @javax.jdo.annotations.Column(allowsNull = "true")
    @Property(editing = Editing.ENABLED)
    private Integer altura;

    @javax.jdo.annotations.Column(allowsNull = "true")
    @Property(editing = Editing.ENABLED)
    private Boolean asistencia;

    public Socio() {
    }

    public Socio(String nombre, String apellido, Integer dni, Integer telefono, String direccion, LocalDate fechaNac, Integer estado, String historiaClinica, Integer nroEmergencia, Integer peso, Integer altura, Boolean asistencia) {
        super(nombre, apellido, dni, telefono, direccion, fechaNac, estado);
        this.historiaClinica = historiaClinica;
        this.nroEmergencia = nroEmergencia;
        this.peso = peso;
        this.altura = altura;
        this.asistencia = asistencia;
    }
}
