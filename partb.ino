#include <Arduino.h>
#include <U8x8lib.h>

#define MOSFET 2
#define REDLED 4
#define BUTTON 6
//define sets the var name to the number (which is the pin)

auto display = U8X8_SSD1306_128X64_NONAME_HW_I2C(U8X8_PIN_NONE);

void setup() {
    Serial.begin(9600);

    display.begin();
    display.setFlipMode(1);
    display.clearDisplay();

    pinMode(MOSFET, OUTPUT); //set MOSFET & pump to output
    pinMode(REDLED, OUTPUT); //set D4 (LED) to output
    pinMode(BUTTON, INPUT); //set D6 (button) to input
}

void loop() {
    display.setFont(u8x8_font_profont29_2x3_r);
    display.setCursor(0, 0);

    if (!Serial.available()) {
        return;
    }

    const auto receivedData = Serial.read();

    char buf[16];
    sprintf(buf, "%03d", receivedData);

    if(receivedData < 100){
      display.print(buf);
      digitalWrite(MOSFET, LOW);  
    }else if(receivedData == 255){
      digitalWrite(MOSFET, HIGH);
    }else{
      display.print("error");
      digitalWrite(MOSFET, LOW);
    }
 }
