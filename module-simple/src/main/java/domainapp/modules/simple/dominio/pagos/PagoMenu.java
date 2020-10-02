package domainapp.modules.simple.dominio.pagos;


import domainapp.modules.simple.dominio.enums.Estado;
import org.apache.isis.applib.annotation.*;
import javax.inject.Inject;
import java.util.List;


@DomainService(
        nature = NatureOfService.VIEW_MENU_ONLY,
        objectType = "pago.SimpleObjectMenu",
        repositoryFor = Pago.class
)
@DomainServiceLayout(
        named = "Pago",
        menuOrder = ""
)

public class PagoMenu {

    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @MemberOrder(sequence = "2")
    public List<Pago> listAll() { return pagoRepository.Listar(Estado.Activo);  }

    @Inject
    PagoRepository pagoRepository;


}
