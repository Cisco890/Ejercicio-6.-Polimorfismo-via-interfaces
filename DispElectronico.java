public abstract class DispElectronico {
    private boolean encendido;
    private int Id;

    public DispElectronico(int Id, boolean encendido) {
        this.Id = Id;
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

    public abstract String getMarcaModelo();
}

 