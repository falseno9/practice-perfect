package Random;

import org.junit.Assert;
import org.junit.Test;


public class CommonBondTest {
    @Test
    public void listMissingLetters() throws Exception {
        CommonBond cb = new CommonBond();
        Assert.assertEquals("", cb.listMissingLetters("A quick brown fox jumps over the lazy dog"));
        Assert.assertEquals("bhijklmpqtwxz", cb.listMissingLetters("Four score and seven years ago."));
        Assert.assertEquals("cdfgjklmpvwxyz", cb.listMissingLetters("To be or not to be, that is the question!"));
        Assert.assertEquals("abcdefghijklmnopqrstuvwxyz", cb.listMissingLetters(""));
    }

    @Test
    public void explode() throws Exception {

    }

}