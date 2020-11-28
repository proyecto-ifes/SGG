package domainapp.modules.simple.dominio.reportes;

import domainapp.modules.simple.dominio.enums.Estado;

@lombok.Getter @lombok.Setter
public class SociosReporte {

    private String nombre;
    private String apellido;
    private Integer dni;
    private Integer telefono;
    private Estado estado;

    public SociosReporte(String nombre, String apellido, Integer dni, Integer telefono, Estado estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.estado = estado;
    }

    public SociosReporte() {
    }
}
