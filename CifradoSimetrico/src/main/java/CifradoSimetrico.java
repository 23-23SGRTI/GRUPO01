import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

public class CifradoSimetrico {
    public static void main(String[] args) throws Exception {
        Scanner sn = new Scanner(System.in);
        // Se genera clave simétrica AES
        SecretKey secretKey = generateAESKey();
        //datos
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
        // Datos para cifrar
                 long endTime = System.nanoTime();
  long timeElapsed = endTime - startTime;
System.out.println("se ejecuto el ingreso en milisegundosegundos " + timeElapsed / 1000000);
        // Obtencion del Cifrado
                         long starencryp = System.nanoTime();
        byte[] encryptedData = encryptAES(message, secretKey);
        System.out.println("Mensaje cifrado: " + Base64.getEncoder().encodeToString(encryptedData));
                 long endcryp = System.nanoTime();
  long timecryp = endcryp - starencryp;
System.out.println("se ejecuto el cifrado en milisegundosegundos " + timecryp / 1000000);
        // Obtencion del Descifrado
                         long stardes = System.nanoTime();
        String decryptedMessage = decryptAES(encryptedData, secretKey);
        System.out.println("Mensaje descifrado: " + decryptedMessage);
                         long enddes = System.nanoTime();
  long timedes = enddes - stardes;
System.out.println("se ejecuto el decifrado en milisegundosegundos " + timedes / 1000000);
    }

    // Proceso para originar clave simétrica AES
    public static SecretKey generateAESKey() throws NoSuchAlgorithmException {
                                 long starclave = System.nanoTime();
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128); // Tamaño de la clave en bits
         long endclave = System.nanoTime();
  long timeclave = starclave - endclave;
System.out.println("se ejecuto la clave en milisegundosegundos " + timeclave / 1000000);
        return keyGenerator.generateKey();
 
    }

    // Proceso para cifrar usando AES
    public static byte[] encryptAES(String message, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));
    }

    // Proceso para descifrar usando AES
    public static String decryptAES(byte[] encryptedData, SecretKey secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedData = cipher.doFinal(encryptedData);
        return new String(decryptedData, StandardCharsets.UTF_8);
    }
}

