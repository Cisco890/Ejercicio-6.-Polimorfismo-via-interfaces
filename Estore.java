import java.util.Scanner;

public class Estore {
    
    public static void main(String[] args) {
        Data data = new Data();
        Scanner scanner = new Scanner(System.in);

        data.crearDispositivosDesdeCSV(); // Cargar los dispositivos desde el archivo CSV

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Mostrar datos de todos los dispositivos");
            System.out.println("2. Apagar dispositivo");
            System.out.println("3. Encender dispositivo");
            System.out.println("4. Salir");
        
            System.out.print("Ingrese la opción deseada: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea
        
            switch (opcion) {
                case 1:
                    data.desplegarInformacion();
                    data.validarEstadoDispositivos();
                    break;
                case 2:
                    System.out.print("Ingrese el ID del dispositivo que desea apagar: ");
                    int idApagar = scanner.nextInt();
                    scanner.nextLine();
                    data.cambiarEstadoDispositivo(idApagar, false); // Cambiar a apagado
                    break;
                case 3:
                    System.out.print("Ingrese el ID del dispositivo que desea encender: ");
                    int idEncender = scanner.nextInt();
                    scanner.nextLine();
                    data.cambiarEstadoDispositivo(idEncender, true); // Cambiar a encendido
                    break;
                case 4:
                    System.out.println("Saliendo del programa.");
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