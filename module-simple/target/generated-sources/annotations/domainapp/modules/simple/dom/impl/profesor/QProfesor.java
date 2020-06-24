package domainapp.modules.simple.dom.impl.profesor;

import org.datanucleus.query.typesafe.*;
import org.datanucleus.api.jdo.query.*;

public class QProfesor extends domainapp.modules.simple.dom.impl.persona.QPersona
{
    public static final QProfesor jdoCandidate = candidate("this");

    public static QProfesor candidate(String name)
    {
        return new QProfesor(null, name, 5);
    }

    public static QProfesor candidate()
    {
        return jdoCandidate;
    }

    public static QProfesor parameter(String name)
    {
        return new QProfesor(Profesor.class, name, ExpressionType.PARAMETER);
    }

    public static QProfesor variable(String name)
    {
        return new QProfesor(Profesor.class, name, ExpressionType.VARIABLE);
    }


    public QProfesor(PersistableExpression parent, String name, int depth)
    {
        super(parent, name, depth);
    }

    public QProfesor(Class type, String name, ExpressionType exprType)
    {
        super(type, name, exprType);
    }
}
