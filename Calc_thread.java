/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator_usingthreads;

/**
 *
 * @author engmo
 */
public class Calc_thread implements Runnable{
int a;
int b;
char operator;

    public Calc_thread(int a, int b, char operator) {
        this.a = a;
        this.b = b;
        this.operator = operator;
    }

    @Override
    public void run() {
//        System.out.println(Thread.currentThread().getName()+" is running");
        int result = 0;
        switch(operator){
        case '+':
             result = a+b;
            break;
        case '-':
             result = a-b;
            break;
        case '*':
             result = a*b;
            break;
        case '/':
            result = a/b;
            break;
           
        }
        
        System.out.println(a+" "+operator+" "+b+" = "+result);
    }
 
    
}
