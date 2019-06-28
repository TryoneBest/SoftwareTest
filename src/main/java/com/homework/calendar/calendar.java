package com.homework.calendar;



import java.util.Scanner;

public class calendar {
    public int year,month,day;
    calendar(int year,int month,int day){
        this.year=year;
        this.month=month;
        this.day=day;
    }
    public String nextDayRun() {
        if (this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 8 || this.month == 10 || this.month == 12) {
            if(this.day>31){
                return "Wrong Input";

            }
            else if(this.day==31){
                if(this.month==12){
                    this.month=1;this.day=1;this.year++;
                }else {
                    this.month++;this.day=1;
                }
            }else
                this.day++;
        }else if(this.month==2){
            if(this.day>29){
                return "Wrong Input";
            }else if(this.day==29){
                this.month++;this.day=1;
            }else
                this.day++;
        }else {
            if(this.day>30)
                return "Wrong Input";
            else if(this.day==30){
                this.month++;this.day=1;
            }
            else
                this.day++;
        }
        return "The next day is "+this.year+this.month+this.day;
    }
    public String nextDayPing(){
        if (this.month == 1 || this.month == 3 || this.month == 5 || this.month == 7 || this.month == 8 || this.month == 10 || this.month == 12) {
            if(this.day>31){
                return "Wrong Input";

            }
            else if(this.day==31){
                if(this.month==12){
                    this.month=1;this.day=1;this.year++;
                }else {
                    this.month++;this.day=1;
                }
            }else
                this.day++;
        }else if(this.month==2){
            if(this.day>28){
                return "Wrong Input";
            }else if(this.day==28){
                this.month++;this.day=1;
            }else
                this.day++;
        }else {
            if(this.day>30)
                return "Wrong Input";
            else if(this.day==30){
                this.month++;this.day=1;
            }
            else
                this.day++;
        }
        return "The next day is "+this.year+"/"+this.month+"/"+this.day;

    }

    public static void main(String []args){
        Scanner sc = null;
        String stop_tag = "c";
        int year, month, day;
        try {
            sc = new Scanner(System.in);
            System.out.println("Please input year.month.day divided with space:");
            year = sc.nextInt();
            month = sc.nextInt();
            day = sc.nextInt();
            if(year>=1900&&year<=2400&&day>=1&&day<=31&&month>=1&&month<=12){
                calendar  calendar_entity= new calendar(year, month, day);
                if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
                    System.out.println(calendar_entity.nextDayRun());
                else
                    System.out.println(calendar_entity.nextDayPing());
            }else
                System.out.println("Wrong Input");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(sc != null){
                sc.close();
                sc = null;
            }
        }
    }
}
