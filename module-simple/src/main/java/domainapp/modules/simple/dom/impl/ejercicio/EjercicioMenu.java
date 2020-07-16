package domainapp.modules.simple.dom.impl.ejercicio;

import domainapp.modules.simple.dom.impl.rutina.Rutina;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.eventbus.ActionDomainEvent;

import javax.inject.Inject;
import java.util.List;


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

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @MemberOrder(sequence = "2")
    public List<Ejercicio> listAll() {
        return ejercicioRepository.listAll();
    }

    @Inject
    EjercicioRepository ejercicioRepository;

}
