import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class CifradoHash{
    public static void main(String[] args) throws Exception {
               Scanner sn = new Scanner(System.in);
               //leer archivo
                        long startTime = System.nanoTime();
                System.out.println("ingrese la ruta del archivo");
        String ruta = sn.next();
        File archivo = new File (ruta);
        FileReader fr = new FileReader (archivo);
        BufferedReader br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         String message ="";
         while((linea=br.readLine())!=null)
            message=message + linea ;
                 long endTime = System.nanoTime();
  long timeElapsed = endTime - startTime;
System.out.println("se ejecuto el ingreso del texto en milisegundosegundos " + timeElapsed / 1000000);
        // Mensaje a digerir

        
        
        // Creando el hash del mensaje
        String hash = calculateSHA256Hash(message);
        System.out.println("Hash SHA-256: " + hash);
    }

    // Calculando el algoritmo hash SHA-256
    public static String calculateSHA256Hash(String message) throws NoSuchAlgorithmException {
                                long starclave = System.nanoTime();
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
                         long endclave = System.nanoTime();
  long timeclave = endclave - starclave;
System.out.println("se ejecuto la creacion de la clave del texto en milisegundosegundos " + timeclave / 1000000);
                                long starhash = System.nanoTime();
        byte[] encodedHash = digest.digest(message.getBytes(StandardCharsets.UTF_8));
                                         long endhash = System.nanoTime();
  long timehash = endhash - starhash;
System.out.println("se ejecuto el cifrado del texto en milisegundosegundos " + timeclave / 1000000);
        return bytesToHex(encodedHash);

    }

    // Bytes a hexadecimal
    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }
}

