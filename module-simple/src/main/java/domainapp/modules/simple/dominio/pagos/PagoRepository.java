package domainapp.modules.simple.dominio.pagos;


import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.services.repository.RepositoryService;
import javax.inject.Inject;
import java.util.List;


@DomainService(nature = NatureOfService.DOMAIN, repositoryFor = Pago.class)
public class PagoRepository {


    public List<Pago> listAll() {
        return repositoryService.allInstances(Pago.class);
    }

    @Inject
    RepositoryService repositoryService;

}
