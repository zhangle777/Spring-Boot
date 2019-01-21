#!/bin/bash
echo 脚本杀死原进程
pid=`ps -ef|grep demo-0.0.1-SNAPSHOT.jar | grep -v grep |awk '{print $2}'`
if [ ${pid} ]
then
   echo :App  is  running pid=${pid}
else
   kill -9 ${pid}
fi
echo 等待5秒再启动项目，确保程序以停止
timeout /t 5
echo 开始启动程序
nohup java -jar /var/lib/jenkins/workspace/spring-boot_测试/demo-0.0.1-SNAPSHOT.jar>log.txt
