
package clock;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class main {
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        Clock myClock;        
        int menu,type,hour,min;
        
        System.out.println("1.Midnight\n2.Set Time");
        menu = keyboard.nextInt();
        System.out.println("1.EU Clock\n2.USA Clock");
        type = keyboard.nextInt();
        if(menu == 1){           
                myClock = new Clock(type);           
        }
        else{
            hour = keyboard.nextInt();
            min = keyboard.nextInt();
            myClock = new Clock(type,hour,min);
        }
        
        Timer timer = new Timer();
        
        timer.scheduleAtFixedRate(new TimerTask(){
            public void run(){
                myClock.tick();
                System.out.println(myClock.getTime());
            }
        }, 0, 5);                
    }
}
