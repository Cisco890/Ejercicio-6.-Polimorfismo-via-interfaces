/** Juan Francisco Martínez 23617

  * Computadora
 
  * @param id,marca,encendido
  * @throws es la clase que se encarga de las computadoras, tiene id, marca y encendido(que mira el estado [encendido ó apagado]), implementa a DispElectronico 

  */
public class Computadora implements DispElectronico {//cracion del objeto Computadora que implementa a la interfaz Dispelectronico
    private int Id;
    private String marca;
    private boolean encendido;

    public Computadora(int Id, String marca, boolean encendido) {
        this.Id = Id;
        this.marca = marca;
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
        return marca;
    }
}

