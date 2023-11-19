import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;




public class Datos_us {
    
    private static String [][] users = new String[10][3]; 
    private static int int_fail = 0; 
    public static final int max_fail = 3; 

    static {
        users[0] = new String[]{"Andres", "andres123@gmail.com",encriptar("Andres123")};
        users[1] = new String[]{"David", "david1@gmail.com", encriptar("David123")};
        users[2] = new String[]{"Luis", "luis1@gmail.com", encriptar("Luis123")}; 
        users[3] = new String[]{"Andrea", "andrea1@gmail.com", encriptar("Andrea123")};
        users[4] = new String[]{"Luisa", "luisa1@gmail.com", encriptar("Luisa123")};
        users[5] = new String[]{"Daniel", "dani.123@gmail.com", encriptar("Dani123")};
    }

    public static String[][] g_users(){
        return users; 
    }

    public static void s_user (String[][] new_users){
        users = new_users; 
    }

    public static void inc_intFail (){
        int_fail++; 
    }

    public static int g_intFail (){
        return int_fail; 
    }

    public static void res_intFail(){
        int_fail = 0; 
    }

    public static void block_user (){
        System.out.println("Usuario bloqueado por demasiados intentos fallidos");
    }

    public static String encriptar(String passw){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(passw.getBytes()); 
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : hashBytes){
                stringBuilder.append(String.format("%02x", b));
            }
            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null; 
        }
    }

    public static boolean verf_passw (String in_user, String in_passw){
        for (String [] user : g_users()) {
            if (user!= null && (user[0].equals(in_user)|| user[1].equals(in_user))) {
                return encriptar(in_passw).equals(user[2]);
            }
        }
        return false; 
    }

    public static boolean add_nUser(String new_user, String new_mail, String new_passw){
        for (int i = 0; i < users.length; i++) {
            if (users[i][0] == null) {
                users[i][0] = new_user;
                users[i][1] = new_mail;
                users[i][2] = encriptar(new_passw);
                System.out.println("Usuario registrado exitosamente. ");
                return true; 
            }
        }
        System.out.println("El sistema ha alcanzado el limite de usuarios.");
        return false;
    }
}

        
       

