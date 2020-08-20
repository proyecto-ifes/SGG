package domainapp.modules.simple.dominio.profesor;

import domainapp.modules.simple.dominio.enums.Estado;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.eventbus.ActionDomainEvent;
import org.joda.time.LocalDate;

import javax.inject.Inject;
import java.util.List;

@DomainService(
        nature = NatureOfService.VIEW_MENU_ONLY,
        objectType = "profesor.SimpleObjectMenu",
        repositoryFor = Profesor.class
)
@DomainServiceLayout(
        named = "Profesores",
        menuOrder = ""
)


public class ProfesorMenu {

    public static class CreateDomainEvent extends ActionDomainEvent<ProfesorMenu> {}
    @Action(domainEvent = ProfesorMenu.CreateDomainEvent.class)
    @MemberOrder(sequence = "1")
    public Profesor create(
            @ParameterLayout(named="Nombre") final String nombre,
            @ParameterLayout(named="Apellido") final String apellido,
            @ParameterLayout(named="DNI") final Integer dni,
            @ParameterLayout(named="Telefono") final Integer telefono,
            @ParameterLayout(named="Direccion") final String direccion,
            @ParameterLayout(named="FechaNac") final LocalDate fechaNac,
            @ParameterLayout(named="Estado") final Estado estado

    ) {     return profesorRepository.create(
                    nombre,
                    apellido,
                    dni,
                    telefono,
                    direccion,
                    fechaNac,
                    estado);
    }

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @MemberOrder(sequence = "2")
    public List<Profesor> listAll() {
        return profesorRepository.listAll();
    }


    @Action()
    @ActionLayout(named = "Buscar Profesor por Apellido")
    @MemberOrder(sequence = "5")
    /**
     * Este metodo permite encontrar a un Profesor en particular
     * dado un apellido
     *
     * @param apellido
     * @return List<Profesor>
     */
    public List<Profesor> findByApellido(@ParameterLayout(named = "Apellido") final String apellido) {
        return profesorRepository.findByApellido(apellido);
    }

    @Action()
    @ActionLayout(named = "Buscar Profesor por Dni")
    @MemberOrder(sequence = "6")
    /**
     * Este metodo permite encontrar a un Profesor en particular
     * dado un dni
     *
     * @param dni
     * @return List<Profesor>
     */
    public List<Profesor> findByDni(@ParameterLayout(named = "Dni") final Integer dni) {
        return profesorRepository.findByDni(dni);
    }

    @Inject
    ProfesorRepository profesorRepository;
}
