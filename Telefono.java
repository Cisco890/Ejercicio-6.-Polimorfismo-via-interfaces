/** Juan Francisco Martínez 23617

  * Telefono
 
  * @param id,modelo,encendido
  * @throws es la clase que se encarga de los telefonos, tiene id, modelo y encendido(que mira el estado [encendido ó apagado]) implementa a DispElectronico 

  */
public class Telefono implements DispElectronico {//cracion del objeto Telefono que implementa a la interfaz Dispelectronico
    private int Id;
    private String modelo;
    private boolean encendido;

    public Telefono(int Id, String modelo, boolean encendido) {
        this.Id = Id;
        this.modelo = modelo;
        this.encendido = encendido;
    }

    public boolean Encendido() {
        return encendido;
    }

    public void encender() {
        encendido = true;
    }

    public void apagar() {
        encendido = false;
    }

    public int getID() {
        return Id;
    }

    public String getMarcaModelo() {
        return modelo;
    }
}
