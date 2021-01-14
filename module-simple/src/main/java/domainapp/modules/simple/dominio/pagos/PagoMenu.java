package domainapp.modules.simple.dominio.pagos;


import domainapp.modules.simple.dominio.enums.Estado;
import domainapp.modules.simple.dominio.reportes.EjecutarReportes;
import net.sf.jasperreports.engine.JRException;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.value.Blob;

import javax.inject.Inject;
import java.io.IOException;
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

    @Action()
    @ActionLayout(named = "Exportar Listado a PDF")
    public Blob ExportarListado() throws JRException, IOException {
        EjecutarReportes ejecutarReportes = new EjecutarReportes();
        return ejecutarReportes.ListadoPagosPDF(pagoRepository.listAll());
    }

    @Inject
    PagoRepository pagoRepository;


}
