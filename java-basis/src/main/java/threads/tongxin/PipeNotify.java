package threads.tongxin;import java.io.IOException;import java.io.PipedInputStream;import java.io.PipedOutputStream;public class PipeNotify {    public static void main(String[] args) {        try {            WriteData writeData = new WriteData();            ReadData readData = new ReadData();            PipedInputStream inputStream = new PipedInputStream();            PipedOutputStream outputStream = new PipedOutputStream();//        outputStream.connect();            outputStream.connect(inputStream);            ThreadRead threadRead = new ThreadRead(readData, inputStream);            threadRead.start();            Thread.sleep(2000);            ThreadWrite threadWrite = new ThreadWrite(writeData, outputStream);            threadWrite.start();        } catch (IOException e) {            e.printStackTrace();        } catch (InterruptedException e) {            e.printStackTrace();        }    }}class WriteData {    public void writeMehtod(PipedOutputStream outputStream) {        try {            System.out.println("write :");            for (int i = 0; i < 300; i++) {                String outData = "" + (i + 1);                outputStream.write(outData.getBytes());                System.out.println("输人内容：" + outData);            }            System.out.println();            outputStream.close();        } catch (IOException e) {            e.printStackTrace();        }    }}class ReadData {    public void readMethod(PipedInputStream pipedInputStream) {        try {            System.out.println("read :");            byte[] bytes = new byte[20];            int readLength = pipedInputStream.read(bytes);            while (readLength != -1) {                String newData = new String(bytes, 0, readLength);                System.out.println("输出内容：" + newData);                readLength = pipedInputStream.read(bytes);            }            System.out.println();            pipedInputStream.close();        } catch (IOException e) {            e.printStackTrace();        }    }}class ThreadWrite extends Thread {    private WriteData writeData;    private PipedOutputStream outputStream;    public ThreadWrite(WriteData writeData, PipedOutputStream out) {        this.writeData = writeData;        this.outputStream = out;    }    @Override    public void run() {        writeData.writeMehtod(outputStream);    }}class ThreadRead extends Thread {    private ReadData readData;    private PipedInputStream pipedInputStream;    public ThreadRead(ReadData writeData, PipedInputStream pipedInputStream) {        this.readData = writeData;        this.pipedInputStream = pipedInputStream;    }    @Override    public void run() {        readData.readMethod(pipedInputStream);    }}