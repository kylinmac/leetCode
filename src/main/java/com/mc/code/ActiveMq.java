package com.mc.code;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.InputStream;
import java.util.HashSet;

/**
 * @author macheng
 * @date 2021/1/14 13:41
 */
public class ActiveMq {
    public static void main(String[] args) throws Exception {
        int num=100;
        int[] result=new int[num+1];
        result[0]=0;
        result[1]=1;
        int cur = 2;
        int index=2;
        while (index<num+1){
            for (int i = 0; i < cur&& index<num+1; i++) {
                result[index]=1+result[i];
            }
            cur=cur<<1;
            index++;
        }
        HashSet<Integer> black=new HashSet<>();
        black.contains(1);
        black.
            //provider();
        //for (int i = 0; i < 10; i++) {
            //customer();
        //}


    }

    public static void provider() throws Exception {
        // 获取连接
        InputStream is=null;
        Connection conn = null;
        try {
            conn = getConnection();
            // 获取session
            Session session = conn.createSession(true, Session.CLIENT_ACKNOWLEDGE);
            // 创建队列
            Destination destination = session.createQueue("myqueue");
            // 获取生产者
            MessageProducer pro = session.createProducer(destination);
            // 创建消息
            BytesMessage msg = session.createBytesMessage();
            is = ActiveMq.class.getClassLoader().getResourceAsStream("消息二.xml");
            // 读取数据到byte数组中
            byte[] buffer=new byte[is.available()];
            is.read(buffer);
            msg.writeBytes(buffer);
            // 发送消息
            //第一个参数  消息的目的地  Destination
            //第二个参数  发送的消息
            //第三个参数  消息的模式 DeliveryMode
            //第四个参数  消息的优先级
            //第五个参数 消息存活时间 存活时间单位是ms
            pro.send(destination, msg, DeliveryMode.NON_PERSISTENT, 4, 1000*10);

            //提交事物
            session.commit();

            System.out.println("-----------------发送消息----------------");
        } finally {
            // 关闭连接
            conn.close();
        }

    }

    public static void customer() throws Exception {
        // 获取连接
        Connection conn = null;

        try {
            conn = getProConnection();
            // 获取session
            Session session = conn.createSession(true, Session.CLIENT_ACKNOWLEDGE);
            // 创建队列
            Destination destination = session.createQueue("myqueue");
            // 获取消费者
            MessageConsumer cus = session.createConsumer(destination);
            // 接收消息
            while (true){
                BytesMessage msg = (BytesMessage) cus.receive();
                // 确认接收， 又开启一个线程，去发送给服务器，按收到消息了
                System.out.println("开始消费");
                //Thread.sleep(11000);
                int i=1/0;
                msg.acknowledge();
                System.out.println("-------------接收并确认消息----------------");
                System.out.println(msg.getBodyLength());
            }


        } catch (Exception e) {
            System.out.println("错了");
        }finally {
            // 关闭连接
            conn.close();
        }
    }
    public static Connection getProConnection() throws Exception {
        // 1.获取工厂连接类
        ConnectionFactory fc = new ActiveMQConnectionFactory("admin", "admin", "tcp://127.0.0.1:61616");

        // 2.获取连接
        Connection conn = fc.createConnection();
        conn.start();

        System.out.println("-----------------获取连接----------------");

        return conn;

    }
    public static Connection getConnection() throws Exception {
        // 1.获取工厂连接类
        ConnectionFactory fc = new ActiveMQConnectionFactory("admin", "admin", "tcp://127.0.0.1:61616");

        // 2.获取连接
        Connection conn = fc.createConnection();
        conn.start();

        System.out.println("-----------------获取连接----------------");

        return conn;

    }

}
