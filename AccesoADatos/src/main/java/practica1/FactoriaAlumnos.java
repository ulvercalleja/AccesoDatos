package practica1;

public class FactoriaAlumnos {
    public static AlumnoInterface getAlumnoDao() {
        return new AlumnoBean();
    }
}