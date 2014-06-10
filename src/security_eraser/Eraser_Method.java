/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package security_eraser;
/**
 *
 * @author Aegis
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Random;

public class Eraser_Method {
    final static int MAX = 122;
    final static int MIN = 48;
	
    String variable_;
    static RandomAccessFile file_;
    static ArrayList<String> buffer = new ArrayList<String>();
    	
    public Eraser_Method(String arg) throws FileNotFoundException {
	variable_ = arg;
	file_ = new RandomAccessFile(variable_, "rw");
    }
    
    public void OpenFile(File file) throws IOException{
        String blabla;
        blabla = file.getName();
        Eraser_Method Eraser = new Eraser_Method(blabla);
        try{
            do{
                System.out.println(file_.readLine());
            }while ((file_.readLine())!= null);
        }catch (IOException e){
            System.out.println("Error con el fichero");
            return;
        }
    }
    
    public static int Random(int min, int max){
        Random rnd = new Random();
        int aux_rnd= rnd.nextInt((max-min)+1)+min;
        return aux_rnd;
    }
    public static char getRandomChar(){
        return (char)Random(MIN,MAX);
    }
    
   /* public static int LineNumber() throws IOException{
        int line_number= 0;
        try{
            file_.seek(0);
            do{
                file_.readLine();
                line_number++;
            }while (file_.readLine() != null);
            
        }catch (IOEXception e){
            System.out.println("Error con el fichero");
            return -1;
        }
        return line_number;
    }*/
    
    public void FileDump() throws IOException{
        String line;
        line = file_.readLine();
        while (line != null){
            System.out.println(line);
            System.out.print("--------------");
            buffer.add(line);
            line = file_.readLine();
        }
    }
    public void RandomChange() throws IOException{
        int line_value;
        String line, line2;
        String cadena = new String();
        file_.seek(0);
        try{
            int number = buffer.size();
            System.out.println("{number} numero de filas que tiene el buffer");
            for (int j=0; j< buffer.size(); j++){
                line = buffer.get(j);
                line_value = line.length();
                System.out.println(line_value);
                for (int i= 0; i < line_value; i++)
                    cadena += getRandomChar();
                line2 = System.getProperty("line.separator");
                cadena += line2;
                cadena = cadena.toString();
                file_.writeBytes(cadena);
                cadena ="";
            }
            file_.close();
        } catch(IOException e){
            System.out.println("Error con el fichero");
        }
    }
    
    
}
