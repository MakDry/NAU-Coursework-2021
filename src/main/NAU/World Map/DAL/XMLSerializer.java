package BLL;

import BLL.World;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class XMLSerializer {

    public static void serializeToXML(World world) {
        //ValidatorXSD.validator();
        try (XMLEncoder out = new XMLEncoder(new ObjectOutputStream(new FileOutputStream("XMLdata.xml")))) {
            out.writeObject(world);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static World deserializeFromXML() {
        World world = new World();
        //ValidatorXSD.validator();
        try (XMLDecoder in = new XMLDecoder(new ObjectInputStream(new FileInputStream("XMLdata.xml")))) {
            world = (World) in.readObject();
        } catch (IOException e) {
            e.getMessage();
        }
        return world;
    }
}