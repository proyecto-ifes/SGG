package domainapp.modules.simple.dom.impl.pagos;

import domainapp.modules.simple.dom.impl.socio.Socio;
import lombok.Getter;
import lombok.Setter;
import org.apache.isis.applib.annotation.*;
import org.apache.isis.schema.utils.jaxbadapters.JodaDateTimeStringAdapter;
import org.joda.time.LocalDate;

import javax.jdo.annotations.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@PersistenceCapable(identityType= IdentityType.DATASTORE, schema="gimnasio", table="pagos")
@javax.jdo.annotations.DatastoreIdentity(strategy=javax.jdo.annotations.IdGeneratorStrategy.IDENTITY, column="idPago")
@DomainObject(auditing = Auditing.ENABLED)
@DomainObjectLayout()
public class Pago  implements  Comparable<Pago>{

    @javax.jdo.annotations.Column(allowsNull = "false")
    @lombok.NonNull
    @Property(editing = Editing.ENABLED)
    @Getter @Setter
    private Socio socio;


    @javax.jdo.annotations.Column(allowsNull = "false")
    @lombok.NonNull
    @Property(editing = Editing.ENABLED)
    //cantidad de dias que entrena a la semana
    private int diasPorSem;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @lombok.NonNull
    @Property(editing = Editing.ENABLED)
    //total a pagar
    private int monto;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @lombok.NonNull
    @Property(editing = Editing.ENABLED)
    @XmlJavaTypeAdapter(JodaDateTimeStringAdapter.ForJaxb.class)
    private LocalDate fechaDePago;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @lombok.NonNull
    @Property(editing = Editing.ENABLED)
    @XmlJavaTypeAdapter(JodaDateTimeStringAdapter.ForJaxb.class)
    private LocalDate proximoPago;


    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public int getDiasPorSem() {
        return diasPorSem;
    }

    public void setDiasPorSem(int diasPorSem) {
        this.diasPorSem = diasPorSem;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public LocalDate getFechaDePago() {
        return fechaDePago;
    }

    public void setFechaDePago(LocalDate fechaDePago) {
        this.fechaDePago = fechaDePago;
    }

    public LocalDate getProximoPago() {
        return proximoPago;
    }

    public void setProximoPago(LocalDate proximoPago) {
        this.proximoPago = proximoPago;
    }

    @Override
    public int compareTo(Pago o) {
        return org.apache.isis.applib.util.ObjectContracts.compare(this, o, "socio", "diasPorSem", "monto", "fechaDePago", "proximoPago"  );
    }

    @Override
    public String toString() {
        return "Pago{" +
                "socio=" + socio +
                ", diasPorSem=" + diasPorSem +
                ", monto=" + monto +
                ", fechaDePago=" + fechaDePago +
                ", proximoPago=" + proximoPago +
                '}';
    }

}
