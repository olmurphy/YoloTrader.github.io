package edu.baylor.ecs.csi3471.util;

import edu.baylor.ecs.csi3471.dao.GenericDAO;
import edu.baylor.ecs.csi3471.dao.ProfileDAO;
import edu.baylor.ecs.csi3471.model.Profile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * @author owenmurphy
 */
public class XMLProfileDAOUtil {

    public void doSave(GenericDAO<Profile> profileGenericDAO) {
        try {

            JAXBContext context = JAXBContext.newInstance(ProfileDAO.class);

            Marshaller m = context.createMarshaller();

            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            m.marshal(profileGenericDAO, new FileWriter("database.xml"));

        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }

    public GenericDAO<Profile> load() {
        GenericDAO<Profile> db = null;

        try {
            // create new instance of JAXBContext
            JAXBContext context = JAXBContext.newInstance(ProfileDAO.class);

            // Unmarshaller governs process of deserializing XML data into newly created Java
            // content trees, optionally validating the XML data
            Unmarshaller um = context.createUnmarshaller();

            // unmarshal a global XML root and its data
            db = (ProfileDAO) um.unmarshal(new FileReader("database.xml"));

        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return db;
    }
}
