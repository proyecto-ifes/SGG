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
@lombok.Getter @lombok.Setter
public class Pago  {

    @javax.jdo.annotations.Column(allowsNull = "false")
    @lombok.NonNull
    @Property()
    @Getter @Setter
    private Socio socio;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @lombok.NonNull
    @Property()
    //cantidad de dias que entrena a la semana
    private int diasPorSem;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @lombok.NonNull
    @Property()
    //total a pagar
    private int monto;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @lombok.NonNull
    @Property()
    @XmlJavaTypeAdapter(JodaDateTimeStringAdapter.ForJaxb.class)
    @Title(prepend = "Pago: ")
    private LocalDate fechaDePago;

    @javax.jdo.annotations.Column(allowsNull = "false")
    @lombok.NonNull
    @Property()
    @XmlJavaTypeAdapter(JodaDateTimeStringAdapter.ForJaxb.class)
    private LocalDate proximoPago;



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
