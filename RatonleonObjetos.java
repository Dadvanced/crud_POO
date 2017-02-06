/*
*
* @author David León Galisteo
* Crud - Ratonleon versión array de objetos
*
*/
import java.util.Scanner; //importamos la clase Scanner con la que poder introucir datos

public class RatonleonObjetos {
  public static void main(String[] args) {
    System.out.println("Bienvenido al programa de gestión de ratones, \"Ratonleon\".");
    System.out.println();
    
    int option = 0; //en ésta variable guardamos la opción escogida por el usuario.
    Scanner n = new Scanner(System.in);
    
    Raton[] ratones = new Raton[100];
    
    for (int i = 0; i < 100; i++) { //inicializamos valores del array de objetos
      ratones[i] = new Raton();
    }
    
    ratones[0].setMarca("Razer");
    ratones[0].setTipo("Laser");
    ratones[0].setPrecio(60);
    
    ratones[1].setMarca("Logitecth");
    ratones[1].setTipo("Óptico");
    ratones[1].setPrecio(30);
    
    ratones[2].setMarca("Sharkoon");
    ratones[2].setTipo("Inalámbrico");
    ratones[2].setPrecio(25);
    
    
    
     //////////////////////////////////////////////////////////////////////////////////
    boolean exit = false;
    while (!exit) {
      System.out.println("┌───────────────────────────────────────────────────────────────┐");
      System.out.println("│                       Elija una opción                        │");
      System.out.println("└───────────────────────────────────────────────────────────────┘");
      System.out.println("[1]: Visualizar los productos.");
      System.out.println("[2]: Añadir nuevos datos.");
      System.out.println("[3]: Modificar datos existentes.");
      System.out.println("[4]: Eliminar datos.");
      System.out.println("[5]: Salir.");
      System.out.println("────────────────────────────────────────────────────────────────┘");
      System.out.println();
      
      boolean opcionCorrecta = false; //comprueba si la opción escogida por el usuario es correcta
      while (!opcionCorrecta) {
        System.out.print("Opción: ");
        option = Integer.parseInt(n.nextLine());
        System.out.println();
        
        switch (option) {
          case 1:
            visualizar(ratones);
            opcionCorrecta = true;
            break;
            
          case 2:
            nuevosDatos(ratones);
            opcionCorrecta = true;
            break;
            
          case 3:
            modificaDatos(ratones);
            opcionCorrecta = true;
            break;
            
          case 4:
            eliminaDatos(ratones);
            opcionCorrecta = true;
            break;
            
          case 5:
            opcionCorrecta = true;
            exit = true;
            break;
            
          default:
            System.out.println("La opción elegida no existe, vuelva a introducir un número.");
        }
      }// while
    }//while  39
  }
  
  //////////////////////////////FUNCIONES////////////////////////////////////
  
   /**
  * Visualiza los productos que tenemos guardados
  * @param marca array de tipo string que indica la marca del producto
  * @param precio array de tipo double que indica el precio del producto
  * @param tipo array de tipo string que indica el tipo del producto
  */
  public static void visualizar(Raton ratones[]) {
    System.out.println("┌──────┬─────────────────┬─────────────────┬────────────────┐");
    System.out.println("│Índice│      Marca      │       Tipo      │    Precio      │");
    System.out.println("├──────┼─────────────────┼─────────────────┼────────────────┤");
    
    for (int i = 0; i < ratones.length; i++) {
      if (ratones[i].getMarca().equals("vacío")) {
      } else {
        System.out.printf("│%6d│ %-15s │ %-15s │ %14.2f │", 
        (i + 1), ratones[i].getMarca(), ratones[i].getTipo(), ratones[i].getPrecio());
        System.out.println();
      }
    }
    
    System.out.println("└──────┴─────────────────┴─────────────────┴────────────────┘");
    System.out.println();
    System.out.println();
    
  }
  
  
    /**
  * Añade a los arrays <code>marca, tipo y precio</code> nuevos valores
  * @param marca usaremos éste array para encontrar un hueco libre para introducir datos.
  * @param tipo usaremos éste parámetro para modificar el array <code>tipo</code>
  * @param precio usaremos éste parámetro para modificar el array <code>precio</code>
  */
  
