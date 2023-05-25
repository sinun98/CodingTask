@echo off

cd ..
start /B cmd /c "mvn compile exec:java -Dexec.mainClass=MainClass & ping 127.0.0.1 -n 31 > nul"

exit
