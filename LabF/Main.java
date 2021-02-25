//LabF Part 2 & 3

import com.fazecast.jSerialComm.SerialPort;
import java.io.IOException;
import java.util.Timer;

public class Main{
    public static final byte TIMER_DURATION = 10;

    public static void main(String[] args) throws InterruptedException {
        long timeStart = System.currentTimeMillis();
        var sp = SerialPort.getCommPort("COM4");

        sp.setComPortParameters(9600, Byte.SIZE, SerialPort.ONE_STOP_BIT, SerialPort.NO_PARITY);
        sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);

        //open serial port, if fails, program in illegal state -> throw exception
        var hasOpened = sp.openPort();
        if(!hasOpened)
            throw new IllegalStateException("Failed to open port.");
        var outputStream = sp.getOutputStream();
        Thread.sleep(2000);

        //to terminate & close stream
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try{
                outputStream.close();
            }catch(IOException e){
                e.printStackTrace();
            }
            sp.closePort(); //close USB connection
        }));

        var timer = new Timer();
        var countdown = new CountdownHandler(TIMER_DURATION, outputStream);

        sp.addDataListener(countdown);
        System.out.println("Listen: " + countdown.getListeningEvents());

        timer.schedule(countdown, 0, 1000);
    }
}
