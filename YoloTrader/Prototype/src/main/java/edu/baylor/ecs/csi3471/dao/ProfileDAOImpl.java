package edu.baylor.ecs.csi3471.dao;

import edu.baylor.ecs.csi3471.model.DataBaseUtil;
import edu.baylor.ecs.csi3471.model.Profile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProfileDAOImpl implements ProfileDAO {

    private static List<Profile> profiles = new ArrayList<>();

    @Override
    public int insertProfile(Profile profile) {
        profiles.add(profile);
        return 1;
    }

    @Override
    public List<Profile> getAllProfiles() {
        return profiles;
    }

    @Override
    public DataBaseUtil load() throws FileNotFoundException {
        DataBaseUtil db = null;

        try {
            // create new instance of JAXBContext
            JAXBContext context = JAXBContext.newInstance(edu.baylor.ecs.csi3471.model.DataBaseUtil.class);

            // Unmarshaller governs process of deserializing XML data into newly created Java
            // content trees, optionally validating the XML data
            Unmarshaller um = context.createUnmarshaller();

            // unmarshal a global XML root and its data
            db = (DataBaseUtil) um.unmarshal(new FileReader("database.xml"));

        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return db;
    }

    @Override
    public void doSave(DataBaseUtil db) {
        try {

            JAXBContext context = JAXBContext.newInstance(edu.baylor.ecs.csi3471.model.DataBaseUtil.class);

            Marshaller m = context.createMarshaller();

            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            m.marshal(db, new File("database.xml"));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}