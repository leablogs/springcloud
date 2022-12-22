package socket.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

@Slf4j
public class MyChannel {
    public static void main(String[] args) throws IOException {
        ReadableByteChannel readableByteChannel = Channels.newChannel(System.in);
        WritableByteChannel writableByteChannel = Channels.newChannel(System.out);
        channelCopy1(readableByteChannel, writableByteChannel);
        readableByteChannel.close();
        writableByteChannel.close();
    }

    private static void channelCopy1(ReadableByteChannel readableByteChannel, WritableByteChannel writableByteChannel) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024 * 16);
        log.info("buffer 是否为直接缓存：{}", buffer.isDirect());
        while (readableByteChannel.read(buffer) != -1) {
            buffer.flip();
            writableByteChannel.write(buffer);
            buffer.compact();
        }
        buffer.flip();
        while (buffer.hasRemaining()) {
            writableByteChannel.write(buffer);
        }
    }
}
