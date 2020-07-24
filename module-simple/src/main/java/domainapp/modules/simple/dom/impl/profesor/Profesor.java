package domainapp.modules.simple.dom.impl.profesor;


import domainapp.modules.simple.dom.impl.enums.Estado;
import domainapp.modules.simple.dom.impl.persona.Persona;
import domainapp.modules.simple.dom.impl.socio.Socio;
import org.apache.isis.applib.annotation.*;
import org.joda.time.LocalDate;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable(identityType= IdentityType.DATASTORE, schema="gimnasio", table="profesores")
@DomainObject(auditing = Auditing.ENABLED)
@DomainObjectLayout()
@javax.jdo.annotations.Unique(name="Profesor_dni_UNQ", members = {"dni"})
@lombok.Getter @lombok.Setter
public class Profesor extends Persona {

    @javax.jdo.annotations.Column(allowsNull = "true")
    @Property()
    private Boolean asistencia;

    public Profesor(){

    }

    public Profesor(String nombre, String apellido, Integer dni, Integer telefono, String direccion, LocalDate fechaNac, Estado estado, Boolean asistencia) {
        super(nombre, apellido, dni, telefono, direccion, fechaNac, estado);
        this.asistencia = asistencia;
    }

    @Action()
    @ActionLayout(named = "Editar")
    public Profesor update(
            @ParameterLayout(named = "Numero de telefono: ")
            final Integer telefono,

            @ParameterLayout(named = "Direccion: ")
            final String direccion,

            @ParameterLayout(named = "Asistencia: ")
            final Boolean asistencia
    ){
        this.setTelefono(telefono);
        this.setDireccion(direccion);
        this.setAsistencia(asistencia);
        return this;
    }

    public Integer default0Update() { return getTelefono(); }
    public String default1Update()  { return getDireccion(); }
    public Boolean default2Update() { return getAsistencia(); }
}
