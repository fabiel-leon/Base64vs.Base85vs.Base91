/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fabiel.BaseVS;

import com.google.common.io.BaseEncoding;
import com.google.common.io.ByteStreams;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.pdfbox.io.ASCII85OutputStream;
import sun.misc.BASE64Encoder;

/**
 *
 * @author fabiel
 */
public class BasesVS {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        String in = "C:\\Users\\fabiel\\Desktop\\tr.apk";
        FileInputStream fileInputStream = new FileInputStream(in);
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\fabiel\\Desktop\\tr.apk.85.txt");
        FileInputStream fileInputStream64 = new FileInputStream(in);
        FileOutputStream fileOutputStream64 = new FileOutputStream("C:\\Users\\fabiel\\Desktop\\tr.apk.64.txt");
        try (ASCII85OutputStream asciI85OutputStream = new ASCII85OutputStream(new BufferedOutputStream(fileOutputStream))) {
            asciI85OutputStream.setLineLength(76);
            ByteStreams.copy(new BufferedInputStream(fileInputStream), asciI85OutputStream);
        }
        FileInputStream fis=new FileInputStream(in);
        try (FileOutputStream fos = new FileOutputStream("C:\\Users\\fabiel\\Desktop\\tr.apk.91.txt")) {
            B91Cli.encodeWrap(fis,fos );
        }
//        OutputStream encodingStream = BaseEncoding.base64().encodingStream(new FileWriter("C:\\Users\\fabiel\\Desktop\\tr.apk.64v2.txt"));
//        ByteStreams.copy(new BufferedInputStream(new FileInputStream(in)), encodingStream);
//        encodingStream.close();
        BASE64Encoder basee = new BASE64Encoder();
        basee.encode(fileInputStream64, fileOutputStream64);

//        ByteStreams.copy(new BufferedInputStream(new FileInputStream("C:\\Users\\fabiel\\Desktop\\tr.apk")), new Base(new BufferedOutputStream(new FileOutputStream("C:\\Users\\fabiel\\Desktop\\tr.apk.85.txt"))));
//        ASCII85OutputStream asciios = ;
    }

}
