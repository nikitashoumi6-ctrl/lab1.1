@echo off
rmdir /s /q out
mkdir out
javac -d out src\ru\university\lab1\Main.java
jar cfm app.jar manifest.mf -C out .
echo Сборка завершена. Запуск: java -jar app.jar
pause