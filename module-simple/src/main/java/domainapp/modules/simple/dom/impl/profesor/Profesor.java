package domainapp.modules.simple.dom.impl.profesor;


import domainapp.modules.simple.dom.impl.persona.Persona;
import org.apache.isis.applib.annotation.Auditing;
import org.apache.isis.applib.annotation.DomainObject;
import org.apache.isis.applib.annotation.DomainObjectLayout;
import org.joda.time.LocalDate;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable(identityType= IdentityType.DATASTORE, schema="gimnasio", table="profesores")
@DomainObject(auditing = Auditing.ENABLED)
@DomainObjectLayout()
@javax.jdo.annotations.Unique(name="Profesor_dni_UNQ", members = {"dni"})
@lombok.Getter @lombok.Setter
public class Profesor extends Persona {

    public Profesor(){

    }

    public Profesor(String nombre, String apellido, Integer dni, Integer telefono, String direccion, LocalDate fechaNac, Integer estado) {
        super(nombre, apellido, dni, telefono, direccion, fechaNac, estado);
    }
}
