
import java.io.IOException;
import java.time.Clock;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author itspe
 */
public class LogJava {
    public static Logger logger;

    
    public static void main(String args[]){
        try {
        Handler fh = new FileHandler("/home/ubuntu/mq.log");
        fh.setLevel (Level.FINE);
        logger = Logger.getLogger(LogJava.class.getName());
        logger.addHandler(fh);
    }
    catch (IOException e) {
      e.printStackTrace();
    }

        logger.log(Level.SEVERE, "Hi this is my first log");
        System.out.print("you reached here");
    }
}
