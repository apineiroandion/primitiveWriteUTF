import java.io.*;

public class Main {
    /**
     * Ruta do arquivo a escribir/ler
     */
    static String ruta = "/home/dam/Desktop/primitiveWriteUTF/texto3.txt";
    /**
     * Cadea a escribir
     */
    static String cadea = "O tempo está xélido";
    /**
     * Obxectos para escribir/ler
     */
    static FileOutputStream fos;
    static FileInputStream fis;
    static BufferedInputStream bis;
    static BufferedOutputStream bos;
    static DataInputStream dis;
    static DataOutputStream dos;
    public static void main(String[] args) {
        escribirUTF();
        leerUTF();
    }

    /**
     * Metodo que escribe tres cadeas de texto cada vez que se executa o programa
     */
    public static void escribirUTF() {
        try {
            //pomos o true para que non se sobreescriba o arquivo
            fos = new FileOutputStream(ruta, true);
            bos = new BufferedOutputStream(fos);
            dos = new DataOutputStream(bos);
            //bucle que escribe tres cadeas de texto e nos di cantos bytes levamos escritos
            for (int i=0; i<3; i++) {
                dos.writeUTF(cadea);
                System.out.println("Escribimos: " + cadea);
                System.out.println("levamos "+ dos.size() +" Bytes escritos");
            }
            dos.close();
        } catch (IOException e) {
            System.out.println("Error de escritura");
        }
    }

    /**
     * Metodo que lee as cadeas de texto do arquivo
     */
    public static void leerUTF() {
        try {
            fis = new FileInputStream(ruta);
            bis = new BufferedInputStream(fis);
            dis = new DataInputStream(bis);
            //Mentres haxa bytes que ler, imprimimos a cadea e os bytes restantes
            while (dis.available() > 0) {
                System.out.println(dis.readUTF());
                System.out.println("Bytes restantes: " + dis.available());
            }
            //Se non quedan bytes por ler, imprimimos unha mensaxe
            if (dis.available() == 0) {
                System.out.println("Xa non queda nada por ler");
            }
            dis.close();
        } catch (IOException e) {
            System.out.println("Error de lectura");
        }
    }


}
