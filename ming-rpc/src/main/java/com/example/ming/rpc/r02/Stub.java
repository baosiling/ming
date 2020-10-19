package com.example.ming.rpc.r02;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * @description:
 * @author: wangzhx
 * @create: 2020-10-17 09:49
 */
public class Stub {

    public static Object getStub(Class clazz){

        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                int userIdInput = 123;
                // 建立socket连接
                Socket socket = new Socket("127.0.0.1", 8888);

                // 定义一个output字节数组，通过dataOutputStream向字节数组写入数据(类名，方法名，参数类型列表，参数列表)
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos);

                oos.writeUTF(clazz.getName());
                oos.writeUTF(method.getName());
                oos.writeObject(method.getParameterTypes());
                oos.writeObject(args);
                // 向socket的输出流中写入数据，调用flush 立即发送消息，
                socket.getOutputStream().write(baos.toByteArray());
                socket.getOutputStream().flush();

                // 读取socket接收到的数据, 通过DataInputStream 读出socket连接返回的数据。
                InputStream is = socket.getInputStream();
                ObjectInputStream ois = new ObjectInputStream(is);
                Object obj = ois.readObject();

                oos.close();
                ois.close();
                socket.close();
                return obj;
            }
        };
        Object proxy = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, h);
        return proxy;
    }

}