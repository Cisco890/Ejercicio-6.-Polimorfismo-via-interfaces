import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Data {
    private List<DispElectronico> DispElectronico = new ArrayList<>();

    public void crearDispositivosDesdeCSV() {
        try {
            File file = new File("dispositivos.csv");
            if (file.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String linea;
                boolean primeraLinea = true;
    
                while ((linea = br.readLine()) != null) {
                    if (primeraLinea) {
                        primeraLinea = false;
                        continue;  // Saltar la primera línea
                    }
    
                    String[] datos = linea.split(",");
                    int id = Integer.parseInt(datos[0]); // Leer el primer valor como ID
                    String tipo = datos[1]; // El tipo se encuentra en el segundo campo (índice 1)
                    String marcaModelo = datos[2]; // El modelo se encuentra en el tercer campo (índice 2)
                    boolean encendido = datos[3].equalsIgnoreCase("true"); // Comparación insensible a mayúsculas/minúsculas
    
                    if (tipo.equals("Telefono")) {
                        Telefono telefono = new Telefono(id, marcaModelo, encendido);
                        DispElectronico.add(telefono);
                    } else if (tipo.equals("Computadora")) {
                        Computadora computadora = new Computadora(id, marcaModelo, encendido);
                        DispElectronico.add(computadora);
                    }
                }
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void desplegarInformacion() {
        for (DispElectronico dispositivo : DispElectronico) {
            System.out.println("ID: " + dispositivo.getID()); // Muestra el ID
            System.out.println("Dispositivo: " + dispositivo.getClass().getSimpleName());
            System.out.println("Marca/Modelo: " + dispositivo.getMarcaModelo());
            System.out.println("Estado: " + (dispositivo.Encendido() ? "Encendido" : "Apagado"));
            System.out.println();
        }
    }

    public void validarEstadoDispositivos() {
        for (DispElectronico dispositivo : DispElectronico) {
            System.out.println("Dispositivo: " + dispositivo.getClass().getSimpleName());
            System.out.println("Estado: " + (dispositivo.Encendido() ? "Encendido" : "Apagado"));
            System.out.println();
        }
    }

    public void guardarEnCSV() {
        try {
            FileWriter writer = new FileWriter("dispositivos.csv");
            BufferedWriter bw = new BufferedWriter(writer);
    
            for (DispElectronico dispositivo : DispElectronico) {
                String estado = dispositivo.Encendido() ? "Encendido" : "Apagado";
                String linea = dispositivo.getClass().getSimpleName() + ","
                        + dispositivo.getMarcaModelo() + ","
                        + estado + ","
                        + dispositivo.getID(); // Agregar el Id
                bw.write(linea);
                bw.newLine();
            }
    
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public void leerDesdeCSV() {
        try {
            File file = new File("dispositivos.csv");
            if (file.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String linea;
                boolean primeraLinea = true;
    
                while ((linea = br.readLine()) != null) {
                    if (primeraLinea) {
                        primeraLinea = false;
                        continue;  // Saltar la primera línea
                    }
    
                    String[] datos = linea.split(",");
                    int id = Integer.parseInt(datos[0]); // Leer el primer valor como ID
                    String tipo = datos[1];
                    String marcaModelo = datos[2];
                    boolean encendido = datos[3].equals("true");
    
                    System.out.println("Id: " + id);
                    System.out.println("Dispositivo: " + tipo);
                    System.out.println("Marca/Modelo: " + marcaModelo);
                    System.out.println("Estado: " + (encendido ? "Encendido" : "Apagado"));
                    System.out.println();
                }
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    
    
    public void cambiarEstadoDispositivo(int id, boolean encender) {
        for (DispElectronico dispositivo : DispElectronico) {
            if (dispositivo.getID() == id) {
                if (encender) {
                    dispositivo.encender();
                } else {
                    dispositivo.apagar();
                }
                return;
            }
        }
        System.out.println("No se encontró ningún dispositivo con el ID especificado.");
    }   
}