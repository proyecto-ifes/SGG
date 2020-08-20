package domainapp.modules.simple.dominio.profesor;

import domainapp.modules.simple.dominio.asistencia.AsistenciaProfesor;
import domainapp.modules.simple.dominio.enums.Estado;
import domainapp.modules.simple.dominio.persona.Persona;
import lombok.AccessLevel;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.factory.FactoryService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

import javax.jdo.annotations.*;
import java.util.ArrayList;
import java.util.List;

@Queries({
        @Query(name = "findByApellido", language = "JDOQL",
                value = "SELECT "
                        + "FROM domainapp.modules.simple.dominio.profesor.Profesor "
                        + "WHERE apellido == :apellido "),

        @Query(name = "findByDni", language = "JDOQL",
                value = "SELECT "
                        + "FROM domainapp.modules.simple.dominio.profesor.Profesor "
                        + "WHERE dni == :dni ")
})

@PersistenceCapable(identityType= IdentityType.DATASTORE, schema="gimnasio", table="profesores")
@DomainObject(auditing = Auditing.ENABLED)
@DomainObjectLayout()
@javax.jdo.annotations.Unique(name="Profesor_dni_UNQ", members = {"dni"})
@lombok.Getter @lombok.Setter
public class Profesor extends Persona {

    @Persistent(mappedBy = "profesor", dependentElement = "true")
    @Collection()
    private List<AsistenciaProfesor> asistenciaProfesor = new ArrayList<AsistenciaProfesor>();

    public Profesor(){

    }

    public Profesor(String nombre, String apellido, Integer dni, Integer telefono, String direccion, LocalDate fechaNac, Estado estado) {
        super(nombre, apellido, dni, telefono, direccion, fechaNac, estado);
    }

    @Action()
    @ActionLayout(named = "Editar")
    public Profesor update(
            @ParameterLayout(named = "Numero de telefono: ")
            final Integer telefono,

            @ParameterLayout(named = "Direccion: ")
            final String direccion
    ){
        this.setTelefono(telefono);
        this.setDireccion(direccion);
        return this;
    }

    public Integer default0Update() { return getTelefono(); }
    public String default1Update()  { return getDireccion(); }

    @Action()
    @ActionLayout(named = "Dar Asistencia")
    public Profesor addAsistencia(){
        final AsistenciaProfesor asistenciaProfesor = factoryService.instantiate(AsistenciaProfesor.class);
        asistenciaProfesor.setProfesor(this);
        LocalDateTime fechaYHora = LocalDateTime.now();
        asistenciaProfesor.setFechaYHora(fechaYHora);
        getAsistenciaProfesor().add(asistenciaProfesor);
        repositoryService.persist(asistenciaProfesor);

        return this;
    }


    @Programmatic
    public void CambiarEstado(Estado estado){
        this.setEstado(estado);
    }

    @Action()
    @ActionLayout(named = "Activar")
    public Profesor Activo(){
        CambiarEstado(Estado.Activo);
        return this;
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT_ARE_YOU_SURE)
    @ActionLayout(named = "Desactivar")
    public Profesor Inactivo(){
        CambiarEstado(Estado.Inactivo);
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
