import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.util.Scanner;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class CifradoAsimetrico {
    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
            Scanner sn = new Scanner(System.in);

        // Se realiza claves RSA
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "BC");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // Conseguir clave pública y clave privada
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
//ingreso del texto
         long startTime = System.nanoTime();
System.out.println("ingrese la ruta del archivo");
        String ruta = sn.next();

        File archivo = new File (ruta);
        FileReader fr = new FileReader (archivo);
        BufferedReader br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         String message = "";
         while((linea=br.readLine())!=null)
            message=message + linea ;
        // Cifrado de Datos
  long endTime = System.nanoTime();
  long timeElapsed = endTime - startTime;
System.out.println("se ejecuto el ingreso en milisegundosegundos " + timeElapsed / 1000000);



         long startClave = System.nanoTime();

        // Cifrado donde se usa la clave pública
        byte[] encryptedData = encryptRSA(message.getBytes(), publicKey);
        System.out.println("Mensaje cifrado: " + new String(encryptedData));

        // Descifrado donde se usa la clave privada
        byte[] decryptedData = decryptRSA(encryptedData, privateKey);
        System.out.println("Mensaje descifrado: " + new String(decryptedData));
            
      long endClave = System.nanoTime();
  long timeclave = endClave - startClave ;
System.out.println("se ejecuto el ingreso en milisegundosegundos " + timeclave / 1000000);
    }


    // Proceso para cifrar usando RSA
    public static byte[] encryptRSA(byte[] data, PublicKey publicKey) throws Exception {
                 long startencrip = System.nanoTime();
        // Conseguri la instancia cifrador RSA
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/None/PKCS1Padding", "BC");
        cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, publicKey);

        // Cifrar datos
         long endcrip = System.nanoTime();
  long timeclave = endcrip - startencrip ;
System.out.println("se ejecuto el ingreso en milisegundosegundos " + timeclave / 1000000);
        return cipher.doFinal(data);
    }

    // Proceso para descifrar usando RSA
    public static byte[] decryptRSA(byte[] encryptedData, PrivateKey privateKey) throws Exception {
        // Obtener instancia de cifrador RSA
                         long startdecrip = System.nanoTime();
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/None/PKCS1Padding", "BC");
        cipher.init(javax.crypto.Cipher.DECRYPT_MODE, privateKey);

        // Descifrar datos
                 long enddecrip = System.nanoTime();
  long timeclave = enddecrip - startdecrip ;
System.out.println("se ejecuto el ingreso en milisegundosegundos " + timeclave / 1000000);
        return cipher.doFinal(encryptedData);
    }
}

