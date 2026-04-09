public class Cliente {

    protected String nombre;
    protected String identificacion;
    protected double valorCompra;

    public Cliente(){

    }

    public Cliente(String nombre, String identificacion, double valorCompra) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.valorCompra = valorCompra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", valorCompra=" + valorCompra +
                '}';
    }

    public double calcularTotalPagar(){
        return valorCompra;
    }

    public double descontar(double porcentaje){
        double descuento = valorCompra * porcentaje/100;
        double total = valorCompra - descuento;
        return total;
    }

    public double aumentar(double porcentaje){
        double aumento = valorCompra * porcentaje/100;
        double total = valorCompra + aumento;
        return total;
    }

    public boolean compraAlta(){
        return valorCompra > 300000;
    }
    public void imprimirResumen(double valorFinal){
        System.out.println("RESUMEN DEL CLIENTE");
        System.out.println("Nombre: "+ nombre);
        System.out.println("Identificación: "+ identificacion);
        System.out.printf("Valor original de la compra:  %.2f%n", valorCompra);// en estos casos no indento porque no me daria el salto de linea al mostrar la info
        System.out.printf("Valor final de la compra:  %.2f%n", valorFinal);
    }
}

