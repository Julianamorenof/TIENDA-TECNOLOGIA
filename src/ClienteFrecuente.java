public class ClienteFrecuente extends Cliente{

    private int numeroCompras;

    public ClienteFrecuente(){

    }

    public ClienteFrecuente(String nombre, String identificacion, double valorCompra, int numeroCompras) {
        super(nombre, identificacion, valorCompra);
        this.numeroCompras = numeroCompras;
    }

    public int getNumeroCompras() {
        return numeroCompras;
    }

    public void setNumeroCompras(int numeroCompras) {
        this.numeroCompras = numeroCompras;
    }

    @Override
    public String toString() {
        return "ClienteFrecuente{" +
                "numeroCompras=" + numeroCompras +
                ", nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", valorCompra=" + valorCompra +
                '}';
    }
    @Override
    public double calcularTotalPagar(){
        double total = valorCompra;

        if (numeroCompras >= 20) {
            total = descontar(30);
        } else if (numeroCompras >= 10) {
            total = descontar(20);
        } else {
            total = descontar(10);
        }
        if (compraAlta()) {
            total = total * 0.95; //aqui va a hacer el descuento del 5% sobre ya el descuento que se pudo haber hecho anteriormente
        }

        return total;
    }
    @Override
    public void imprimirResumen(double valorFinal){
        System.out.println("RESUMEN DEL CLIENTE FRECUENTE");
        System.out.println("Nombre: "+ nombre);
        System.out.println("Identificación: "+ identificacion);
        System.out.println("Número de compras: "+ numeroCompras);
        System.out.printf("Valor original de la compra:  %.2f%n", valorCompra);
        System.out.printf("Valor final de la compra:  %.2f%n", valorFinal);
    }
}
