package me.earth.headlessmc.lwjgl.util;

import lombok.val;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.ByteBuffer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ByteBufferInputStreamTest {
    @Test
    public void testByteBufferInputStream() throws IOException {
        val bytes = new byte[]{1};
        val byteBuffer = ByteBuffer.wrap(bytes);
        try (val is = new ByteBufferInputStream(byteBuffer)) {
            assertEquals(1, byteBuffer.remaining());
            assertEquals(1, is.available());

            assertEquals(1, is.read());
            assertEquals(0, is.available());
            assertEquals(0, byteBuffer.remaining());

            assertEquals(-1, is.read());
            assertEquals(0, is.available());
            assertEquals(0, byteBuffer.remaining());
        }
    }

}
