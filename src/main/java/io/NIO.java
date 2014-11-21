package io;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by jacob on 14/11/13.
 */
public class NIO {
    public static void main(String[] args) throws IOException {

        RandomAccessFile file = new RandomAccessFile("/Users/jacob/abc.txt", "rw");
        FileChannel channel = file.getChannel();

        ByteBuffer allocate = ByteBuffer.allocate(18);

        allocate.putInt(1000);
        channel.write(allocate);
        channel.close();
        file.close();

    }
}
