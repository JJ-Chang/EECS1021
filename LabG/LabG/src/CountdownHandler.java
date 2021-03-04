import com.fazecast.jSerialComm.*;

import java.io.*;
import java.util.*;

public class CountdownHandler extends TimerTask implements SerialPortDataListener {
    private byte n;
    private final byte timerDuration;
    private final OutputStream outputStream;

    public CountdownHandler(byte timerDuration, OutputStream outputStream) {
        this.n = timerDuration;
        this.timerDuration = timerDuration;
        this.outputStream = outputStream;
    }

    //Override run() from TimerTask
    @Override
    public void run() {
        //System.out.println("listen: " + this.getListeningEvents());
        try {
            if (this.n > 0) {
                this.outputStream.write(this.n);
                this.n -= 1;
            } else
                this.outputStream.write(-1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Override getListeningEvents() from jSerialComm.SerialPortDataListener
    @Override
    public int getListeningEvents() {
        System.out.println("rx!!");
        return SerialPort.LISTENING_EVENT_DATA_RECEIVED;
    }

    //Override serialEvent() from jSerialComm.SerialPortEvent
    @Override
    public void serialEvent(SerialPortEvent serialPortEvent) {
        if (serialPortEvent.getEventType() == SerialPort.LISTENING_EVENT_DATA_RECEIVED) {
            System.out.println("Moisture sensor is wet");
            this.n = timerDuration; //reset countdown value
        }
    }
}
