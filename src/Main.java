import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Please enter the number of white, yellow and red codes");
        Scanner scanner = new Scanner(System.in);
        int whiteCodes = scanner.nextInt();
        int yellowCodes = scanner.nextInt();
        int redCodes = scanner.nextInt();


        Random randomGen = new Random(GregorianCalendar.getInstance().getTimeInMillis()); //random generator for the doctor of yellow code
        EmergencyRoom er = new EmergencyRoom();


        for(int i = 0; i < redCodes; i++){
            Patient p = new Patient("patient" + i, Urgency.RED, er);
            p.start();
        }

        for(int i = 0; i < yellowCodes; i++){
            Patient p = new Patient("patient" + i, Urgency.YELLOW, er);
            p.start();
        }

        for(int i = 0; i < whiteCodes; i++){
            Patient p = new Patient("patient" + i, Urgency.WHITE, er);
            p.start();
        }
    }

}
