/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import java.util.Vector;
import java.io.*;

/**
 *
 * @author leonguevara
 */
public class ListOfNumbers {
    private Vector victor;
    private static final int SIZE = 10;
    
    public ListOfNumbers() {
        victor = new Vector(SIZE);
        for (int i = 0; i < SIZE; i++)
            victor.addElement(new Integer(i));
    }
    public void writeList() {
        PrintWriter out = null;
        
        try {
            System.out.println("Entering try statement");
            out = new PrintWriter(new FileWriter("OutFile.txt"));
            
            for (int i = 0; i < (SIZE + 1) ; i++) {
                System.out.println("Value at: " + i + " = " + victor.elementAt(i));
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " +
                    e.getMessage());
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("Finally: Closing PrintWriter");
                out.close();
            } else {
                System.out.println("Finally: PrintWriter not open");
            }
        }
    }
}
