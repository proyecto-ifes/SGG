package domainapp.modules.simple.dom.impl.socio;

import domainapp.modules.simple.dom.impl.enums.Estado;
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
            @ParameterLayout(named="Estado") final Estado estado,
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

    @Action()
    @ActionLayout(named = "Buscar Socio por Apellido")
    @MemberOrder(sequence = "5")
    /**
     * Este metodo permite encontrar una Persona en particular
     * dado un apellido
     *
     * @param apellido
     * @return List<Socio>
     */
    public List<Socio> findByApellido(@ParameterLayout(named = "Apellido") final String apellido) {
        return socioRepository.findByApellido(apellido);
    }

    @Action()
    @ActionLayout(named = "Buscar Socio por Dni")
    @MemberOrder(sequence = "6")
    /**
     * Este metodo permite encontrar una Persona en particular
     * dado un dni
     *
     * @param dni
     * @return List<Socio>
     */
    public List<Socio> findByDni(@ParameterLayout(named = "Dni") final Integer dni) {
        return socioRepository.findByDni(dni);
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
