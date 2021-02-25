//Import libraries
#include <Arduino.h>
#include <U8x8lib.h>

//Creates  an  instance  of the ‘U8X8_SSD1306_128X64_NONAME_HW_I2C' class
auto display = U8X8_SSD1306_128X64_NONAME_HW_I2C(U8X8_PIN_NONE);

int n = 10;
char myCharArray[10] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

//Initialize Grove board
void setup(){
  pinMode(DD4, OUTPUT); //Sets D4(LED) pin to output

  Serial.begin(9600); //Enables serial communication
  display.begin(); //start OLED display
  display.setFlipMode(1); //set to 1 or 0, depending on orientation of board
  display.clearDisplay();
}

void loop(){
  //Set up countdown on OLED
  display.setFont(u8x8_font_profont29_2x3_r);
  display.setCursor(0, 0);

  if(n >= 0){
    display.print(myCharArray[n]);
    n = n - 1;
  }else{ //start again
    //do nothing 
  }

  delay(1000); //pause between screen updates
}
