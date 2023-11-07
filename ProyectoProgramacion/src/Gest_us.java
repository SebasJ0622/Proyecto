import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Gest_us {
    private Map<String, Datos_us> users = new HashMap<>(); 
    private int int_fail =0; 
    private boolean user_block = false; 

    public void ini_ses () {
        if (user_block) {
            System.out.println("Tu usuario esta bloqueado, Debes esperar");
            return; 
        }
        
   Scanner teclas = new Scanner(System.in);
   System.out.print("Ingresa tu usuario o correo electronico: ");
   String usuario = teclas.next(); 
   System.out.print("Ingresa tu contraseña: "); 
   String passw = teclas.next(); 
        
   Datos_us us_reg = users.get(usuario); 
      if (us_reg != null && verf_passw(passw, us_reg)){
          System.out.println("Acceso concedido");
      } else {
          int_fail++; 
          System.out.println("Acceso denegado. ");
       if (int_fail>=3) {
           System.out.println("Usuario Bloqueado. ");
           user_block = true; 
   }
   }   
   }

    
public void reg_usr(){
    Scanner teclas = new Scanner(System.in); 
    System.out.print("Ingresa nuevo usuario: ");
    String new_usr = teclas.next(); 
    System.out.print("Ingresa la nueva contraseña: ");
    String new_pssw = teclas.next(); 

    if (users.containsKey(new_usr)) {
        System.out.println("El usuario ya existe. ");
    } else {
        Datos_us usuario = new Datos_us(new_usr, new_pssw); 
        users.put(new_usr, usuario);
        System.out.println("Usuario Registrado. ");
    }
}
private boolean verf_passw (String passw, Datos_us usuario){
    return usuario.verf_passw(passw); 
}
}


