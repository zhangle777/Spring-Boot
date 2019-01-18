echo 脚本杀死原进程
taskkill /f /im A1javaw.exe
echo 等待5秒再启动项目，确保程序以停止
timeout /t 5
del/f/s/q D:\jenkins\jenkins\workspace\Arunning\boot-0.0.1-SNAPSHOT.jar
echo 原jar删除成功
copy D:\jenkins\jenkins\workspace\bootCloud-base\target\boot-0.0.1-SNAPSHOT.jar D:\jenkins\jenkins\workspace\Arunning\boot-0.0.1-SNAPSHOT.jar
echo 新jar复制成功
start A1javaw -jar D:\jenkins\jenkins\workspace\Arunning\boot-0.0.1-SNAPSHOT.jar
