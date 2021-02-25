import com.fazecast.jSerialComm.*;
import java.io.*;
import java.util.*;

public class CountdownHandler extends TimerTask implements SerialPortDataListener {
    private byte n;
    private final OutputStream outputStream;
    private final byte timerDuration;

    //constructor
    public CountdownHandler(byte timerDuration, OutputStream outputStream){
        this.timerDuration = timerDuration;
        this.n = timerDuration;
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        try{
            if(this.n >= 0){
                this.outputStream.write(this.n);
                this.n -= 1;
            }else{ //done, tell Arduino we're done
                this.outputStream.write(-1);
            }
        }catch(IOException e){
            System.out.println("Problem inside the countdownHandler run method");
            e.printStackTrace();
        }
    }

    @Override
    public int getListeningEvents(){
        return SerialPort.LISTENING_EVENT_DATA_RECEIVED;
    }

    @Override
    public void serialEvent(SerialPortEvent serialPortEvent){
        if(serialPortEvent.getEventType() == SerialPort.LISTENING_EVENT_DATA_RECEIVED) {
            System.out.println("Button pushed");
            n = timerDuration;
        }
    }
}
