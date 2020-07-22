package domainapp.modules.simple.dom.impl.profesor;

import domainapp.modules.simple.dom.impl.enums.Estado;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.eventbus.ActionDomainEvent;
import org.joda.time.LocalDate;

import javax.inject.Inject;

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
            @ParameterLayout(named="Estado") final Estado estado,
            @ParameterLayout(named="Asistencia") final Boolean asistencia

    ) {     return profesorRepository.create(
                    nombre,
                    apellido,
                    dni,
                    telefono,
                    direccion,
                    fechaNac,
                    estado,
                    asistencia);
                }

    @Inject
    ProfesorRepository profesorRepository;
}
