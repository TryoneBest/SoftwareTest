package com.homework.commission;

import java.util.Scanner;

public class commission {

    public  int numMainframe,numScreen,numPeripherals;
    commission(int numMainframe,int numScreen,int numPeripherals){
        this.numMainframe=numMainframe;
        this.numScreen=numScreen;
        this.numPeripherals=numPeripherals;
    }


    public double commissionCount(){
        int sumSales = 25*this.numMainframe+30*numScreen+45*numPeripherals;
        if(sumSales<=1000)
            return 0.1*sumSales;
        else if(sumSales<=1800)
            return 0.15*sumSales;
        else
            return 0.2*sumSales;
    }

    public static void main(String []args){
        Scanner scanner = null;
        int numMainframe,numScreen,numPeripherals;
        try {
            scanner = new Scanner(System.in);
            System.out.println("Please input the number of mainframe,Screen,peripherals that salesman sold divided with space");
            numMainframe = scanner.nextInt();
            numScreen=scanner.nextInt();
            numPeripherals=scanner.nextInt();
            if(numMainframe>0&&numMainframe<71&&numScreen>0&&numScreen<81&&numPeripherals>0&&numPeripherals<91){
                commission commission_entity =new  commission(numMainframe,numScreen,numPeripherals);
                System.out.println((commission_entity.commissionCount()));
            }else {
                System.out.println("Wrong Input");
            }
        }catch (Exception E){
            E.printStackTrace();
        }finally {
            if(scanner!=null)
                scanner.close();
        }
    }
}
