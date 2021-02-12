public class Empleado {
    private int accod;
    private String nombre;
    private String passwd;
    private int ventas;

    public Empleado(int accod, String nombre, String passwd, int ventas) {
        this.accod = accod;
        this.nombre = nombre;
        this.passwd = passwd;
        this.ventas = ventas;
    }

    public int getAccod() {
        return accod;
    }

    public void setAccod(int accod) {
        this.accod = accod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }
}
