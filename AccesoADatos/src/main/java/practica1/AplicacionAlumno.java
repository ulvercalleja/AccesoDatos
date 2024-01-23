package practica1;

public class AplicacionAlumno {
    public static void main(String[] args) {
        AlumnoInterface objetoDAO = FactoriaAlumnos.getAlumnoDao();
        java.util.Collection<AlumnoInterface> alumnoJuan = objetoDAO.getAlumnoPorNombre("Juan Perez");
        
        if(alumnoJuan.isEmpty()){
            System.out.println("No hay alumnos que se llamen Juan.");
        } else {
            System.out.println
        
        ("Borrando alumnos que se llamen Juan.");
            System.out.print("-------------------------------------------------------");
        }
    }
}
  
