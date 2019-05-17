@echo off
REM Copyright 2016 the original author or authors. All rights reserved.
REM site: http://www.ganshane.com

setlocal
call "%~dp0start-env.cmd"

set WICKETMAIN=com.pspot.wicket.App

REM set java options
SET JAVA_OPTIONS=%JAVA_OPTIONS% -Dserver.home=%SERVER_HOME% -Dfile.encoding=utf-8

echo %CLASSPATH%

echo on
call %JAVA% -cp "%CLASSPATH%" %JAVA_OPTIONS% %WICKETMAIN%  %*

endlocal
