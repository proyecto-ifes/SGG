package domainapp.modules.simple.dom.impl.persona;

import org.datanucleus.query.typesafe.*;
import org.datanucleus.api.jdo.query.*;

public class QPersona extends PersistableExpressionImpl<Persona> implements PersistableExpression<Persona>
{
    public static final QPersona jdoCandidate = candidate("this");

    public static QPersona candidate(String name)
    {
        return new QPersona(null, name, 5);
    }

    public static QPersona candidate()
    {
        return jdoCandidate;
    }

    public static QPersona parameter(String name)
    {
        return new QPersona(Persona.class, name, ExpressionType.PARAMETER);
    }

    public static QPersona variable(String name)
    {
        return new QPersona(Persona.class, name, ExpressionType.VARIABLE);
    }

    public final StringExpression nombre;
    public final StringExpression apellido;
    public final ObjectExpression<java.lang.Integer> dni;
    public final ObjectExpression<java.lang.Integer> telefono;
    public final StringExpression direccion;
    public final ObjectExpression<org.joda.time.LocalDate> fechaNac;
    public final ObjectExpression<java.lang.Integer> estado;

    public QPersona(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.nombre = new StringExpressionImpl(this, "nombre");
        this.apellido = new StringExpressionImpl(this, "apellido");
        this.dni = new ObjectExpressionImpl<java.lang.Integer>(this, "dni");
        this.telefono = new ObjectExpressionImpl<java.lang.Integer>(this, "telefono");
        this.direccion = new StringExpressionImpl(this, "direccion");
        this.fechaNac = new ObjectExpressionImpl<org.joda.time.LocalDate>(this, "fechaNac");
        this.estado = new ObjectExpressionImpl<java.lang.Integer>(this, "estado");
    }

    public QPersona(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.nombre = new StringExpressionImpl(this, "nombre");
        this.apellido = new StringExpressionImpl(this, "apellido");
        this.dni = new ObjectExpressionImpl<java.lang.Integer>(this, "dni");
        this.telefono = new ObjectExpressionImpl<java.lang.Integer>(this, "telefono");
        this.direccion = new StringExpressionImpl(this, "direccion");
        this.fechaNac = new ObjectExpressionImpl<org.joda.time.LocalDate>(this, "fechaNac");
        this.estado = new ObjectExpressionImpl<java.lang.Integer>(this, "estado");
    }
}
