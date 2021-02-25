//Import libraries
#include <Arduino.h>
#include <U8x8lib.h>

//Create instance of class
auto display = U8X8_SSD1306_128X64_NONAME_HW_I2C(U8X8_PIN_NONE);

//Initialize board
void setup() {
  pinMode(DD4, OUTPUT); //set D4(LED) to output

  Serial.begin(9600); //enable serial communication
  display.begin(); //start up OLED display
  display.setFlipMode(1); //set orientation
}

void loop() {
  if(!Serial.available()){
    return;  
  }

  display.clearDisplay();

  auto data = Serial.read(); //receive a byte of data via Java

  //Display my name
  display.setFont(u8x8_font_profont29_2x3_r);
  display.setCursor(0, 0);

  if(data == (byte) -1){ //indicates countdown complete
    digitalWrite(DD4, HIGH);
    display.print("Yay");
  }else{ //countdown in progress
    display.print(data);
  }
}
