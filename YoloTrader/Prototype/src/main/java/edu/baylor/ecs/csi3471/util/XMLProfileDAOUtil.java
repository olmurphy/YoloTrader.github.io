package edu.baylor.ecs.csi3471.util;

import edu.baylor.ecs.csi3471.dao.ProfileDAO;
import edu.baylor.ecs.csi3471.dao.ProfileDAOImpl;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class XMLProfileDAOUtil {

    public void doSave(ProfileDAO dao) {
        try {

            JAXBContext context = JAXBContext.newInstance(edu.baylor.ecs.csi3471.dao.ProfileDAOImpl.class);

            Marshaller m = context.createMarshaller();

            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            m.marshal(dao, new File("database.xml"));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public ProfileDAO load() {
        ProfileDAO db = null;

        try {
            // create new instance of JAXBContext
            JAXBContext context = JAXBContext.newInstance(edu.baylor.ecs.csi3471.dao.ProfileDAOImpl.class);

            // Unmarshaller governs process of deserializing XML data into newly created Java
            // content trees, optionally validating the XML data
            Unmarshaller um = context.createUnmarshaller();

            // unmarshal a global XML root and its data
            db = (ProfileDAOImpl) um.unmarshal(new FileReader("database.xml"));

        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return db;
    }
}
