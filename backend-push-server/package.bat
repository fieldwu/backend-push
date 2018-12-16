@echo off
echo [INFO] mvn clean package

cd %~dp0
call mvn clean package
pause