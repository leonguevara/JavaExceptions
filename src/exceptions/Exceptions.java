/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import javax.swing.JOptionPane;

/**
 *
 * @author leonguevara
 */
public class Exceptions {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //divideByZero();
        //multipleCatch();
        //ExperienceExceptions experience = new ExperienceExceptions();
        
        //ListOfNumbersTest();
        
        callException();
        //callingMyException();
    }
    
    public static void divideByZero() {
        try {
            System.out.println(3/0);
        } catch (ArithmeticException ae) {
            System.out.println(ae);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void multipleCatch() {
        // Enter the following values and see what exception is caught.
        //    0, 4, character, <no value>
        try {

            String value = JOptionPane.showInputDialog(null, "Enter value:");
            
            // Non-numerica value will result an NumberFormatException
            int divisor = Integer.parseInt(value);
            
            // If the divisor is 0, it will result in ArithmetricException
            System.out.println(3/divisor);

        } catch (NumberFormatException nfe){
            System.out.println("Exception caught by this program: Enter numeric value.");
            System.out.println(nfe.getMessage());
        } catch (ArithmeticException exc) {
            System.out.println("Exception caught by this program: Divisor was 0.");
            System.out.println("Cause: " + exc.getCause());
            System.out.println(exc.getMessage());
            System.out.println(exc.getLocalizedMessage());
            System.out.println(exc.toString());
        }
        System.out.println("After exception.");
    }
    
    public static void ListOfNumbersTest() {
        ListOfNumbers list = new ListOfNumbers();
        list.writeList();
    }
    
    public static void callException() {
        try {
            throw new Exception("My Exception");
        } catch (Exception e) {
            System.err.println("Caught Exception");
            System.err.println("getMessage():" + e.getMessage());
            System.err.println("getLocalizedMessage():" + e.getLocalizedMessage());
            System.err.println("toString():" + e);
            System.err.println("printStackTrace():");
            e.printStackTrace();
        }
    }
    
    public static void callingMyException() {
        try {
            f();
        } catch (MyException e) {
            e.printStackTrace();
        }

        try {
            g();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
    
    public static void f() throws MyException {
        System.out.println("Throwing MyException from f()");
        throw new MyException();
    }
    
    public static void g() throws MyException {
        System.out.println("Throwing MyException from g()");
        throw new MyException("Originated in g()");
    }
}
