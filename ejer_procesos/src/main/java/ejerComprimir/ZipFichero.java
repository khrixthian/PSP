package ejerComprimir;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFichero extends Thread{

	static public void zipIt(String FicheroZip, String FicheroAComprimir) 
	{

        
        byte[] buffer = new byte[1024];
 
        FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(FicheroZip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        ZipOutputStream zos = new ZipOutputStream(fos); 
    	ZipEntry ze = new ZipEntry(FicheroAComprimir);
        try {
			zos.putNextEntry(ze);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        FileInputStream in = null;
		try {
			in = new FileInputStream(FicheroAComprimir);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        int len;
        try {
			while ((len = in.read(buffer)) > 0)
			    zos.write(buffer, 0, len);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			zos.closeEntry();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
