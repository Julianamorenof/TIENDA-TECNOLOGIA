public class ClienteMayorista extends Cliente {

    private int cantidadProductos;

    public ClienteMayorista(){

    }

    public ClienteMayorista(String nombre, String identificacion, double valorCompra, int cantidadProductos) {
        super(nombre, identificacion, valorCompra);
        this.cantidadProductos = cantidadProductos;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    @Override
    public String toString() {
        return "ClienteMayorista{" +
                "cantidadProductos=" + cantidadProductos +
                ", nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", valorCompra=" + valorCompra +
                '}';
    }
    @Override
    public double calcularTotalPagar(){
        double total = valorCompra;

        if (cantidadProductos >=50){
            total = descontar(50);
        } else if (cantidadProductos >=20) {
            total = descontar(65);
        } else {
            total = aumentar(80);
        }
        if (total > 500000) {
            total = 500000;
        }
        return total;
    }
    @Override
    public void imprimirResumen(double valorFinal){
        System.out.println("RESUMEN DEL CLIENTE MAYORISTA");
        System.out.println("Nombre: "+ nombre);
        System.out.println("Identificación: "+ identificacion);
        System.out.println("Cantidad de productos: "+ cantidadProductos);
        System.out.printf("Valor original de la compra:  %.2f%n", valorCompra);
        System.out.printf("Valor final de la compra:  %.2f%n", valorFinal);
    }
}