package domainapp.modules.simple.dominio.socio;

import domainapp.modules.simple.dominio.asistencia.AsistenciaSocio;
import domainapp.modules.simple.dominio.enums.Estado;
import domainapp.modules.simple.dominio.enums.EstadoMeta;
import domainapp.modules.simple.dominio.enums.TipoTurno;
import domainapp.modules.simple.dominio.meta.Meta;
import domainapp.modules.simple.dominio.pagos.Pago;
import domainapp.modules.simple.dominio.pagos.PagoRepository;
import domainapp.modules.simple.dominio.persona.Persona;
import domainapp.modules.simple.dominio.rutina.Rutina;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.factory.FactoryService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.isisaddons.module.security.dom.user.ApplicationUser;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

import javax.jdo.annotations.*;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Pattern;

@PersistenceCapable(identityType= IdentityType.DATASTORE, schema="gimnasio", table="socios")

@Queries({
    @Query(name = "findByApellido", language = "JDOQL",
            value = "SELECT "
                + "FROM domainapp.modules.simple.dominio.socio.Socio "
                + "WHERE apellido == :apellido "),

    @Query(name = "findByDni", language = "JDOQL",
            value = "SELECT "
                    + "FROM domainapp.modules.simple.dominio.socio.Socio "
                    + "WHERE dni == :dni ")
})

@DomainObject(auditing = Auditing.ENABLED)
@DomainObjectLayout()  // causes UI events to be triggered
@Unique(name="Socio_dni_UNQ", members = {"dni"})
@lombok.Getter @lombok.Setter

public class Socio extends Persona {

    @Column(allowsNull = "false")
    @lombok.NonNull
    @Property()
    private String historiaClinica;

    @Column(allowsNull = "true")
    @Property()
    private Integer nroEmergencia;

    @Column(allowsNull = "true")
    @Property()
    private Integer peso;

    @Column(allowsNull = "true")
    @Property()
    private Integer altura;

    @Persistent(mappedBy = "socio", dependentElement = "true")
    @Collection()
    private List<Rutina> rutina = new ArrayList<Rutina>();

    @Persistent(mappedBy = "socio", dependentElement = "true")
    @Collection()
    private List<Pago> pago = new ArrayList<Pago>();

    @Persistent(mappedBy = "socio", dependentElement = "true")
    @Collection()
    private List<AsistenciaSocio> asistenciaSocio = new ArrayList<AsistenciaSocio>();

    @Persistent(mappedBy = "socio", dependentElement = "true")
    @Collection()
    private List<Meta> meta = new ArrayList<Meta>();

    @Getter
    @Setter
    private SortedSet<ApplicationUser> usuario = new TreeSet<>();

    public Socio() {
    }

    public Socio(String nombre, String apellido, Integer dni, Integer telefono, String direccion, LocalDate fechaNac, Estado estado, String historiaClinica, Integer nroEmergencia, Integer peso, Integer altura) {
        super(nombre, apellido, dni, telefono, direccion, fechaNac, estado);
        this.historiaClinica = historiaClinica;
        this.nroEmergencia = nroEmergencia;
        this.peso = peso;
        this.altura = altura;
    }

    public Socio(String nombre, String apellido, Integer dni, Integer telefono, String direccion, LocalDate fechaNac, Estado estado, String historiaClinica, Integer nroEmergencia, Integer peso, Integer altura, List<Rutina> rutina, List<Pago> pago) {
        super(nombre, apellido, dni, telefono, direccion, fechaNac, estado);
        this.historiaClinica = historiaClinica;
        this.nroEmergencia = nroEmergencia;
        this.peso = peso;
        this.altura = altura;
        this.rutina = rutina;
        this.pago = pago;
    }

    @Action()
    @ActionLayout(named = "Editar")
    public Socio update(
            @ParameterLayout(named = "Numero de telefono: ")
            final Integer telefono,

            @ParameterLayout(named = "Direccion: ")
            final String direccion,

            @ParameterLayout(named = "Numero de Emergencia: ")
            final Integer nroEmergencia,

            @ParameterLayout(named = "Peso: ")
            final Integer peso,

            @ParameterLayout(named = "Altura: ")
            final Integer altura,

            @ParameterLayout(named = "Historia Clinica: ")
            final String historiaClinica
    ){

        this.setTelefono(telefono);
        this.setDireccion(direccion);
        this.setNroEmergencia(nroEmergencia);
        this.setPeso(peso);
        this.setAltura(altura);
        this.setHistoriaClinica(historiaClinica);
        return this;
    }

