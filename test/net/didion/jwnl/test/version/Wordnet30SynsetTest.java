package net.didion.jwnl.test.version;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import junit.framework.TestCase;
import net.didion.jwnl.JWNL;
import net.didion.jwnl.JWNLException;
import net.didion.jwnl.data.IndexWord;
import net.didion.jwnl.data.POS;
import net.didion.jwnl.data.Synset;
import net.didion.jwnl.data.Word;
import net.didion.jwnl.dictionary.Dictionary;

import org.junit.Test;

public class Wordnet30SynsetTest extends TestCase {

    @Test
    public void testGetBySynset() {
        try {
            //JWNL.initialize(new FileInputStream("C:\\21csi\\workspaces\\hicin-data-translator\\com.p21csi.lib.net.didion.jwnl\\config\\file_properties.xml"));
            JWNL.initialize(new FileInputStream("C:\\21csi\\workspaces\\hicin-data-translator\\jwnl\\config\\database_properties.xml"));
            /**
             * 3.0 offset for tank. 
             */
            long offset = 4389033;
            
            Synset syn = Dictionary.getInstance().getSynsetAt(POS.NOUN, offset);
            System.out.println("Synset: " + syn.toString());
            boolean match = false;
            for (Word w : syn.getWords()) {
                if (w.getLemma().equals("tank")) {
                    match = true;
                    break;
                }
            }
            
            if (!match) {
                fail("Term 'tank' not found in test grab.");
            }
            
        } catch(Exception e) {
            fail("Exception in Synset 3.0 test caught");
            e.printStackTrace();
        }
        
       
    }
    
    
    /**
     * Pulls a noun "tank" from the dictionary and checks to see if it has 5 senses.
     *
     */
    @Test
    public void testGetWordSenses() {
        try {
            JWNL.initialize(new FileInputStream("C:\\21csi\\workspaces\\hicin-data-translator\\com.p21csi.lib.net.didion.jwnl\\config\\file_properties.xml"));
            IndexWord word = Dictionary.getInstance().getIndexWord(POS.NOUN, "tank");
      
            assertTrue(word.getSenseCount() == 5); 
            
            word = Dictionary.getInstance().getIndexWord(POS.VERB, "eat");
            assertTrue(word.getSenseCount() == 6); 
            
            word = Dictionary.getInstance().getIndexWord(POS.ADJECTIVE, "quick");
            assertTrue(word.getSenseCount() == 6); 
            
            word = Dictionary.getInstance().getIndexWord(POS.ADJECTIVE, "big");
            assertTrue(word.getSenseCount() == 13); 
            
        } catch(JWNLException e) {
            fail("Exception in testGetSenses caught");
            e.printStackTrace();
        } catch(FileNotFoundException fe) {
            fe.printStackTrace();
        }
    }
    
    
    
}
