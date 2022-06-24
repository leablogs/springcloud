package com.leablogs.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileInput {
    public void fileRead() throws IOException {
        InputStream inputStream = null;
        FileInputStream fileInputStream = new FileInputStream("");
        inputStream = new BufferedInputStream(fileInputStream);
        byte[] bytes = new byte[1024];
        int bytesRead = inputStream.read(bytes);
        while (bytesRead != -1){
            for(int i = 0;i<bytesRead;i++){
                System.out.println((char) bytes[i]);
            }
            bytesRead = inputStream.read(bytes);
        }
    }

    public void nioFileInput() throws IOException {
        RandomAccessFile randomAccessFile = null;
        randomAccessFile = new RandomAccessFile("","rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int bytesRead = fileChannel.read(buffer);
        System.out.println(bytesRead);
        while (bytesRead != -1){
            System.out.println((char) buffer.get());
        }
        buffer.compact();
        bytesRead = fileChannel.read(buffer);

    }
}



















