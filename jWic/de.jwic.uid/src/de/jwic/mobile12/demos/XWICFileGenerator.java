package de.jwic.mobile12.demos;

import java.io.File;
import java.nio.channels.FileChannel;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

import java.nio.file.Files;

public class XWICFileGenerator {
 
    public static void copyFile( File source, File destination ) {
        System.out.println(source.toString());
        System.out.println(destination.toString());
        FileChannel srcChannel = null;
        FileChannel destChannel = null;

        try {
            boolean created = (new File( destination.toString() ) ).createNewFile();
            System.out.println( destination.toString() + " " + created );
        } catch ( Exception ex ) {
            ex.printStackTrace();
        }

        try {

            RandomAccessFile src = new RandomAccessFile( source.toString(), "r" );
            RandomAccessFile des = new RandomAccessFile( destination.toString(), "rw" );
            FileChannel sfc = src.getChannel();
            FileChannel dfc = des.getChannel();

            //FileChannel sfc = new FileInputStream( source.toString() ).getChannel();
            //FileChannel dfc = new FileInputStream( destination.toString() ).getChannel();

            dfc.transferFrom( sfc, 0, sfc.size() );

        } catch ( IOException iox ) {
            iox.printStackTrace();
        } catch ( Exception ex ) {
            ex.printStackTrace();
        }


        /****
        try {
            srcChannel = new FileInputStream(source).getChannel();
            destChannel = new FileInputStream(destination).getChannel();
            destChannel.transferFrom(srcChannel, 0, srcChannel.size());
        } catch ( IOException iox ) {
            iox.printStackTrace();
        } catch ( Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                srcChannel.close();
                destChannel.close();
            } catch ( IOException iox2 ) {
                iox2.printStackTrace();
            }
        }
     */
    }
}
