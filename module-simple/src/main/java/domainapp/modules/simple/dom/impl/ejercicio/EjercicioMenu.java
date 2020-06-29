package domainapp.modules.simple.dom.impl.ejercicio;

import domainapp.modules.simple.dom.impl.profesor.ProfesorMenu;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.eventbus.ActionDomainEvent;

import javax.inject.Inject;


@DomainService(
        nature = NatureOfService.VIEW_MENU_ONLY,
        objectType = "ejercicio.SimpleObjectMenu",
        repositoryFor = Ejercicio.class
)
@DomainServiceLayout(
        named = "Ejercicio",
        menuOrder = ""
)
public class EjercicioMenu {

    public static class CreateDomainEvent extends ActionDomainEvent<ProfesorMenu> {}
    @Action(domainEvent = EjercicioMenu.CreateDomainEvent.class)
    @MemberOrder(sequence = "1")
    public Ejercicio create(
            @ParameterLayout(named="Nombre Ejercicio") final String nombreEjercicio,
            @ParameterLayout(named="Grupo Muscular") final String grupoMuscular


    ) {     return ejercicioRepository.create(
            nombreEjercicio,
            grupoMuscular);
    }

    @Inject
    EjercicioRepository ejercicioRepository;

}
