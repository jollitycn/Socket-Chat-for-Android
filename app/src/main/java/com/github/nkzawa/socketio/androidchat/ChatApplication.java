package com.github.nkzawa.socketio.androidchat;

import android.app.Application;
import android.util.Log;
import io.socket.client.Ack;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ChatApplication extends Application {

    //private static final Logger logger = LoggerFactory.getLogger(ChatApplication.class);
    private Socket socket;
    {
        try {

            socket = IO.socket(Constants.CHAT_SERVER_URL);
            socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    // 客户端一旦连接成功，开始发起登录请求
                 //   LoginRequest message = new LoginRequest(12, "这是客户端消息体");
//                    socket.emit("login", message, (Ack) args1 -> {
//                        Log.d("","回执消息=" + Arrays.stream(args1).map(Object::toString).collect(Collectors.joining(",")));
//                    });
                }
            }).on(Socket.EVENT_CONNECT_ERROR, new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                 //   logger.info("Socket.EVENT_CONNECT_ERROR");
                    socket.disconnect();
                }
            }).on(Socket.EVENT_CONNECT_TIMEOUT, new Emitter.Listener() {
                @Override
                public void call(Object... args) {

                   // logger.info("Socket.EVENT_CONNECT_TIMEOUT");
                    socket.disconnect();
                }
            }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                  //  logger.info("客户端断开连接啦。。。");
                    socket.disconnect();
                }
            });
            socket.connect();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public Socket getSocket() {
        return socket;
    }
}
