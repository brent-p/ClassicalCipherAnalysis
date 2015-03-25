package com.ClassyCrypt.Utils;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import com.ClassyCrypt.Utils.File;

/**
 * Name:brentparish
 * Created: 24/03/2015
 */
public class FileHandler {

    public com.ClassyCrypt.Utils.File file;

    public FileHandler()
    {
        this.file = new File();
    }

    public FileHandler(String path)
    {
        this.file = new File(path);
    }

    public List<String> readLines()
    {
        Debug.hd(Debug.Type.SYSTEM, "Read File");
        ArrayList<String> lines = new ArrayList<String>();
        try
        {
            java.io.File file = new java.io.File(this.file.getPath());
            lines = (ArrayList<String>)Files.readAllLines(file.toPath(), Charset.defaultCharset());
            this.file.setLines(lines);
            return lines;
        }
        catch (Exception e)
        {
            Debug.ex(e);
            Debug.out(Debug.Type.SYSTEM, "Read File path",file.getPath());
        }
        return lines;
    }

    public String readText()
    {
        Debug.hd(Debug.Type.SYSTEM, "Read Buffer from File");
        Debug.out(Debug.Type.SYSTEM, "File Path", this.file.getPath());
        String text = "";
        try
        {
            java.io.File file = new java.io.File(this.file.getPath());
            this.file.setBuffer(new BufferedReader(new FileReader(file)));

            String currentLine = "";
            while ((currentLine = this.file.getBuffer().readLine()) != null) {
                text = text.concat(currentLine);
            }
            Debug.out(Debug.Type.SYSTEM,"Text", text);
            return text;
        }
        catch (Exception e)
        {
            Debug.ex(e);
            Debug.out(Debug.Type.SYSTEM, "Read Buffer path",file.getPath());
        }
        return text;
    }

    //Use if you need to do processing as you are reading the buffer
    public File setupBuffer()
    {
        Debug.hd(Debug.Type.SYSTEM, "Read Buffer from File");
        Debug.out(Debug.Type.SYSTEM, "File Path", this.file.getPath());
        try
        {
            java.io.File file = new java.io.File(this.file.getPath());
            this.file.setBuffer(new BufferedReader(new FileReader(file)));

        }
        catch (Exception e)
        {
            Debug.ex(e);
            Debug.out(Debug.Type.SYSTEM, "Read Buffer path",file.getPath());
        }
        return this.file;
    }

    public void writeFile()
    {
        Debug.hd(Debug.Type.SYSTEM, "Writing File");
        try
        {
            FileOutputStream out = new FileOutputStream(this.file.getPath());
            for (Object element : file.getLines()) {
                String str = (String)element;
                out.write(str.getBytes());
                out.write(System.getProperty("line.separator").getBytes());
            }
            out.close();
        }
        catch (Exception e)
        {
            Debug.ex(e);
            Debug.out(Debug.Type.SYSTEM, "Write File path",file.getPath());
        }
    }
}
