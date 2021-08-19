package com.huixiong;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SocketChannel;

/**
 * <描述>
 *
 * @author timothy.yang cloudwise
 * @since 2021-07-17 14:00
 */
public class Main {
    public static void main(String[] args) throws Exception{
        SocketChannel socket = SocketChannel.open(new InetSocketAddress("127.0.0.1", 6666));
    }
}
