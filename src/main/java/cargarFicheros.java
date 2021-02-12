import Ventas.Imperecedero;
import Ventas.Perecedero;

import java.io.*;
import java.util.ArrayList;

public class cargarFicheros {
    public static ArrayList<Empleado> leerEmpleados() throws IOException{
        ArrayList<Empleado> salida=new ArrayList<>();
        BufferedReader archivo=abrirFichero("./files/empleados.txt");
        String linea;
        while ((linea= archivo.readLine()) != null){
            String[] datos=linea.split(":");
            salida.add(new Empleado(Integer.parseInt(datos[0]),
                    datos[1],
                    datos[2],
                    Integer.parseInt(datos[3])));
        }
        return salida;
    }

    public static ArrayList<Perecedero> leerPerecedero() throws IOException{
        ArrayList<Perecedero> salida=new ArrayList<>();
        BufferedReader archivo=abrirFichero("./files/Perecederos.txt");
        String linea;
        while ((linea= archivo.readLine()) != null){
            String[] datos=linea.split(":");
            salida.add(new Perecedero(Integer.parseInt(datos[0]),
                    datos[1],
                    Double.parseDouble(datos[2]),
                    Integer.parseInt(datos[3]),
                    Integer.parseInt(datos[4])));
        }
        return salida;
    }

    public static ArrayList<Imperecedero> leerImperecedero() throws IOException {
        ArrayList<Imperecedero> salida= new ArrayList<>();
        BufferedReader archivo=abrirFichero("./files/Imperecederos.txt");
        String linea;
        while ((linea = archivo.readLine()) != null){
            String[] datos=linea.split(":");
            salida.add(new Imperecedero(
                    Integer.parseInt(datos[0]),
                    datos[1],
                    Double.parseDouble(datos[2]),
                    Integer.parseInt(datos[3]),
                    Double.parseDouble(datos[4])));
        }
        return salida;
    }


    private static BufferedReader abrirFichero(String ruta) throws FileNotFoundException {
        File fichero=new File(ruta);
        FileReader fichlec=new FileReader(fichero);
        BufferedReader ficherofinal=new BufferedReader(fichlec);
        return ficherofinal;
    }
}
