package domainapp.modules.simple.dom.impl.socio;

import org.apache.isis.applib.annotation.*;
import org.joda.time.LocalDate;
import org.apache.isis.applib.services.eventbus.ActionDomainEvent;

import javax.inject.Inject;
import java.util.List;

@DomainService(
        nature = NatureOfService.VIEW_MENU_ONLY,
        objectType = "socio.SimpleObjectMenu",
        repositoryFor = Socio.class
)
@DomainServiceLayout(
        named = "Socios",
        menuOrder = ""
)

public class SocioMenu {

    public static class CreateDomainEvent extends ActionDomainEvent<SocioMenu> {}
    @Action(domainEvent = CreateDomainEvent.class)
    @MemberOrder(sequence = "1")
    public Socio create(
            @ParameterLayout(named="Nombre") final String nombre,
            @ParameterLayout(named="Apellido") final String apellido,
            @ParameterLayout(named="DNI") final Integer dni,
            @ParameterLayout(named="Telefono") final Integer telefono,
            @ParameterLayout(named="Direccion") final String direccion,
            @ParameterLayout(named="FechaNac") final LocalDate fechaNac,
            @ParameterLayout(named="Estado") final Integer estado,
            @ParameterLayout(named="HistoriaClinica") final String historiaClinica,
            @ParameterLayout(named="NroEmergencia") final Integer nroEmergencia,
            @ParameterLayout(named="Peso") final Integer peso,
            @ParameterLayout(named="Altura") final Integer altura,
            @ParameterLayout(named="Asistencia") final Boolean asistencia
    ) {

        return socioRepository.create(
                nombre,
                apellido,
                dni,
                telefono,
                direccion,
                fechaNac,
                estado,
                historiaClinica,
                nroEmergencia,
                peso,
                altura,
                asistencia);
    }
    @Action(semantics = SemanticsOf.SAFE)
    @ActionLayout(bookmarking = BookmarkPolicy.AS_ROOT)
    @MemberOrder(sequence = "2")
    public List<Socio> listAll() {
        return socioRepository.listAll();
    }
    @Inject
    SocioRepository socioRepository;

}
