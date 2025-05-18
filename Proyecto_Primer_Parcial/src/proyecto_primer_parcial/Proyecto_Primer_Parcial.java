/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_primer_parcial;

import java.util.Scanner;

/**
 *
 * @author esteb
 */
public class Proyecto_Primer_Parcial {

    public static void main(String[] args) throws InterruptedException {

        Scanner lea = new Scanner(System.in);

        boolean primeraApertura = true;
        boolean cajaAbierta = false;
        boolean salir = true;
        int opcion;

        float montoCaja = 0;
        float montoInicial = 0;
        float montoBanco = 0;

        int ventasDiarias = 0;
        int comprasDiarias = 0;

        String tipoCliente;

        // Stock de productos
        float azucarStock = 0,avenaStock = 0,trigoStock = 0,maizStock = 0;

        while (salir) {

            //Menu Principal
            System.out.println("\n");
            System.out.println("-----------------------------------------------------");
            System.out.println("\t\t     Tienda Java         ");
            System.out.println("-----------------------------------------------------");
            System.out.println("\t1.Abrir Caja      \t2.Ventas");
            System.out.println("\t3.Compras         \t4.Reportes");
            System.out.println("\t5.Cierre de Caja  \t6.Salir");
            System.out.print("Ingrese la opcion deseada: ");
            opcion = lea.nextInt();

            switch (opcion) {

                //Apertura de Caja
                case 1:
                    if (!cajaAbierta) {
                        cajaAbierta = true;
                        if (primeraApertura) {
                            System.out.println("\033[0;1m" + "Abrir Caja");
                            System.out.print("Ingrese la cantidad de dinero que desea guardar: ");
                            montoInicial = lea.nextFloat();
                            while (montoInicial <= 0) {
                                System.out.println("El Monto inicial no puede ser menor a 0 ");
                                Thread.sleep(2500);
                                System.out.println("Ingrese la cantidad de dinero que desea guardar: ");
                                montoInicial = lea.nextFloat();
                            }
                            montoCaja += montoInicial;
                            primeraApertura = false;
                            System.out.println("La caja ha sido iniciada");
                        } else {
                            System.out.println("La caja ha sido iniciada");
                        }
                    } else {
                        System.out.print("Ingrese la cantidad de dinero que desea guardar: ");
                        montoInicial = lea.nextFloat();
                        montoCaja += montoInicial;
                        System.out.println("Se ha añadido correctamente el dinero");
                    }
                    break;

                //Apartado de Ventas    
                case 2:

                    if (!cajaAbierta) {
                        System.out.println("\nNo puede realizar ningun tipo de venta, porque la caja esta cerrada");
                        Thread.sleep(1500);
                        System.out.println("Por favor, abra la caja en el menu principal");
                        Thread.sleep(3000);
                        break;
                    }

                    if (azucarStock <= 0 && avenaStock <= 0 && trigoStock <= 0 && maizStock <= 0) {
                        System.out.println("\nNo se puede realizar ninguna venta. Todos los productos están agotados.");
                        Thread.sleep(2500);
                        break;
                    }

                    System.out.println("---------------------------------------------------");
                    System.out.println("\t\t\tVentas");
                    System.out.println("---------------------------------------------------");
                    System.out.println("|    Codigo     |   Producto    |   Precio Venta   |");
                    System.out.println("|      1        |   Azucar     |   Lps. 30        |");
                    System.out.println("|      2        |   Avena      |   Lps. 25        |");
                    System.out.println("|      3        |   Trigo      |   Lps. 32        |");
                    System.out.println("|      4        |   Maiz       |   Lps. 20        |");
                    System.out.println("---------------------------------------------------");

                    System.out.print("Ingrese el tipo de Cliente(A/B/C): ");
                    tipoCliente = lea.next();

                    while (!(tipoCliente.equalsIgnoreCase("A") || tipoCliente.equalsIgnoreCase("B") || tipoCliente.equalsIgnoreCase("C"))) {
                        System.out.println("Ingrese un tipo de cliente valido");
                        System.out.print("Ingrese el tipo de Cliente(A/B/C): ");
                        tipoCliente = lea.next();
                    }

                    boolean seguirComprando = true;
                    float subtotal = 0;
                    String detalleFactura = "";

                    while (seguirComprando) {
                        System.out.print("Ingrese el codigo del producto a vender: ");
                        int codigo = lea.nextInt();

                        boolean puedeComprar = false;
                        String nombreProducto = "";
                        float precio = 0;

                        switch (codigo) {
                            case 1:
                                nombreProducto = "Azucar";
                                precio = 30;
                                puedeComprar = tipoCliente.equalsIgnoreCase("A") || tipoCliente.equalsIgnoreCase("B");
                                break;
                            case 2:
                                nombreProducto = "Avena";
                                precio = 25;
                                puedeComprar = tipoCliente.equalsIgnoreCase("A") || tipoCliente.equalsIgnoreCase("B");
                                break;
                            case 3:
                                nombreProducto = "Trigo";
                                precio = 32;
                                puedeComprar = tipoCliente.equalsIgnoreCase("A") || tipoCliente.equalsIgnoreCase("B");
                                break;
                            case 4:
                                nombreProducto = "Maiz";
                                precio = 20;
                                puedeComprar = tipoCliente.equalsIgnoreCase("A") || tipoCliente.equalsIgnoreCase("C");
                                break;
                            default:
                                System.out.println("Codigo de producto invalido.");
                        }

                        if (!puedeComprar) {
                            System.out.println("NO PUEDE COMPRAR DICHO PRODUCTO.");
                        } else {
                            System.out.print("Ingrese la cantidad en kilogramos que desea comprar: ");
                            float cantidad = lea.nextFloat();

                            boolean stockSuficiente = false;

                            switch (codigo) {
                                case 1:
                                    if (cantidad <= azucarStock) {
                                        azucarStock -= cantidad;
                                        stockSuficiente = true;
                                    }
                                    break;
                                case 2:
                                    if (cantidad <= avenaStock) {
                                        avenaStock -= cantidad;
                                        stockSuficiente = true;
                                    }
                                    break;
                                case 3:
                                    if (cantidad <= trigoStock) {
                                        trigoStock -= cantidad;
                                        stockSuficiente = true;
                                    }
                                    break;
                                case 4:
                                    if (cantidad <= maizStock) {
                                        maizStock -= cantidad;
                                        stockSuficiente = true;
                                    }
                                    break;
                            }

                            if (stockSuficiente) {
                                float totalProducto = cantidad * precio;
                                subtotal += totalProducto;

                                detalleFactura += "| " + nombreProducto + "     ";
                                detalleFactura += "| " + cantidad + " Kg       ";
                                detalleFactura += "| Lps. " + precio + "    ";
                                detalleFactura += "| Lps. " + totalProducto + "  |\n";

                            } else {
                                System.out.println("No hay suficiente stock de " + nombreProducto + " para completar la venta.");
                            }
                        }

                        System.out.print("Desea comprar otro producto? (S/N): ");
                        String respuesta = lea.next();

                        if (respuesta.equalsIgnoreCase("N")) {
                            seguirComprando = false;
                        }
                    }

                    double descuento = 0;

                    if (subtotal >= 1000) {
                        descuento = subtotal * 0.05;
                    } else if (subtotal >= 5000) {
                        descuento = subtotal * 0.10;
                    }

                    double impuesto = subtotal * 0.07;
                    double totalPagar = subtotal - descuento + impuesto;

                    Thread.sleep(3000);

                    System.out.println("\n---------------------------- FACTURA ----------------------------");
                    System.out.printf("%-15s %-12s %-18s %-15s\n", "Producto", "Cantidad(Kg)", "Precio Unitario", "Total");
                    System.out.print(detalleFactura);
                    System.out.println("--------------------------------------------------------------");
                    System.out.printf("%-35s Lps %8.2f\n", "Subtotal:", subtotal);
                    System.out.printf("%-35s Lps %8.2f\n", "Descuento:", descuento);
                    System.out.printf("%-35s Lps %8.2f\n", "Impuesto (7%):", impuesto);
                    System.out.printf("%-35s Lps %8.2f\n", "TOTAL A PAGAR:", totalPagar);
                    System.out.println("--------------------------------------------------------------");

                    montoCaja += totalPagar;

                    break;

                case 3:
                    if (!cajaAbierta) {
                        System.out.println("\nNo puede realizar ningun tipo de compra, porque la caja esta cerrada");
                        Thread.sleep(1500);
                        System.out.println("Por favor, abra la caja en el menu principal");
                        Thread.sleep(3000);
                        break;
                    }

                    System.out.println("---------------------------------------------------");
                    System.out.println("\t\tCompras");
                    System.out.println("---------------------------------------------------");

                    System.out.print("Ingrese el tipo de Proveedor (A/B/C): ");
                    String tipoProveedor = lea.next();

                    while (!(tipoProveedor.equalsIgnoreCase("A") || tipoProveedor.equalsIgnoreCase("B") || tipoProveedor.equalsIgnoreCase("C"))) {
                        System.out.println("Tipo de proveedor no válido.");
                        System.out.print("Ingrese el tipo de Proveedor (A/B/C): ");
                        tipoProveedor = lea.next();
                    }

                    System.out.println("---------------------------------------------------");
                    System.out.println("|    Codigo     |   Producto    |   Precio Compra  |");
                    System.out.println("|      1        |   Azucar      |   Lps. 25        |");
                    System.out.println("|      2        |   Avena       |   Lps. 20 o 22   |");
                    System.out.println("|      3        |   Trigo       |   Lps. 30        |");
                    System.out.println("|      4        |   Maiz        |   Lps. 18        |");
                    System.out.println("---------------------------------------------------");

                    System.out.print("Ingrese el código del producto que desea comprar: ");
                    int codigoCompra = lea.nextInt();

                    boolean puedeProveer = false;
                    float precioCompra = 0;
                    String productoCompra = "";

                    switch (codigoCompra) {
                        case 1:
                            productoCompra = "Azucar";
                            precioCompra = 25;
                            puedeProveer = tipoProveedor.equalsIgnoreCase("A");
                            break;
                        case 2:
                            productoCompra = "Avena";
                            if (tipoProveedor.equalsIgnoreCase("B")) {
                                precioCompra = 20;
                                puedeProveer = true;
                            } else if (tipoProveedor.equalsIgnoreCase("C")) {
                                precioCompra = 22;
                                puedeProveer = true;
                            }
                            break;
                        case 3:
                            productoCompra = "Trigo";
                            precioCompra = 30;
                            puedeProveer = tipoProveedor.equalsIgnoreCase("B");
                            break;
                        case 4:
                            productoCompra = "Maiz";
                            precioCompra = 18;
                            puedeProveer = tipoProveedor.equalsIgnoreCase("A");
                            break;
                        default:
                            System.out.println("Código de producto inválido.");
                            break;
                    }

                    if (!puedeProveer) {
                        System.out.println("Proveedor no vende dicho Producto.");
                        break;
                    }

                    System.out.print("Ingrese la cantidad en kilogramos que desea comprar: ");
                    float cantidadCompra = lea.nextFloat();

                    float totalCompra = cantidadCompra * precioCompra;

                    if (totalCompra > montoCaja) {
                        System.out.println("No se Puede Pagar Compra. Fondos insuficientes en caja.");
                        break;
                    }

                    switch (codigoCompra) {
                        case 1:
                            azucarStock += cantidadCompra;
                            break;
                        case 2:
                            avenaStock += cantidadCompra;
                            break;
                        case 3:
                            trigoStock += cantidadCompra;
                            break;
                        case 4:
                            maizStock += cantidadCompra;
                            break;
                    }

                    montoCaja -= totalCompra;

                    System.out.println("\nCompra realizada exitosamente.");
                    System.out.println("Producto: " + productoCompra);
                    System.out.printf("Cantidad: %.2f Kg\n", cantidadCompra);
                    System.out.printf("Precio por Kg: Lps. %.2f\n", precioCompra);
                    System.out.printf("Total Pagado: Lps. %.2f\n", totalCompra);
                    break;

                case 4:
                    if (!cajaAbierta) {
                        System.out.println("\nNo puede realizar el reporte, porque la caja esta cerrada");
                        Thread.sleep(1500);
                        System.out.println("Por favor, abra la caja en el menu principal");
                        Thread.sleep(3000);
                        break;
                    }
                    System.out.println("\n--- Reporte ---");
                    System.out.printf("Cantidad Actual de Caja: %.2f\n", montoCaja);
                    System.out.printf("Azucar: %.2f Kg\n", azucarStock);
                    System.out.printf("Avena:  %.2f Kg\n", avenaStock);
                    System.out.printf("Trigo:  %.2f Kg\n", trigoStock);
                    System.out.printf("Maiz:   %.2f Kg\n", maizStock);
                    break;

                case 5:
                    if (!cajaAbierta) {
                        System.out.println("\nNo puede realizar el cierre de caja, porque la caja esta cerrada");
                        Thread.sleep(1500);
                        System.out.println("Por favor, abra la caja en el menu principal");
                        Thread.sleep(3000);
                        break;
                    }
                    
                    System.out.println("\n");
                    System.out.println("Cierre de Caja");
                    break;

                case 6:
                    System.out.println("\n");
                    salir = false;
                    System.out.print("Saliendo del programa");
                    Thread.sleep(1000);
                    System.out.print(".");
                    Thread.sleep(1000);
                    System.out.print(".");
                    Thread.sleep(1000);
                    System.out.println(".");
                    Thread.sleep(1000);
                    System.out.println("Adios");
                    Thread.sleep(1000);
                    System.exit(0);
                    break;

                default:
                    System.out.println("Ingrese una opcion valida del menu");
            }
        }
    }
}
