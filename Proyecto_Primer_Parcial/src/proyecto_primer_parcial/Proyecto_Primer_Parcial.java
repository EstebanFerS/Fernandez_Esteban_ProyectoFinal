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

        //Condiciones
        boolean primeraApertura = true;
        boolean cajaAbierta = false;
        boolean salir = true;
        int opcion;

        //Dinero de la caja
        float montoCaja = 0;
        float montoInicial = 0;
        float banco = 0;

        //Tipo de Cliente
        String tipoCliente;

        //Reporte
        float ventasDiarias = 0;
        float comprasDiarias = 0;
        float totalCompras = 0;
        float totalVentas = 0;
        float compraMasCara = 0;
        float ventaMasCara = 0;
        float sumaValoresCompra = 0;
        float sumaValoresVenta = 0;
        int totalAzucarVendida = 0;
        int totalAvenaVendida = 0;
        int totalTrigoVendida = 0;
        int totalMaizVendida = 0;

        // Stock de productos
        float azucarStock = 0, avenaStock = 0, trigoStock = 0, maizStock = 0;

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

            try {
                opcion = lea.nextInt();
            } catch (Exception e) {
                System.out.println("Error: Solo es permitido numeros enteros son permitidos...");
                lea.next();
                continue;
            }

            switch (opcion) {

                //Apertura de Caja
                case 1:

                    if (!cajaAbierta) {
                        cajaAbierta = true;

                        if (primeraApertura) {
                            System.out.println("\033[0;1m" + "Abrir Caja");

                            boolean entradaValida = false;

                            while (!entradaValida) {
                                System.out.print("Ingrese la cantidad de dinero que desea guardar: ");
                                try {
                                    montoInicial = lea.nextFloat();
                                    if (montoInicial <= 0) {
                                        System.out.println("El Monto inicial no puede ser menor o igual a 0");
                                    } else {
                                        entradaValida = true;
                                    }
                                } catch (Exception e) {
                                    System.out.println("Error: Solo se permiten numeros.");
                                    lea.next();
                                }
                            }

                            montoCaja += montoInicial;
                            primeraApertura = false;
                            System.out.println("La caja ha sido iniciada");

                        } else {
                            System.out.println("La caja ha sido iniciada");
                        }

                    } else {

                        boolean cantidadValida = false;

                        while (!cantidadValida) {

                            System.out.print("Ingrese la cantidad de dinero que desea guardar: ");
                            try {
                                montoInicial = lea.nextFloat();

                                if (montoInicial <= 0) {
                                    System.out.println("El monto debe ser mayor a 0.");
                                } else {
                                    cantidadValida = true;
                                }

                            } catch (Exception e) {
                                System.out.println("Error: Solo se permiten numeros.");
                                lea.next();
                            }
                        }
                        montoCaja += montoInicial;
                        System.out.println("Se ha anadido correctamente el dinero");
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
                        System.out.println("\nNo se puede realizar ninguna venta. Todos los productos estan agotados.");
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

                        boolean entradaValida = false;
                        int codigo = 0;
                        boolean puedeComprar = false;
                        String nombreProducto = "";
                        float precio = 0;

                        while (!entradaValida) {
                            System.out.print("Ingrese el codigo del producto a vender: ");
                            try {
                                codigo = lea.nextInt();
                                switch (codigo) {
                                    case 1:
                                        nombreProducto = "Azucar";
                                        precio = 30;
                                        puedeComprar = tipoCliente.equalsIgnoreCase("A") || tipoCliente.equalsIgnoreCase("B");
                                        entradaValida = true;
                                        break;
                                    case 2:
                                        nombreProducto = "Avena";
                                        precio = 25;
                                        puedeComprar = tipoCliente.equalsIgnoreCase("A") || tipoCliente.equalsIgnoreCase("B");
                                        entradaValida = true;
                                        break;
                                    case 3:
                                        nombreProducto = "Trigo";
                                        precio = 32;
                                        puedeComprar = tipoCliente.equalsIgnoreCase("A") || tipoCliente.equalsIgnoreCase("B");
                                        entradaValida = true;
                                        break;
                                    case 4:
                                        nombreProducto = "Maiz";
                                        precio = 20;
                                        puedeComprar = tipoCliente.equalsIgnoreCase("A") || tipoCliente.equalsIgnoreCase("C");
                                        entradaValida = true;
                                        break;
                                    default:
                                        System.out.println("Codigo de producto invalido.");
                                }
                            } catch (Exception e) {
                                System.out.println("Error: Solo numeros enteros permitidos");
                                lea.next();
                            }
                        }

                        if (!puedeComprar) {
                            System.out.println("NO PUEDE COMPRAR DICHO PRODUCTO.");
                        } else {

                            float cantidad = 0;
                            boolean cantidadValida = false;

                            while (!cantidadValida) {

                                System.out.print("Ingrese la cantidad en kilogramos que desea comprar: ");
                                try {
                                    cantidad = lea.nextFloat();
                                    if (cantidad > 0) {
                                        cantidadValida = true;
                                    } else {
                                        System.out.println("La cantidad debe ser mayor a 0");
                                    }
                                } catch (Exception e) {
                                    System.out.println("Error: Solo numeros enteros permitidos");
                                    lea.next();
                                }
                            }

                            boolean stockSuficiente = false;

                            switch (codigo) {
                                case 1:
                                    if (cantidad <= azucarStock) {
                                        azucarStock -= cantidad;
                                        stockSuficiente = true;
                                        totalAzucarVendida += cantidad;
                                    }
                                    break;
                                case 2:
                                    if (cantidad <= avenaStock) {
                                        avenaStock -= cantidad;
                                        stockSuficiente = true;
                                        totalAvenaVendida += cantidad;
                                    }
                                    break;
                                case 3:
                                    if (cantidad <= trigoStock) {
                                        trigoStock -= cantidad;
                                        stockSuficiente = true;
                                        totalTrigoVendida += cantidad;
                                    }
                                    break;
                                case 4:
                                    if (cantidad <= maizStock) {
                                        maizStock -= cantidad;
                                        stockSuficiente = true;
                                        totalMaizVendida += cantidad;
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

                        String respuesta = "";
                        boolean respuestaValida = false;
                        while (!respuestaValida) {
                            System.out.print("Desea comprar otro producto? (S/N): ");
                            respuesta = lea.next();
                            if (respuesta.equalsIgnoreCase("S")) {
                                respuestaValida = true;
                            } else if (respuesta.equalsIgnoreCase("N")) {
                                respuestaValida = true;
                                seguirComprando = false;
                            } else {
                                System.out.println("Respuesta invalida. Por favor ingrese solo 'S' o 'N'.");
                            }
                        }

                    }

                    double descuento = 0;

                    if (subtotal >= 5000) {
                        descuento = subtotal * 0.10;
                    } else if (subtotal >= 1000) {
                        descuento = subtotal * 0.05;
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
                    ventasDiarias++;
                    totalVentas += totalPagar;
                    sumaValoresVenta += totalPagar;
                    if (totalPagar > ventaMasCara) {
                        ventaMasCara = (float) totalPagar;
                    }

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
                        System.out.println("Tipo de proveedor no valido.");
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

                    boolean entradaValida = false;
                    int codigoCompra = 0;

                    while (!entradaValida) {
                        System.out.print("Ingrese el codigo del producto que desea comprar: ");
                        try {
                            codigoCompra = lea.nextInt();
                            entradaValida = true;
                        } catch (Exception e) {
                            System.out.println("Error: Solo numeros enteros permitidos");
                            lea.next();
                        }
                    }

                    boolean codigoValido = true;
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
                            System.out.println("Codigo de producto invalido.");
                            codigoValido = false;
                            break;
                    }

                    if (!codigoValido) {
                        break;
                    }

                    if (!puedeProveer) {
                        System.out.println("Proveedor no vende dicho Producto.");
                        break;
                    }

                    float cantidadCompra = 0;
                    boolean cantidadValida = false;

                    while (!cantidadValida) {
                        System.out.print("Ingrese la cantidad en kilogramos que desea comprar: ");
                        try {
                            cantidadCompra = lea.nextFloat();
                            if (cantidadCompra > 0) {
                                cantidadValida = true;
                            } else {
                                System.out.println("La cantidad debe ser mayor a O");
                            }
                        } catch (Exception e) {
                            System.out.println("Error: Solo numeros enteros permitidos");
                            lea.next();
                        }

                    }

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
                    comprasDiarias++;
                    totalCompras += totalCompra;
                    sumaValoresCompra += totalCompra;
                    if (totalCompra > compraMasCara) {
                        compraMasCara = totalCompra;
                    }

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
                    System.out.println("--------------------------------");
                    System.out.println("\tReporte del Dia");
                    System.out.println("--------------------------------");
                    System.out.printf("Cantidad Actual en caja: Lps. %.2f\n", montoCaja);
                    System.out.println("Total de Compras Realizadas: " + comprasDiarias);
                    System.out.println("Total de Ventas Realizadas: " + ventasDiarias);

                    float margenGanancia = totalVentas - totalCompras;
                    System.out.printf("Total de Compras: Lps. %.2f\n", totalCompras);
                    System.out.printf("Total de Ventas: Lps. %.2f\n", totalVentas);
                    System.out.printf("Margen de Ganancia: Lps. %.2f\n", margenGanancia);

                    float promedioCompra = 0;
                    float promedioVenta = 0;

                    if (comprasDiarias > 0) {
                        promedioCompra = sumaValoresCompra / comprasDiarias;
                    } else {
                        promedioCompra = 0;
                    }

                    if (ventasDiarias > 0) {
                        promedioVenta = sumaValoresVenta / ventasDiarias;
                    } else {
                        promedioVenta = 0;
                    }

                    System.out.printf("Promedio por Compra: Lps. %.2f\n", promedioCompra);
                    System.out.printf("Promedio por Venta: Lps. %.2f\n", promedioVenta);

                    System.out.printf("Compra mas costosa: Lps. %.2f\n", compraMasCara);
                    System.out.printf("Venta con mayor ganancia: Lps. %.2f\n", ventaMasCara);

                    int maxVendidos = totalAzucarVendida;
                    if (totalAvenaVendida > maxVendidos) {
                        maxVendidos = totalAvenaVendida;
                    }
                    if (totalTrigoVendida > maxVendidos) {
                        maxVendidos = totalTrigoVendida;
                    }
                    if (totalMaizVendida > maxVendidos) {
                        maxVendidos = totalMaizVendida;
                    }

                    String productosEstrella = "";

                    if (totalAzucarVendida == maxVendidos && maxVendidos > 0) {
                        productosEstrella += "Azucar, ";
                    }
                    if (totalAvenaVendida == maxVendidos && maxVendidos > 0) {
                        productosEstrella += "Avena, ";
                    }
                    if (totalTrigoVendida == maxVendidos && maxVendidos > 0) {
                        productosEstrella += "Trigo, ";
                    }
                    if (totalMaizVendida == maxVendidos && maxVendidos > 0) {
                        productosEstrella += "Maíz, ";
                    }

                    if (!productosEstrella.equals("")) {
                        productosEstrella = productosEstrella.substring(0, productosEstrella.length() - 2);
                        System.out.println("Producto Estrella(s): " + productosEstrella + " con " + maxVendidos + " Kg vendidos");
                    } else {
                        System.out.println("No se han vendido productos aun.");
                    }

                    break;

                case 5:
                    if (!cajaAbierta) {
                        System.out.println("\nNo puede realizar el cierre de caja, porque la caja esta cerrada");
                        Thread.sleep(1500);
                        System.out.println("Por favor, abra la caja en el menu principal");
                        Thread.sleep(3000);
                        break;
                    }

                    System.out.println("Ganancia Actual: " + sumaValoresVenta);

                    boolean entradaValidaBanco = false;
                    while (!entradaValidaBanco) {
                        System.out.print("Ingrese el monto que desea guardar en el banco: ");
                        try {
                            banco = lea.nextFloat();
                            if (banco <= (montoCaja * 0.60)) {
                                System.out.println("El efectivo ha sido guardado correctamente");
                                entradaValidaBanco = true;
                            } else {
                                System.out.println("Error: El monto a depositar no puede ser mayor al 60% del valor de la caja (" + (montoCaja * 0.60) + ")");
                            }
                        } catch (Exception e) {
                            System.out.println("Error: Solo numeros enteros permitidos");
                            lea.next();
                        }
                    }
                    ventasDiarias = 0;
                    comprasDiarias = 0;
                    totalCompras = 0;
                    totalVentas = 0;
                    compraMasCara = 0;
                    ventaMasCara = 0;
                    sumaValoresCompra = 0;
                    sumaValoresVenta = 0;
                    totalAzucarVendida = 0;
                    totalAvenaVendida = 0;
                    totalTrigoVendida = 0;
                    totalMaizVendida = 0;
                    
                    cajaAbierta = false;

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
