import Ventas.Imperecedero;
import Ventas.Perecedero;
import Ventas.Producto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("El programa esta iniciandose...");

        //Cargando los empleados en el programa...
        ArrayList<Empleado> empleados=cargarFicheros.leerEmpleados();

        //Cargando los productos...
        ArrayList<Imperecedero> imperecederos=cargarFicheros.leerImperecedero();
        ArrayList<Perecedero> perecederos=cargarFicheros.leerPerecedero();

        Scanner sc=new Scanner(System.in);
        Empleado sesion=null;
        System.out.println("Bienvenido al programa de tienda.");
        while (true){
            System.out.println("Introduzca codigo de acceso y contraseña: ");
            System.out.println("Codigo de acceso:");
            int user=Integer.parseInt(sc.nextLine());
            System.out.println("Contraseña:");
            String pass=sc.nextLine();
            for (Empleado e : empleados) {
                if (user == e.getAccod() && pass.equals(e.getPasswd())) {
                    sesion = e;
                    break;
                }
            }
            if (sesion != null){
                System.out.println("Bienvenido "+sesion.getNombre());
                int menu;
                boolean sw=true;
                while (sw){
                    System.out.println("¿Que desea hacer?\n"+
                            "1 - Hacer pedido.\n"+
                            "2 - Cambiar contraseña.\n"+
                            "3 - Salir.");
                    try { //Las secuencias try catch como esta se asegurarán de que el programa no deja de funcionar a causa de escribir un caracter no numerico, pondran la variable a 0, haciendo que el switch no cumpla ninguna condicion, repitiendo el bucle.
                        menu=Integer.parseInt(sc.nextLine());
                    }catch (NumberFormatException e){
                        menu=0;
                    }


                    switch (menu){
                        case 1:
                            //Hacer pedido
                            ArrayList<Producto> pedido=new ArrayList<Producto>();
                            ArrayList<Integer> cantidades=new ArrayList<Integer>();
                            boolean sw1=true;
                            while (sw1){
                                System.out.println("Elija una opcion:\n" +
                                        "1 - Añadir un producto.\n"+
                                        "2 - Visualizar precio total.\n" +
                                        "3 - Finalizar pediddo.");
                                try {
                                    menu=Integer.parseInt(sc.nextLine());
                                }catch (NumberFormatException e){
                                    menu=0;
                                }
                                switch (menu){
                                    case 1:
                                        //Añadir producto
                                            System.out.println("¿Que tipo de producto busca?\n" +
                                                    "1 - Imperecedero\n" +
                                                    "2 - Perecedero\n" +
                                                    "Deje en blanco para volver atras");
                                            String menu2=sc.nextLine();
                                            try {
                                                menu=Integer.parseInt(menu2);
                                            } catch (NumberFormatException e) {
                                                break;
                                            }
                                        //Utilizaremos n como caracter para indicar que no se ha seleccionado nada, en caso de que se escoja una opcion invalida
                                            char tipo='n';
                                            switch (menu){
                                                case 1:
                                                    //Imperecedero
                                                    tipo='i';
                                                    for (Imperecedero p : imperecederos) System.out.println(p.Mostrar()+" | Unidades restantes: "+p.getUnidades());
                                                    break;
                                                case 2:
                                                    //Perecedero
                                                    tipo='p';
                                                    for (Perecedero p : perecederos) System.out.println(p.Mostrar()+" | Unidades restantes: "+p.getUnidades());
                                                    break;
                                            }
                                            if (tipo != 'n'){
                                                System.out.println("Introduzca el codigo del producto deseado:");
                                                int codigo;
                                                try {
                                                    codigo=Integer.parseInt(sc.nextLine());
                                                } catch (NumberFormatException e) {
                                                    System.out.println("Error.");
                                                    codigo=0;
                                                }

                                                if (tipo == 'i'){
                                                    for (Imperecedero p : imperecederos){
                                                        if (codigo==p.getCodigo()){
                                                            System.out.println("Introduzca la cantidad deseada:");
                                                            int cantidad=Integer.parseInt(sc.nextLine());
                                                            if (cantidad<=p.getUnidades()){
                                                                pedido.add(p);
                                                                cantidades.add(cantidad);
                                                                p.setUnidades(p.getUnidades()-cantidad);
                                                            }else {
                                                                System.out.println("No hay unidades suficientes");
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }else if (tipo=='p'){
                                                    for (Perecedero p : perecederos){
                                                        if (codigo==p.getCodigo()){
                                                            System.out.println("Introduzca la cantidad deseada:");
                                                            int cantidad=Integer.parseInt(sc.nextLine());
                                                            if (cantidad<=p.getUnidades()){
                                                                pedido.add(p);
                                                                cantidades.add(cantidad);
                                                                p.setUnidades(p.getUnidades()-cantidad);
                                                            }else {
                                                                System.out.println("No hay unidades suficientes");
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        break;
                                    case 2:
                                        //Visualizar precio total
                                        if (pedido.size()!=0){
                                            double total=0;
                                            for (Producto p : pedido){
                                                total=total+(p.getPrecio()*cantidades.get(pedido.indexOf(p)));
                                            }
                                            System.out.println("Total: "+total+"€");
                                        }else{
                                            System.out.println("No hay productos.");
                                        }
                                        break;
                                    case 3:
                                        //Finalizar pedido
                                        if (pedido.size()==0){
                                            System.out.println("No hay productos.");
                                            break;
                                        }
                                        System.out.println("Factura:\n" +
                                                "Le ha atendido: "+sesion.getNombre()+"\n" +
                                                "Detalles del pedido:\n");
                                        double total=0;
                                        for (Producto p : pedido){
                                            System.out.println(p.Mostrar()+" | Cantidad: "+cantidades.get(pedido.indexOf(p))+" | Precio total:" + p.getPrecio()*cantidades.get(pedido.indexOf(p))+"€");
                                            total=total+(p.getPrecio()*cantidades.get(pedido.indexOf(p)));
                                        }
                                        System.out.println("Total: "+total+"€");
                                        sesion.setVentas(sesion.getVentas()+1);
                                        sw1=false;
                                        break;
                                }
                            }
                            break;
                        case 2:
                            //Cambiar Contraseña
                            System.out.println("Introduzca la nueva contraseña:");
                            String nueva=sc.nextLine();
                            sesion.setPasswd(nueva);
                            System.out.println("Contraseña cambiada.");
                            break;
                        case 3:
                            //Salir
                            System.out.println("Adios.");
                            sesion=null;
                            sw=false;
                            break;
                        default:
                            System.out.println("Opcion incorrecta.");
                    }

                }
            }else{
                System.out.println("Codigo de acceso o contraseña incorrecta.");
            }
        }
    }
}
