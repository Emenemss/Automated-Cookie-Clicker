# Cookie Clicker Automated

Automated Cookie Clicker is a fun, short project automating the very basics of the idle game made by Orteil. It is not meant as a means of cheating the game or using any unauthorized methods of playing, it just does the base clicking for the player.

# Requirements
Selenium - version 4.9.1 or later

Java - version 20 or later

# Setup
Since Cookie Clicker is a browser game, we need to invoke a chromedriver in order for it to work. To do that, we can go to the chromedriver [download](https://chromedriver.chromium.org/downloads "Chrome Driver") and choose the latest version. After extracting the folder and adding the driver to your local files, you can copy the filepath and set it in the code.

``` java
System.setProperty("webdriver.chrome.driver", "C:\\Users\\ema7a\\Desktop\\chromedriver-win64\\chromedriver.exe");
```
In this line just replace my local file path with your file path. 