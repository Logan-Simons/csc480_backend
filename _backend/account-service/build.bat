@echo off
echo Packaging the service as a WAR...
:: Make sure mvn is in your PATH or use the full path to mvn.cmd
mvn clean package
if %ERRORLEVEL% NEQ 0 (
    echo Build failed!
    pause
    exit /b %ERRORLEVEL%
)
echo Build succeeded! WAR file is located in the target folder.
pause
