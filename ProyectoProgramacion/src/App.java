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
                    g_Us.ini_ses();
                    break;
                case 2: 
                    g_Us.reg_usr();
                break;
                case 3: 
                teclas.close();
                System.exit(0);
                default: 
                System.out.println("Opcion no valida." + "\nPor favor escoge una opcion valida");
            }
        }
        
    }
}
