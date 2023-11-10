import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Gest_us g_Us = new Gest_us(); 
        Scanner teclas = new Scanner(System.in); 

        while (true) {
            System.out.println("1. Iniciar Sesion");
            System.out.println("2. Registrar nuevo usuario");
            System.out.println("3. Salir");
            System.out.println("Selecciona una opcion: ");
            int opcion = teclas.nextInt(); 

            switch (opcion) {
                case 1:
                    g_Us.login();
                    break;
                case 2: 
                    reg_us();
                break;
                case 3: 
                System.out.println("Hasta luego");
                System.exit(0);
                default: 
                System.out.println("Opcion no valida." + "\nPor favor escoge una opcion valida");
            }
        }        
    }

    private static void reg_us (){
        Scanner teclaso = new Scanner(System.in); 

        System.out.println("Ingrese nombre de usuario: ");
        String new_user = teclaso.nextLine(); 

        System.out.println("Ingrese Correo: ");
        String new_mail= teclaso.nextLine(); 

        System.out.println("Ingrese nueva contraseña: ");
        String new_passw = teclaso.nextLine(); 

        String[] newUserArray = new String[]{new_user, new_mail, Datos_us.encriptar(new_passw)};
        int posicion = 0; 
        while (posicion < Datos_us.g_users().length && Datos_us.g_users()[posicion] != null) {
            posicion++;            
        }

        if (posicion < Datos_us.g_users().length) {
            Datos_us.g_users()[posicion] = newUserArray;
            System.out.println("Usuario registrado exitosamente. ");            
        } else {
            System.out.println("El sistema ha alcanzado el limite de usuarios. ");
        }
    }
}
