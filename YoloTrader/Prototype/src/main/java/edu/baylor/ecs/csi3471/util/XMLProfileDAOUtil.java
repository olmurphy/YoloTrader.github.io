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
 * This class is a utility class designed to transform memory representation of data to xml format
 * and vice versa using JAXB library
 *
 * @author owenmurphy
 */
public class XMLProfileDAOUtil {

    /**
     * takes a profileDAO and uses JAXB to transform memory rep of data into data format, i.e. xml
     *
     * @param profileGenericDAO takes in a profile DAO to marshall
     */
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

    /**
     * transforms the data format representation, i.e. xml file, into memory representation for
     * computer processing
     *
     * @return ProfileDAO containing list of profiles
     */
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
