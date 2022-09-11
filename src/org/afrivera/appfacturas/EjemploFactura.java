package org.afrivera.appfacturas;

import org.afrivera.appfacturas.model.Cliente;
import org.afrivera.appfacturas.model.Factura;
import org.afrivera.appfacturas.model.ItemFactura;
import org.afrivera.appfacturas.model.Producto;

import java.util.Scanner;

public class EjemploFactura {
    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.setNIT("555-5");
        cliente.setName("Andres Rivera");

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la descripción de la factura: ");
        String desc = sc.nextLine();
        Factura factura = new Factura(desc, cliente);

        Producto producto;
        String nombre;
        float precio;
        int cantidad;
        System.out.println();

        for (int i = 0; i < 5; i++) {
            producto = new Producto();
            System.out.print("Ingrese Producto n°: " + producto.getCodigo() + ": ");
            nombre = sc.nextLine();// .next()para recibir palabras sin espacios
            producto.setNombre(nombre);
            System.out.print("Ingrese el precio: ");
            precio = sc.nextFloat();
            producto.setPrecio(precio);

            System.out.print("Ingrese la cantidad: ");
            cantidad = sc.nextInt();

            ItemFactura item = new ItemFactura(cantidad, producto);
            factura.addItemFactura(item);

            System.out.println();
            sc.nextLine(); // para mover el cursor a la siguiente linea y no genere algún error
        }

        System.out.println(factura.generarDetalle());
    }
}
