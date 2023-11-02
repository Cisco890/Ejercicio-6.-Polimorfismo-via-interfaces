/** Juan Francisco Martínez 23617

  * DispElectronico
 
  * @param Encendido,encender,aoagar,getID,getMarcaModelo
  * @throws interfaz que se encarga de prestar sus atributos a Telefono y COmputadora

  */
public interface DispElectronico {//interfaz de dispositivo electronico
    boolean Encendido();
    void encender();
    void apagar();
    int getID();// le decidí agregar ID para que fuera más fácil buscar los productos
    String getMarcaModelo();
}


 