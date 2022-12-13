/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator_usingthreads;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

/**
 *
 * @author engmo
 */
public class Calculator_usingThreads {
    
    public static int check_index_operator(String operator){
        if (operator.contains("+"))
            return operator.indexOf('+');
        else if (operator.contains("-"))
            return operator.indexOf('-');
        else if (operator.contains("*"))
            return operator.indexOf('*');
        else if (operator.contains("/"))
            return operator.indexOf('/');
        else
            return -1;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Instant start = Instant.now();
        // TODO code application logic here
        System.out.print("First Operation : ");
        Scanner input = new Scanner(System.in);
        String operation_one = input.nextLine();
        char operator_one = operation_one.charAt(check_index_operator(operation_one));
        int num_one = Character.getNumericValue(operation_one.charAt(0));
        int num_two = Character.getNumericValue(operation_one.charAt(2));
        System.out.print("Second Operation : ");

        String operation_two = input.nextLine();
        char operator_two = operation_two.charAt(check_index_operator(operation_two));
        int num_three = Character.getNumericValue(operation_two.charAt(0));
        int num_four = Character.getNumericValue(operation_two.charAt(2));
        
       Calc_thread opeartion_one_thread = new Calc_thread(num_one, num_two, operator_one);
       Calc_thread operation_two_thread = new Calc_thread(num_three, num_four, operator_two);
       System.out.println();
//       System.out.println("Start Executing using Threads");
       Thread thread_one = new Thread(opeartion_one_thread);
       Thread thread_two = new Thread(operation_two_thread);
       thread_one.start();
       thread_two.start();
        System.out.println("Result");
       System.out.println("Done in : "+Duration.between(start, Instant.now()).toMillis());
    }
    
}
