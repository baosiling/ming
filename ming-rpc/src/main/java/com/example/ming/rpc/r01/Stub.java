package com.example.ming.rpc.r01;

import com.example.ming.rpc.common.IUserService;
import com.example.ming.rpc.common.User;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
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

    public static IUserService getStub(Class clazz){

        InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                int userIdInput = 123;
                // 建立socket连接
                Socket socket = new Socket("127.0.0.1", 8888);

                // 定义一个output字节数组，通过dataOutputStream向字节数组写入数据
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                DataOutputStream dos = new DataOutputStream(baos);
                dos.writeInt(userIdInput);
                // 向socket的输出流中写入数据，调用flush 立即发送消息，
                socket.getOutputStream().write(baos.toByteArray());
                socket.getOutputStream().flush();

                // 读取socket接收到的数据, 通过DataInputStream 读出socket连接返回的数据。
                InputStream is = socket.getInputStream();
                DataInputStream dis = new DataInputStream(is);
                int userIdResult = dis.readInt();
                String userName = dis.readUTF();
                User user = new User(userIdResult, userName);

                dos.close();
                dis.close();
                socket.close();
                return user;
            }
        };
        Object proxy = Proxy.newProxyInstance(IUserService.class.getClassLoader(), new Class[]{IUserService.class}, h);
        return (IUserService) proxy;
    }

}