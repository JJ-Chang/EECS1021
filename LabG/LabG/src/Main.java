import com.fazecast.jSerialComm.SerialPort;

import java.io.*;
import java.util.*;

public class Main {
    public static final byte TIMER_DURATION = 10;

    public static void main(String[] args) {
        var sp = SerialPort.getCommPort("COM4");
        
        sp.setComPortParameters(9600, Byte.SIZE, SerialPort.ONE_STOP_BIT, SerialPort.NO_PARITY);
        sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);
        
        var hasOpened = sp.openPort();
        if(!hasOpened)
            throw new IllegalStateException("Failed to open port.");
        
        var outputStream = sp.getOutputStream();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try{
                outputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }sp.closePort();
        }));
        
        var timer = new Timer();
        var countdown = new CountdownHandler(TIMER_DURATION, outputStream);
        sp.addDataListener(countdown);

        System.out.println("listen: " + countdown.getListeningEvents());
        timer.schedule(countdown, 0, 1000);
    }
}
