#!/bin/bash
echo 脚本杀死原进程
pid=`ps -ef|grep demo-0.0.1-SNAPSHOT.jar | grep -v grep |awk '{print $2}'`
if [ ${pid} ]
then
   echo :App  is  running pid=${pid}
   kill -9 ${pid}
   echo 等待5秒再启动项目，确保程序以停止
   sleep 5s
fi
echo 开始启动程序
nohup java -jar /var/lib/jenkins/workspace/spring-boot_测试/target/demo-0.0.1-SNAPSHOT.jar>log.txt 2>&1 &
