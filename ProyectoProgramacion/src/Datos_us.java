import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Datos_us {
    private String nom_user;
    private String passw_Hash; 
    private String sal; 

    public Datos_us (String nom_user, String passw){
        this.nom_user = nom_user;
        this.sal = generateSalRandom(); 
        this.passw_Hash = generateHash(passw,sal); 
    }

    public String g_nomUs(){
        return nom_user; 
    }

    public String g_passwHash(){
        return passw_Hash; 
    }

    public String g_sal(){
        return sal; 
    }

    private String generateSalRandom(){
        SecureRandom random = new SecureRandom(); 
        byte[] sal = new byte[16]; 
        random.nextBytes(sal);
        return Base64.getEncoder().encodeToString(sal); 

    }

    private String generateHash (String passw, String sal) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte [] bytes = md.digest((passw + sal).getBytes()); 
            return Base64.getEncoder().encodeToString(bytes); 
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null; 
    }

    public boolean verf_passw (String passw){
        String ing_passHash = generateHash(passw, sal); 
        return ing_passHash.equals(this.passw_Hash);
    }
}

