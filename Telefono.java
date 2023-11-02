public class Telefono extends DispElectronico {
    private String modelo;


    public Telefono(int Id,String modelo, boolean encendido) {
        super(Id,encendido);
        this.modelo = modelo;
     
    }

    public String getMarcaModelo() {
        return modelo; 
    }
}
