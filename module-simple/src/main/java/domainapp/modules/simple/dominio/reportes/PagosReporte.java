package domainapp.modules.simple.dominio.reportes;
import domainapp.modules.simple.dominio.enums.Estado;

@lombok.Getter @lombok.Setter
public class PagosReporte {

    private String nombre;
    private String apellido;
    private Integer dni;
    private Integer monto;
    private String fechaDePago;
    private Estado estado;

    public PagosReporte(String nombre, String apellido, Integer dni, Integer monto, String fechaDePago, Estado estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.monto = monto;
        this.fechaDePago = fechaDePago;
        this.estado = estado;
    }

    public PagosReporte() {
    }
}
