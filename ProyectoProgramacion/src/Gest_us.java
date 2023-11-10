import java.util.Arrays;
import java.util.Scanner;

public class Gest_us {

    public static void login (){
    
    Scanner teclas = new Scanner(System.in); 

    System.out.print("Ingrese usuario o correo: ");
    String in_user = teclas.nextLine(); 

    System.out.print("Ingrese contraseña ");
    String in_passw = teclas.nextLine();

    boolean acceso_concedido = Datos_us.verf_passw(in_user, in_passw) ;
    
    if (acceso_concedido) {
        System.out.println("Acceso Concedido.  ¡Bienvenido, " + in_user + "!");
        Datos_us.res_intFail();        
    } else {
        System.out.println("Acceso Denegado. Usuario o contraseña incorrectos. ");
        System.out.println("Intentos fallidos: " + Datos_us.g_intFail());
        if (Datos_us.g_intFail() >= Datos_us.max_fail) {
            Datos_us.block_user();    
        }
    }    
}
}


