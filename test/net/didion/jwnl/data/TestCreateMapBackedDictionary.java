package net.didion.jwnl.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Tests MapBackedDictionary editing.
 *
 * @author Aliaksandr Autayeu avtaev@gmail.com
 */
public class TestCreateMapBackedDictionary extends TestCreateDictionary{

    protected static final String properties = "./config/clean_map.xml";

    @Override
    protected InputStream getProperties() throws FileNotFoundException {
        return new FileInputStream(properties);
    }
}
