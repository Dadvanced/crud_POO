/**
* Clase raton
* Crud versión POO
*
* @author David León Galisteo
*/

public class Raton {
  private String marca;
  private String tipo;
  private double precio;
  
  public Raton(String m, String t, double p) {
    this.marca = m;
    this.tipo = t;
    this.precio = p;
  }
  
  public Raton() {
    this.marca = "vacío";
    this.tipo = "vacío";
    this.precio = -1;
  }
  
  public String getMarca() {
    return this.marca;
  }
  
  public void setMarca(String marca) {
    this.marca = marca;
  }
  
  public String getTipo() {
    return tipo;
  }
  
  public void setTipo(String tipo) {
    this.tipo = tipo;
  }
  
  public double getPrecio() {
    return precio;
  }
  
  public void setPrecio(double precio) {
    this.precio = precio;
  }
  
}
  
  
