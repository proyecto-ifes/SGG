package domainapp.modules.simple.dom.impl.socio;

import domainapp.modules.simple.dom.impl.enums.Estado;
import domainapp.modules.simple.dom.impl.pagos.Pago;
import domainapp.modules.simple.dom.impl.persona.Persona;
import domainapp.modules.simple.dom.impl.rutina.Rutina;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.applib.services.factory.FactoryService;
import org.apache.isis.applib.services.repository.RepositoryService;
import org.joda.time.LocalDate;

import javax.jdo.annotations.*;
import java.util.ArrayList;
import java.util.List;

@PersistenceCapable(identityType= IdentityType.DATASTORE, schema="gimnasio", table="socios")

@Queries({
    @Query(name = "findByApellido", language = "JDOQL",
            value = "SELECT "
                + "FROM domainapp.modules.simple.dom.impl.socio.Socio "
                + "WHERE apellido == :apellido "),

    @Query(name = "findByDni", language = "JDOQL",
            value = "SELECT "
                    + "FROM domainapp.modules.simple.dom.impl.socio.Socio "
                    + "WHERE dni == :dni ")
})


@DomainObject(auditing = Auditing.ENABLED)
@DomainObjectLayout()  // causes UI events to be triggered
@javax.jdo.annotations.Unique(name="Socio_dni_UNQ", members = {"dni"})
@lombok.Getter @lombok.Setter


public class Socio extends Persona  {

    @javax.jdo.annotations.Column(allowsNull = "false")
    @lombok.NonNull
    @Property()
    private String historiaClinica;

    @Column(allowsNull = "true")
    @Property()
    private Integer nroEmergencia;

    @javax.jdo.annotations.Column(allowsNull = "true")
    @Property()
    private Integer peso;

    @javax.jdo.annotations.Column(allowsNull = "true")
    @Property()
    private Integer altura;

    @javax.jdo.annotations.Column(allowsNull = "true")
    @Property()
    private Boolean asistencia;

    @Persistent(mappedBy = "socio", dependentElement = "true")
    @Collection()
    @Getter @Setter
    private List<Rutina> rutina = new ArrayList<Rutina>();

    @Persistent(mappedBy = "socio", dependentElement = "true")
    @Collection()
    @Getter  @Setter
    private List<Pago> pago = new ArrayList<Pago>();

    public Socio() {
    }

    public Socio(String nombre, String apellido, Integer dni, Integer telefono, String direccion, LocalDate fechaNac, Estado estado, String historiaClinica, Integer nroEmergencia, Integer peso, Integer altura, Boolean asistencia) {
        super(nombre, apellido, dni, telefono, direccion, fechaNac, estado);
        this.historiaClinica = historiaClinica;
        this.nroEmergencia = nroEmergencia;
        this.peso = peso;
        this.altura = altura;
        this.asistencia = asistencia;
    }

    public Socio(String nombre, String apellido, Integer dni, Integer telefono, String direccion, LocalDate fechaNac, Estado estado, String historiaClinica, Integer nroEmergencia, Integer peso, Integer altura, Boolean asistencia, List<Rutina> rutina, List<Pago> pago) {
        super(nombre, apellido, dni, telefono, direccion, fechaNac, estado);
        this.historiaClinica = historiaClinica;
        this.nroEmergencia = nroEmergencia;
        this.peso = peso;
        this.altura = altura;
        this.asistencia = asistencia;
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

    @Programmatic
    public void CambiarEstado(Estado estado){
        this.setEstado(estado);
    }

    @Action()
    @ActionLayout(named = "Activar")
    public Socio Activo(){
        CambiarEstado(Estado.Activo);
        return this;
    }

    @Action(semantics = SemanticsOf.IDEMPOTENT_ARE_YOU_SURE)
    @ActionLayout(named = "Desactivar")
    public Socio Inactivo(){
        CambiarEstado(Estado.Inactivo);
        return this;
    }

    @javax.inject.Inject
    @javax.jdo.annotations.NotPersistent
    @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
    FactoryService factoryService;

    @javax.inject.Inject
    @javax.jdo.annotations.NotPersistent
    @lombok.Getter(AccessLevel.NONE) @lombok.Setter(AccessLevel.NONE)
    RepositoryService repositoryService;

}