    public Integer default0Update() { return getTelefono(); }
    public String default1Update()  { return getDireccion(); }
    public Integer default2Update() { return getNroEmergencia(); }
    public Integer default3Update() { return getPeso(); }
    public Integer default4Update() { return getAltura(); }
    public String default5Update() { return getHistoriaClinica(); }

    public void addToUser(final ApplicationUser applicationUser)
    {
        getUsuario().add(applicationUser);
    }

    public Socio addUser(@ParameterLayout(named="Usuario: ") final ApplicationUser user) {
        addToUser(user);
        return this;
    }

    @Action()
    @MemberOrder(name="user", sequence = "1")
    @ActionLayout(named = "Añadir Usuario")
    public Socio AgregarUsuario (final ApplicationUser user ){
        return  usuario.size() < 1 ? this.addUser(user) : null;
    }

    @Action()
    @ActionLayout(named = "Dar Asistencia")
    public Socio addAsistencia(
            @ParameterLayout(named="Tipo de Turno") final TipoTurno tipoTurno
    ){

        final AsistenciaSocio asistenciaSocio = factoryService.instantiate(AsistenciaSocio.class);
        asistenciaSocio.setSocio(this);
        asistenciaSocio.setTipoTurno(tipoTurno);
        LocalDateTime fechaYHora = LocalDateTime.now();
        asistenciaSocio.setFechaYHora(fechaYHora);
        getAsistenciaSocio().add(asistenciaSocio);
        repositoryService.persist(asistenciaSocio);
        return this;
    }

    @Action()
    @ActionLayout(named = "Cargar Pago")
    public Socio addPago(
            @ParameterLayout(named="Dias Por Semana") final int diasPorSem,
            @ParameterLayout(named="Monto a Pagar") final int monto,
            @ParameterLayout(named="Fecha de Pago") final LocalDate fechaDePago,
            @ParameterLayout(named="Fecha de Proximo Pago") final LocalDate proximoPago
    ){

        final Pago pago = factoryService.instantiate(Pago.class);
        pago.setSocio(this);
        pago.setDiasPorSem(diasPorSem);
        pago.setMonto(monto);
        pago.setFechaDePago(fechaDePago);
        pago.setProximoPago(proximoPago);
        getPago().add(pago);
        repositoryService.persist(pago);

        return this;
    }

    @Action()
    @ActionLayout(named = "Cargar Rutina")
    public Socio addRutina(
            @Parameter(
                    regexPattern = "[A-Za-z]+",
                    regexPatternFlags = Pattern.CASE_INSENSITIVE,
                    regexPatternReplacement = "Ingrese solo letras"
            )
            @ParameterLayout(named="Nombre: ") final String nombre,
            @ParameterLayout(named="Estado: ") final Estado estado
    ){
        final Rutina rutina = factoryService.instantiate(Rutina.class);
        rutina.setSocio(this);
        rutina.setNombre(nombre);
        rutina.setEstado(estado);
        getRutina().add(rutina);
        repositoryService.persist(rutina);
        return this;
    }

    @Action()
    @ActionLayout(named = "Cargar Meta")
    public Socio addMeta(
            @ParameterLayout(named="Descripcion: ") final String descripcion,
            @ParameterLayout(named="Estado: ") final EstadoMeta estadoMeta
    ){
        final Meta meta = factoryService.instantiate(Meta.class);
        meta.setSocio(this);
        meta.setDescripcion(descripcion);
        meta.setEstadoMeta(estadoMeta);
        getMeta().add(meta);
        repositoryService.persist(meta);
        return this;
    }

    @Programmatic
    public void CambiarEstado(Estado estado){
        this.setEstado(estado);
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT_ARE_YOU_SURE)
    @ActionLayout(named = "Activar/Desactivar")
    public Socio Estado(){
        if(this.getEstado()==Estado.Activo){
            CambiarEstado(Estado.Inactivo);
        }else {
            CambiarEstado(Estado.Activo);
        }

        return this;
    }

    @NotPersistent
    @CollectionLayout(named = "Pagos")
    public List<Pago> getPagos() {
        return pagoRepository.ListarPorSocio(this);
    }

    @javax.inject.Inject
    @NotPersistent
    @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
    FactoryService factoryService;

    @javax.inject.Inject
    @NotPersistent
    @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
    RepositoryService repositoryService;

    @javax.inject.Inject
    @NotPersistent
    @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
    PagoRepository pagoRepository;

}
