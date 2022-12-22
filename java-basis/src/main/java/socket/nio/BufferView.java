package socket.nio;

import lombok.extern.slf4j.Slf4j;

import java.nio.*;

@Slf4j
public class BufferView {
    public static void main(String[] args) {
        // 初始化了一个byte buffer缓冲区，大小为7，按照大字节进行排序
        ByteBuffer buffer = ByteBuffer.allocate(7).order(ByteOrder.BIG_ENDIAN);
        CharBuffer charBuffer = buffer.asCharBuffer();
        buffer.put(0, (byte) 0);
        buffer.put(1, (byte) 'H');
        buffer.put(2, (byte) 0);
        buffer.put(3, (byte) 'i');
        buffer.put(4, (byte) 0);
        buffer.put(5, (byte) '!');
        buffer.put(6, (byte) 0);
        println(buffer);
        println(charBuffer);
        CharBuffer charBuffer1 = charBuffer.duplicate();
        println(charBuffer1);
        System.out.println(charBuffer1.isDirect());

    }

    private static void println(Buffer buffer) {
        log.info("pos={},limit={},capacity={}:{}", buffer.position(), buffer.limit(), buffer.capacity(), buffer.toString());
    }
}
