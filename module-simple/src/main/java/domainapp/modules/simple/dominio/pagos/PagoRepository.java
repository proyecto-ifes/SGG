package domainapp.modules.simple.dominio.pagos;


import domainapp.modules.simple.dominio.enums.Estado;
import domainapp.modules.simple.dominio.socio.Socio;
import org.apache.isis.applib.annotation.DomainService;
import org.apache.isis.applib.annotation.NatureOfService;
import org.apache.isis.applib.annotation.Programmatic;
import org.apache.isis.applib.query.QueryDefault;
import org.apache.isis.applib.services.repository.RepositoryService;
import javax.inject.Inject;
import java.util.List;


@DomainService(nature = NatureOfService.DOMAIN, repositoryFor = Pago.class)
public class PagoRepository {

    @Programmatic
    public List<Pago> Listar(final Estado estado){

        return repositoryService.allMatches(
                new QueryDefault<>(
                        Pago.class,
                        "findByEstado",
                        "estado", estado));
    }

    @Programmatic
    public List<Pago> ListarPorSocio(final Socio socio){

        return repositoryService.allMatches(
                new QueryDefault<>(
                        Pago.class,
                        "findBySocio",
                        "socio", socio));
    }
    @Inject
    RepositoryService repositoryService;

}
