package com.example.ming.rpc.r02;



import java.io.*;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @description:
 * @author: wangzhx
 * @create: 2020-10-17 09:49
 */
public class Server {

    public static void main(String[] args) throws Exception {


        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("监听socket 8888。。。");
        Socket socket = null;
        while ((socket = serverSocket.accept()) != null) {
            System.out.println("接收到一个socket连接。。。");
            InputStream is = socket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);

            String clazzName = ois.readUTF();
            String methodName = ois.readUTF();
            Class[] paramTypes = (Class[]) ois.readObject();
            Object[] params = (Object[]) ois.readObject();

            // 通过serviceLoader获取接口类的实现类
            Class clazz = Class.forName(clazzName);
            ServiceLoader services = ServiceLoader.load(clazz);
            Iterator serviceIterator = services.iterator();
            Object obj = null;
            if(serviceIterator.hasNext()){
                Object serviceImpl = serviceIterator.next();
                // 通过反射获取对应的对象和方法，invoke得到结果
                Method method = clazz.getMethod(methodName, paramTypes);
                obj = method.invoke(serviceImpl, params);
            }

            OutputStream os = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(obj);
            System.out.println("返回一个object信息。。。");

        }
    }


}