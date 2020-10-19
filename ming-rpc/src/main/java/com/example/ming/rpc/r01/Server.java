package com.example.ming.rpc.r01;



import com.example.ming.rpc.common.IUserService;
import com.example.ming.rpc.common.User;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

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
            DataInputStream dis = new DataInputStream(is);
            Integer userId = dis.readInt();

            IUserService userService = new UserServiceImpl();
            User user = userService.findById(userId);

            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeInt(user.getId());
            dos.writeUTF(user.getName());
            System.out.println("返回一个user信息。。。");

        }
    }
}