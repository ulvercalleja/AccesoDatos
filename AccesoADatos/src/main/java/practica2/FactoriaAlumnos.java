package practica2;

public class FactoriaAlumnos {
    public static AlumnoInterface getAlumnoDao() {
        return new AlumnoBean();
    }
}