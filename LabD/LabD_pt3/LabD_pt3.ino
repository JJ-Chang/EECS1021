//Import libraries
#include <Arduino.h>
#include <U8x8lib.h>

//set up display
U8X8_SSD1306_128X64_NONAME_HW_I2C u8x8(U8X8_PIN_NONE);

void setup() {
  u8x8.begin(); //start up OLED display
  u8x8.setFlipMode(1); // set to 1 or 0, depending on orientation of board
}

void loop() {
  //Display your name
  u8x8.setFont(u8x8_font_chroma48medium8_r);
  u8x8.setCursor(0,0);
  u8x8.print("Jada Chang");

  delay(1000); //pause 1 sec

  //Display class name
  u8x8.setFont(u8x8_font_chroma48medium8_r);
  u8x8.setCursor(0, 10);
  u8x8.print("in EECS1021");

  delay(1000); //pause 1 sec

  u8x8.clearDisplay(); //clear screen

  delay(1000);
}
