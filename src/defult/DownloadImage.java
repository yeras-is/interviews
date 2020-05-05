package defult;

import java.io.*;
import java.net.URL;

public class DownloadImage {

    public static void main(String[] args) throws IOException {
        URL url = new URL("https://i.picsum.photos/id/237/536/354.jpg");
        InputStream in = new BufferedInputStream(url.openStream());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int n = 0;
        while (-1 != (n = in.read(buf))) {
            out.write(buf, 0, n);
        }
        out.close();
        in.close();
        byte[] response = out.toByteArray();
        FileOutputStream fos = new FileOutputStream("C://test.jpg");
        fos.write(response);
        fos.close();
    }
}
