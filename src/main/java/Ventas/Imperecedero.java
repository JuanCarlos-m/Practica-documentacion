package Ventas;

public class Imperecedero extends Producto {
    private double descuento;

    public Imperecedero(int codigo, String descripcion, double precio, int unidades, double descuento) {
        super(codigo, descripcion, (precio*(1-(descuento/100))), unidades);
        this.descuento=descuento;
    }

    @Override
    public String Mostrar() {
        return "ref: " + this.getCodigo()+" | "+
                "Descripcion: " + this.getDescripcion()+ " | " +
                "Precio: " + this.getPrecio() + "€";
    }
}
