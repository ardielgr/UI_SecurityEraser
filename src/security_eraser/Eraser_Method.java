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
    
}
