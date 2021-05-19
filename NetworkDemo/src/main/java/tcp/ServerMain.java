package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author timothy
 * @data 2021年05月19日 7:46 下午
 */
public class ServerMain {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(6666);
        System.out.println("server is running...");
        while (true) {
            Socket accept = socket.accept();
            System.out.println("connected from " + accept.getRemoteSocketAddress());
            Thread thread = new Handle(accept);
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
            try (OutputStream outputStream = this.socket.getOutputStream()){
                handle(inputStream,outputStream);
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

    private void handle(InputStream input,OutputStream output) throws IOException {
        BufferedWriter write = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        write.write("hello\n");
        write.flush();
        while (true){
            String readLine  = reader.readLine();
            if(readLine.equals("bye")){
                write.write("bye\n");
                write.flush();
                break;
            }
            write.write("ok "+ readLine+"\n");
            write.flush();
        }
    }
}