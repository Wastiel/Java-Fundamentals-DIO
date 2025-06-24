package Relogio;

public class Main {

    public static void main(String[] args){
        Clock brClock = new BRLClock();

        brClock.setSeconds(0);
        brClock.setMinutes(0);
        brClock.setHour(25);

        System.out.println(brClock.getTime());
        System.out.println(new USClock().convert(brClock).getTime());
    }
}
