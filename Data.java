/** Juan Francisco Martínez 23617

  * Data
 
  * @param Lo que se ingresa en el menú y el csv
  * @throws es la clase que se encarga de leer el csv, acá también está el código que busca por id y demás funciones

  */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
// importar librerias
public class Data {
    private List<DispElectronico> DispElectronico = new ArrayList<>();// cración del array list para guardar los dispositivos electronicos

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
    
                    if ("Telefono".equals(tipo)) {
                        Telefono telefono = new Telefono(id, marcaModelo, encendido);
                        DispElectronico.add(telefono);
                    } else if ("Computadora".equals(tipo)) {
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
    // creación de dispositivos electrónicos según el csv

    public void desplegarInformacion() {// desplegar la información del csv cuando se presiona 1 en el menú
        List<Integer> dispositivosMostrados = new ArrayList<>();

        for (DispElectronico dispositivo : DispElectronico) {
            int id = dispositivo.getID();
            if (!dispositivosMostrados.contains(id)) {
                System.out.println("ID: " + id); // Muestra el ID
                System.out.println("Dispositivo: " + dispositivo.getClass().getSimpleName());
                System.out.println("Marca/Modelo: " + dispositivo.getMarcaModelo());
                System.out.println("Estado: " + (dispositivo.Encendido() ? "Encendido" : "Apagado"));
                System.out.println();

                // Agregar el ID a la lista de dispositivos mostrados
                dispositivosMostrados.add(id);
            }
        }
    }

    

    public void guardarEnCSV() {// guardar los nuevos datos en el csv cuando se presiona 2 o 3 en el menú
        try {
            FileWriter writer = new FileWriter("dispositivos.csv");
            BufferedWriter bw = new BufferedWriter(writer);
    
            // Escribe el encabezado en el archivo CSV
            bw.write("Id,Tipo,MarcaModelo,Estado");
            bw.newLine();
    
            for (DispElectronico dispositivo : DispElectronico) {
                String estado = dispositivo.Encendido() ? "true" : "false"; // Cambia a true o false
                String linea = dispositivo.getID() + "," +
                        dispositivo.getClass().getSimpleName() + "," +
                        dispositivo.getMarcaModelo() + "," +
                        estado;
                bw.write(linea);
                bw.newLine();
            }
    
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
    

    public void leerDesdeCSV() {// leer el csv
        try {
            File file = new File("dispositivos.csv");
            if (file.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String linea;
                boolean primeraLinea = true;
    
                while ((linea = br.readLine()) != null) {
                    if (primeraLinea) {
                        primeraLinea = false;
                        continue;  // Saltar la primera línea(encabezado)
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
    
    public void cambiarEstadoDispositivo(int id, boolean encender) {// funcion para cambiar el estado del dispositivo
        for (DispElectronico dispositivo : DispElectronico) {
            if (dispositivo.getID() == id) {
                if (encender) {
                    dispositivo.encender();
                } else {
                    dispositivo.apagar();
                }
                // Actualiza el archivo CSV
                guardarEnCSV();
                return;
            }
        }
        System.out.println("No se encontró ningún dispositivo con el ID especificado.");
    }  
}