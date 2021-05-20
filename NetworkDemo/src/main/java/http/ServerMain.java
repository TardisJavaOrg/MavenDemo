package http;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author timothy
 * @data 2021年05月20日 10:22 上午
 * 利用TCP编程里的内容，因为HTTP请求本质上就是 TCP请求，所以 浏览器可以和这个server 建立tcp连接
 * 这里需要做的只是解析一个 request，并且封装一个 response 返回
 */
public class ServerMain {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8888);
        System.out.println("server is running...");
        while (true) {
            Socket accept = socket.accept();
            System.out.println("connected from " + accept.getRemoteSocketAddress());
            Thread thread = new Handle(accept);// 新建一个线程来处理这个连接
            thread.start();
        }
    }


}

class Handle extends Thread {

    private Socket socket;

    public Handle(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (InputStream inputStream = this.socket.getInputStream()) {
            try (OutputStream outputStream = this.socket.getOutputStream()) {
                handle(inputStream, outputStream);
            }
        } catch (IOException e) {
            try {
                socket.close();
            } catch (IOException ioException) {
            }
            e.printStackTrace();
            System.out.println("client disconnected.");
        }

    }

    private void handle(InputStream input, OutputStream output) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        // 处理HTTP 请求
        String startWith = reader.readLine();
        boolean reqOk = false;
        if (startWith.startsWith("GET / HTTP/1.")) {
            reqOk = true;
            System.out.println(startWith);
        }
        System.out.println(reqOk ? "Request OK" : "Request Error");
        for (; ; ) {
            String header = reader.readLine();
            if (header.isEmpty()) {
                break;
            }
            System.out.println(header);
        }

        if (!reqOk) {
            // 发送错误响应:
            writer.write("HTTP/1.0 404 Not Found\r\n");
            writer.write("Content-Length: 0\r\n");
            writer.write("\r\n");
            writer.flush();
        } else {
            // 发送成功响应:
            String data = "<html><body><h1>Hello, world!</h1></body></html>";
            int length = data.getBytes(StandardCharsets.UTF_8).length;
            writer.write("HTTP/1.0 200 OK\r\n");
            writer.write("Connection: close\r\n");
            writer.write("Content-Type: text/html\r\n");
            writer.write("Content-Length: " + length + "\r\n");
            writer.write("\r\n"); // 空行标识Header和Body的分隔
            writer.write(data);
            writer.flush();
        }
    }
}