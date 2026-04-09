public class ClienteRegular extends Cliente{

    public ClienteRegular(){

    }

    public ClienteRegular(String nombre, String identificacion, double valorCompra) {
        super(nombre, identificacion, valorCompra);
    }

    @Override
    public String toString() {
        return "ClienteRegular{" +
                "nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", valorCompra=" + valorCompra +
                '}';
    }

    public double calcularTotalPagar(){
        double total = valorCompra;

        if (valorCompra >=300000){
            total = descontar(8);
        } else if (valorCompra >=150000) {
            total = descontar(5);
        } else if (valorCompra <=60000) {
            total = aumentar(6);
        }
        return total;
    }
    @Override
    public void imprimirResumen(double valorFinal){
        System.out.println("RESUMEN DEL CLIENTE REGULAR");
        System.out.println("Nombre: "+ nombre);
        System.out.println("Identificación: "+ identificacion);
        System.out.printf("Valor original de la compra:  %.2f%n", valorCompra);
        System.out.printf("Valor final de la compra:  %.2f%n", valorFinal);
    }
}
