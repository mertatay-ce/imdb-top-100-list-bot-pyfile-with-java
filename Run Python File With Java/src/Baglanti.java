/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Mert Atay
 */
public class Baglanti {
     public static void main(String[] args) throws InterruptedException {
        File file = new File(("src\\py\\proje.py"));
        ArrayList<String> filmler = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("python.exe");
        String absPath = file.getAbsolutePath();

        System.out.println("absPath>>"+absPath);

        list.add(absPath);
        ProcessBuilder pb = new ProcessBuilder(list);
        Process process;
         try {
             process = pb.start();
            InputStream inputStream = process.getInputStream();
            byte[] b = new byte[1024 * 1024];// {(byte) 1024};
             while (inputStream.read(b) > 0) {
                String text = new String(b);
                filmler.add(text);
             System.out.println("b.length>>"+new String(b));
             }

          process.waitFor();
        System.out.println("exitValue()>>"+process.exitValue());
         } catch (IOException ex) {
             Logger.getLogger(Baglanti.class.getName()).log(Level.SEVERE, null, ex);
         }
         System.out.println();
       for(String film:filmler){
           System.out.println("film:"+ film);
       }
       
        
    }     
}
