package domainapp.modules.simple.dom.impl.rutina;

import domainapp.modules.simple.dom.impl.profesor.Profesor;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.eventbus.ActionDomainEvent;

import javax.inject.Inject;
import java.util.List;

@DomainService(
        nature = NatureOfService.VIEW_MENU_ONLY,
        objectType = "rutina.SimpleObjectMenu",
        repositoryFor = Profesor.class
)
@DomainServiceLayout(
        named = "Rutinas",
        menuOrder = ""
)

public class RutinaMenu {

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @MemberOrder(sequence = "2")
    public List<Rutina> listAll() {
        return rutinaRepository.listAll();
    }

    @Inject
    RutinaRepository rutinaRepository;
}
