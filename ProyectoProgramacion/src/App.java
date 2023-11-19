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

        boolean user_agg = Datos_us.add_nUser(new_user, new_mail, new_passw);
       if (!user_agg) {
        System.out.println("No se pudo agregar el usuario.");
       }
    }
}