  public static void nuevosDatos(Raton ratones[]) {
    Scanner f = new Scanner(System.in);
    int espacioDisponible = 0;
    int repeticiones = ratones.length - 1;
    int inicio = 0;
    boolean esEspacioLibre = false;
    
    while (repeticiones >= 0 && !esEspacioLibre) { //comprueba el hueco libre para añadir datos
      if (ratones[inicio].getMarca() == "vacío") {
        espacioDisponible = inicio;
        esEspacioLibre = true;
      }
      repeticiones--;
      inicio++;
    }
    
    if (esEspacioLibre) {
      System.out.print("Por favor introduzc la nueva marca: ");
      ratones[espacioDisponible].setMarca(f.nextLine());
      System.out.println();
      System.out.print("Por favor introduzca el nuevo tipo: ");
      ratones[espacioDisponible].setTipo(f.nextLine());
      System.out.println();
      System.out.print("Por favor introduzca el precio: ");
      ratones[espacioDisponible].setPrecio(Double.parseDouble(f.nextLine()));;
      System.out.println();
      
      System.out.println();
      System.out.println("Se han añadido correctamente los nuevos valores.");
      System.out.println("Puede usted elegir la opción 1 del menú si desea visualiarlos.");
      System.out.println();
      System.out.println();
    } else {
      System.out.println();
      System.out.println("Lo siento, no hay espacio para nuevos datos.");
      System.out.println("Puede uster eleminar entradas para introducir nuevos datos.");
      System.out.println();
      System.out.println();
    }
  }
  
  
  /**
  * Modifica valores ya existentes de un registro.
  * @param marca usaremos éste array para encontrar un hueco libre para introducir datos.
  * @param tipo usaremos éste parámetro para modificar el array <code>tipo</code>
  * @param precio usaremos éste parámetro para modificar el array <code>precio</code>
  * @param indice es el número introducizo por el usuario para escoger índice a modificar.
  */
    
    
  public static void modificaDatos(Raton ratones[]) {
    Scanner f = new Scanner(System.in);
    
    int indice = 0;
    boolean esVacio = false;
    
    while (!esVacio) {
      System.out.print("Por favor, introduzca el número de registro que desee modificar: ");
      indice = Integer.parseInt(f.nextLine());
      if (ratones[indice - 1].getMarca().equals("vacío")) {
        System.out.println("\nEse registro está vacío, seleccione uno que ya contenga valores.");
      } else {
        esVacio = true;
      }
    }
    System.out.println();
    
    String marcaIntroducida = "";
    String tipoIntroducido = "";
    String precioIntroducido = "";
    
    if (indice < ratones.length) {
      System.out.println("Marca actual: " + ratones[indice - 1].getMarca());
      System.out.print("Por favor introduzc la nueva marca (pulse INTRO para NO modificar datos): ");
      marcaIntroducida = f.nextLine();
      if (!marcaIntroducida.equals("")) {
        ratones[indice - 1].setMarca(marcaIntroducida);
      }
      
      System.out.println();
      System.out.println("Tipo actual: " + ratones[indice - 1].getTipo());
      System.out.print("Por favor introduzca el nuevo tipo (pulse INTRO para NO modificar datos): ");
      tipoIntroducido = f.nextLine();
      if (!tipoIntroducido.equals("")) {
        ratones[indice - 1].setTipo(tipoIntroducido);
      }
      
      System.out.println();
      System.out.println("Precio actual: " + ratones[indice - 1].getPrecio());
      System.out.print("Por favor introduzca el precio (pulse INTRO para NO modificar datos): ");
      precioIntroducido = (f.nextLine());
      if (!precioIntroducido.equals("")) {
        ratones[indice - 1].setPrecio(Double.parseDouble(precioIntroducido));
      }
      
      System.out.println();
      
      System.out.println();
      System.out.println("Se han añadido correctamente los nuevos valores.");
      System.out.println("Puede usted elegir la opción 1 del menú si desea visualiarlos.");
      System.out.println();
      System.out.println();
    } else {
      System.out.println();
      System.out.println("Lo siento, el registro introducido no existe.");
      System.out.println("Vuelva a elegir la opción 2 en el menú.");
      System.out.println();
      System.out.println();
    }
        
  }
  
  
  
  /**
  * Elimina / reinicializa los datos de un registro
  * @param marca eliminamos / reinicializamos el array <code>marca</code>.
  * @param tipo eliminamos / reinicializamos el array <code>tipo</code>.
  * @param precio eliminamos / reinicializamos el array <code>precio</code>.
  */
  
  public static void eliminaDatos(Raton ratones[]) {
    Scanner f = new Scanner(System.in);
      
    System.out.print("Por favor, introduzca el número de registro que desee eliminar: ");
    int indice = Integer.parseInt(f.nextLine());
      
    if (indice < ratones.length) {
      ratones[indice - 1].setMarca("vacío");
      ratones[indice - 1].setTipo("vacío");
      ratones[indice - 1].setPrecio(0);
      
      System.out.println();
      System.out.println("Se han eliminado correctamente los datos señalados.");
      System.out.println();
      System.out.println();
    } else {
      System.out.println();
      System.out.println("Lo siento, el registro introducido no existe.");
      System.out.println("Vuelva a elegir la opción 2 en el menú.");
      System.out.println();
      System.out.println();
    }
        
  }
  
  
}
