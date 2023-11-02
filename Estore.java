/** Juan Francisco Martínez 23617

  * Estrore
 
  * @param main del programa
  * @throws es el main driver del programa, tiene un menú que se encarga de hacer las funciones necesarias
  */
import java.util.Scanner;
//importar libreria
public class Estore {
    //creación del main
    public static void main(String[] args) {
        Data data = new Data();
        Scanner scanner = new Scanner(System.in);

        data.crearDispositivosDesdeCSV(); // Cargar los dispositivos desde el archivo CSV

        while (true) {//inicio del switch para el menu
            System.out.println("Menú:");
            System.out.println("1. Mostrar datos de todos los dispositivos");
            System.out.println("2. Apagar dispositivo");
            System.out.println("3. Encender dispositivo");
            System.out.println("4. Salir");
        
            System.out.print("Ingrese la opción deseada: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // pasar a la nueva línea
        
            switch (opcion) {
                case 1:
                    data.desplegarInformacion();
                    break;//opción para mostrar la información de todos los datos
                case 2:
                    System.out.print("Ingrese el ID del dispositivo que desea apagar: ");// opcion para cambiar el estado a apagado
                    int idApagar = scanner.nextInt();
                    scanner.nextLine();
                    data.cambiarEstadoDispositivo(idApagar, false); 
                    data.guardarEnCSV(); // Guardar cambios en el CSV
                    break;
                case 3:
                    System.out.print("Ingrese el ID del dispositivo que desea encender: ");// opción oara cambiar el estado a encendido
                    int idEncender = scanner.nextInt();
                    scanner.nextLine();
                    data.cambiarEstadoDispositivo(idEncender, true); 
                    data.guardarEnCSV(); // Guardar cambios en el CSV
                    break;
                case 4:
                    System.out.println("Saliendo del programa.");// salir del programa
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }
}