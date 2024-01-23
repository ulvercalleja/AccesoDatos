package practica6;

public class Aplicacion {
    public static void main(String[] args) {
        BD_Alumnos_Menu bdAlumnosMenu = new BD_Alumnos_Menu();
        bdAlumnosMenu.listarTablas();

        int opcion = Leer.leerEntero("Seleccione una tabla (1: alumnos, 2: alumnos_asignaturas, 3: asignaturas): ");
        
        switch (opcion) {
            case 1:
                bdAlumnosMenu.mostrarTabla("alumnos");
                break;
            case 2:
                bdAlumnosMenu.mostrarTabla("alumnos_asignaturas");
                break;
            case 3:
                bdAlumnosMenu.mostrarTabla("asignaturas");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
}

