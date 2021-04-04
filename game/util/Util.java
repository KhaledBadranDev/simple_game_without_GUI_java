
/**
 * @author Khaled Badran
 */

 
package game.util;
import java.io.IOException;

public class Util {

    public static void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            // handle exception
            System.err.println(e);
        }
    }
    
    public static void sleep(long milliseconds) {
        try{
            Thread.sleep(milliseconds); //converting from mili seconds to seconds.
        } catch(Exception e) {
            System.err.println("Thread inturrupted");
        }    
    }
    
}
