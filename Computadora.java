public class Computadora extends DispElectronico {
    private String marca;

    public Computadora(int Id, String marca, boolean encendido) {
        super(Id,encendido);
        this.marca = marca;
    }


    public String getMarcaModelo() {
        return  marca;
    }
}
