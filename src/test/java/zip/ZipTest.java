package zip;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipTest {

    @Test
    public void test() throws Exception {

        String[] paths = {"d:/1.pdf","d:/2.pdf"};
        ArrayList<byte[]> files = new ArrayList<>();
        FileInputStream fis = null;
        for(String path : paths){
            fis = new FileInputStream(path);
            byte[] tmp = new byte[fis.available()];
            fis.read(tmp);
            fis.close();
            files.add(tmp);
        }

        String outPath = "d:/zip12.zip";
        FileOutputStream fos = new FileOutputStream(outPath);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
        int i = 1;
        for(byte[] file: files){
            ZipEntry zipEntry = new ZipEntry(i + ".pdf");
            zipOutputStream.putNextEntry(zipEntry);
            zipOutputStream.write(file);
            i++;
        }
        zipOutputStream.closeEntry();
        zipOutputStream.close();
        byte[] bytes = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        fos.write(bytes);
        fos.close();
        System.out.println("压缩完成");
    }
}
