package domainapp.modules.simple.dominio.socio;

import domainapp.modules.simple.dominio.enums.Estado;
import domainapp.modules.simple.dominio.reportes.EjecutarReportes;
import net.sf.jasperreports.engine.JRException;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.eventbus.ActionDomainEvent;
import org.apache.isis.applib.value.Blob;
import org.joda.time.LocalDate;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

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
            @Parameter(
                    regexPattern = "[A-Za-z]+",
                    regexPatternFlags = Pattern.CASE_INSENSITIVE,
                    regexPatternReplacement = "Ingrese solo letras"
            )
            @ParameterLayout(named="Nombre") final String nombre,

            @Parameter(
                    regexPattern = "[A-Za-z]+",
                    regexPatternFlags = Pattern.CASE_INSENSITIVE,
                    regexPatternReplacement = "Ingrese solo letras"
            )
            @ParameterLayout(named="Apellido") final String apellido,
            @ParameterLayout(named="DNI") final Integer dni,
            @ParameterLayout(named="Telefono") final Integer telefono,
            @ParameterLayout(named="Direccion") final String direccion,
            @ParameterLayout(named="FechaNac") final LocalDate fechaNac,
            @ParameterLayout(named="Estado") final Estado estado,
            @ParameterLayout(named="HistoriaClinica") final String historiaClinica,
            @ParameterLayout(named="NroEmergencia") final Integer nroEmergencia,
            @ParameterLayout(named="Peso") final Integer peso,
            @ParameterLayout(named="Altura") final Integer altura
    ) {

        return socioRepository.create(
                nombre.toUpperCase(),
                apellido.toUpperCase(),
                dni,
                telefono,
                direccion,
                fechaNac,
                estado,
                historiaClinica,
                nroEmergencia,
                peso,
                altura);
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

    @Action()
    @ActionLayout(named = "Exportar Listado a PDF")
    public Blob ExportarListado() throws JRException, IOException {
        EjecutarReportes ejecutarReportes = new EjecutarReportes();
        return ejecutarReportes.ListadoSociosPDF(socioRepository.listAll());
    }

    @Inject
    SocioRepository socioRepository;

}
