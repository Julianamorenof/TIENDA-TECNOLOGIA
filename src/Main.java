//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;
void main() {

    Scanner teclado = new Scanner(System.in);

    List<Cliente> list = new ArrayList<>();

    int op;
    int subop;

    do {
        System.out.println("""
                MENÚ PRINCIPAL
                1. Registrar cliente regular
                2. Registrar cliente frecuente
                3. Registrar cliente mayorista
                4. Buscar cliente por identificación
                5. Mostrar todos los clientes
                6. Filtrar clientes por tipo
                7. Calcular total de compra
                8. Mostrar compras altas
                9. Mostrar cliente con mayor pago
                10. Salir
                """);
        System.out.println("Ingrese una opción: ");
        op = teclado.nextInt();

        switch (op) {
            case 1:
                System.out.println("INGRESAR DATOS PARA REGISTRAR CLIENTE REGULAR");
                System.out.println("Nombre: ");
                String nombre = teclado.next();
                System.out.println("Identificación: ");
                String identificacion = teclado.next();
                System.out.println("Valor de la compra: ");
                double valorCompra = teclado.nextDouble();

                ClienteRegular cR = new ClienteRegular(nombre, identificacion, valorCompra);
                list.add(cR);

                break;

            case 2:
                System.out.println("INGRESAR DATOS PARA REGISTRAR CLIENTE FRECUENTE");
                System.out.println("Nombre: ");
                nombre = teclado.next();
                System.out.println("Identificación: ");
                identificacion = teclado.next();
                System.out.println("Numero de compras realizadas: ");
                int numeroCompras = teclado.nextInt();
                System.out.println("Valor de la compra: ");
                valorCompra = teclado.nextDouble();

                ClienteFrecuente cF = new ClienteFrecuente(nombre, identificacion, valorCompra, numeroCompras);
                list.add(cF);

                break;

            case 3:
                System.out.println("INGRESAR DATOS PARA REGISTRAR CLIENTE MAYORISTA");
                System.out.println("Nombre: ");
                nombre = teclado.next();
                System.out.println("Identificación: ");
                identificacion = teclado.next();
                System.out.println("Cantidad de productos");
                int cantidadProductos = teclado.nextInt();
                System.out.println("Valor de la compra: ");
                valorCompra = teclado.nextDouble();

                ClienteMayorista cM = new ClienteMayorista(nombre, identificacion, valorCompra, cantidadProductos);
                list.add(cM);

                break;

            case 4:
                System.out.println("Ingrese la identificación del cliente");
                String idBuscar = teclado.next();
                boolean idEncontrado = false;

                for (Cliente cli : list) {
                    if (cli.getIdentificacion().equalsIgnoreCase(idBuscar)) {
                        double valorFinal = cli.calcularTotalPagar();
                        cli.imprimirResumen(valorFinal);
                        idEncontrado = true;

                        break;
                    }
                }
                if (!idEncontrado) {
                    System.out.println("No se encontró al cliente");
                }
                break;

            case 5:
                System.out.println("MOSTRANDO TODOS LOS CLIENTES");
                for (Cliente cli : list) {
                    double valorFinal = cli.calcularTotalPagar();
                    cli.imprimirResumen(valorFinal);
                }
                break;

            case 6:
                do {
                    System.out.println("""
                            MOSTRANDO SUBMENÚ
                            1. Clientes Regulares
                            2. Clientes Frecuentes
                            3. Clientes Mayoristas
                            4. Volver al menú principal
                            """);
                    System.out.println("Ingrese una opción");
                    subop = teclado.nextInt();

                    switch (subop) {
                        case 1:
                            System.out.println("CLIENTES REGULARES");
                            boolean cliR = false;
                            for (Cliente cli : list) {
                                if (cli instanceof ClienteRegular) {
                                    double valorFinal = cli.calcularTotalPagar();
                                    cli.imprimirResumen(valorFinal);
                                    cliR = true;
                                }
                            }
                            if (!cliR) System.out.println("No hay clientes regulares");
                            break;

                        case 2:
                            System.out.println("CLIENTES FRECUENTES");
                            boolean cliF = false;
                            for (Cliente cli : list) {
                                if (cli instanceof ClienteFrecuente) {
                                    double valorFinal = cli.calcularTotalPagar();
                                    cli.imprimirResumen(valorFinal);
                                    cliF = true;
                                }
                            }
                            if (!cliF) System.out.println("No hay clientes frecuentes");
                            break;

                        case 3:
                            System.out.println("CLIENTES MAYORISTAS");
                            boolean cliM = false;
                            for (Cliente cli : list) {
                                if (cli instanceof ClienteMayorista) {
                                    double valorFinal = cli.calcularTotalPagar();
                                    cli.imprimirResumen(valorFinal);
                                    cliM = true;
                                }
                            }
                            if (!cliM) System.out.println("No hay clientes mayoristas");
                            break;

                        case 4:
                            System.out.println("Volviendo al menú principal");
                            break;
                        default:
                            System.out.println("Opción inválida, ingrese una opcion");
                    }
                } while (subop != 4);
                break;

            case 7:
                System.out.println("Ingrese la identificación del cliente");
                idBuscar = teclado.next();
                boolean idencontrado = false;

                for (Cliente cli : list) {
                    if (cli.getIdentificacion().equalsIgnoreCase(idBuscar)) {
                        double valorFinal = cli.calcularTotalPagar();
                        cli.imprimirResumen(valorFinal);
                        idencontrado = true;

                        break;
                    }
                }
                if (!idencontrado) {
                    System.out.println("No se encontró al cliente");
                }
                break;

            case 8:
                System.out.println("La compra es alta a partir de 300000");
                boolean alta = false;

                for (Cliente cli : list) {
                    if (cli.compraAlta()) {
                        double valorFinal = cli.calcularTotalPagar();
                        cli.imprimirResumen(valorFinal);
                        alta = true;

                    }
                }
                if (!alta) {
                    System.out.println("No hay compras altas");
                }
                break;

            case 9:
                if (list.isEmpty()) {
                    System.out.println("No hay clientes registrados");
                    break;
                }
                Cliente maxCliente = list.get(0);
                double maxPago = maxCliente.calcularTotalPagar();
                for (Cliente cli : list) {
                    double pago = cli.calcularTotalPagar();
                    if (pago > maxPago) {
                        maxPago = pago;
                        maxCliente = cli;

                    }
                }
                System.out.println("El cliente que mas pago fue: ");
                maxCliente.imprimirResumen(maxPago);

                break;

            case 10:
                System.out.println("Saliendo del programa");
                break;

            default:
                System.out.println("Opción inválida, ingrese una opcion");

        }
    } while (op != 10);
}


