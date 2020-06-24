package domainapp.modules.simple.dom.impl.socio;

import org.datanucleus.query.typesafe.*;
import org.datanucleus.api.jdo.query.*;

public class QSocio extends domainapp.modules.simple.dom.impl.persona.QPersona
{
    public static final QSocio jdoCandidate = candidate("this");

    public static QSocio candidate(String name)
    {
        return new QSocio(null, name, 5);
    }

    public static QSocio candidate()
    {
        return jdoCandidate;
    }

    public static QSocio parameter(String name)
    {
        return new QSocio(Socio.class, name, ExpressionType.PARAMETER);
    }

    public static QSocio variable(String name)
    {
        return new QSocio(Socio.class, name, ExpressionType.VARIABLE);
    }

    public final StringExpression historiaClinica;
    public final ObjectExpression<java.lang.Integer> nroEmergencia;
    public final ObjectExpression<java.lang.Integer> peso;
    public final ObjectExpression<java.lang.Integer> altura;
    public final ObjectExpression<java.lang.Boolean> asistencia;

    public QSocio(PersistableExpression parent, String name, int depth)
    {
        super(parent, name, depth);
        this.historiaClinica = new StringExpressionImpl(this, "historiaClinica");
        this.nroEmergencia = new ObjectExpressionImpl<java.lang.Integer>(this, "nroEmergencia");
        this.peso = new ObjectExpressionImpl<java.lang.Integer>(this, "peso");
        this.altura = new ObjectExpressionImpl<java.lang.Integer>(this, "altura");
        this.asistencia = new ObjectExpressionImpl<java.lang.Boolean>(this, "asistencia");
    }

    public QSocio(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
        this.historiaClinica = new StringExpressionImpl(this, "historiaClinica");
        this.nroEmergencia = new ObjectExpressionImpl<java.lang.Integer>(this, "nroEmergencia");
        this.peso = new ObjectExpressionImpl<java.lang.Integer>(this, "peso");
        this.altura = new ObjectExpressionImpl<java.lang.Integer>(this, "altura");
        this.asistencia = new ObjectExpressionImpl<java.lang.Boolean>(this, "asistencia");
    }
}
