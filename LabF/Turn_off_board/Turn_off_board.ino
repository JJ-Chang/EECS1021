#include <Arduino.h>
#include <U8x8lib.h>


auto display = U8X8_SSD1306_128X64_NONAME_HW_I2C(U8X8_PIN_NONE);  

void setup() {
  // put your setup code here, to run once:
  pinMode(DD4, OUTPUT);
  Serial.begin(9600); //Enables serial communication
  display.begin(); //start OLED display
  display.clearDisplay(); 
}

void loop() {
  digitalWrite(DD4, LOW);
}
