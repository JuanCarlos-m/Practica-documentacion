package Ventas;

public class Perecedero extends Producto {
    private int tiempocaducidad;

    public Perecedero(int codigo, String descripcion, double precio, int unidades, int tiempocaducidad) {
        super(codigo, descripcion, descuentoCaducidad(precio, tiempocaducidad), unidades);
        this.tiempocaducidad = tiempocaducidad;
    }

    public int getTiempocaducidad() {
        return tiempocaducidad;
    }

    public void setTiempocaducidad(int tiempocaducidad) {
        this.tiempocaducidad = tiempocaducidad;
    }
    private static double descuentoCaducidad(double precio,int tiempocaducidad) {
        switch (tiempocaducidad){
            case 1:
                return (precio*0.25);
            case 2:
                return (precio*0.33);
            case 3:
                return (precio*0.5);
            default:
                return (precio);
        }
    }

    @Override
    public String Mostrar() {
        return "ref: " + this.getCodigo()+" | "+
                "Descripcion: " + this.getDescripcion()+ " | " +
                "Precio: " + this.getPrecio() + "€";
    }
}
