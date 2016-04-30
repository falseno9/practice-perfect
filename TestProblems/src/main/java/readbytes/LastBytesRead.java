package readbytes;

/**
 * Created by Kunal on 4/30/2016.
 */
public class LastBytesRead implements ILastBytesRead {

    private static final int BYTES_READ = 1024;
    private static ByteObject queue;

    LastBytesRead() {
        queue = null;
    }

    public void recordByte(byte b) {
        //First element of queue
        if (queue == null) {
            queue = new ByteObject(b);
            queue.setNext(null);
            //For remaining elements, create ByteObject, and set appropriate previous and next values
        } else {
            ByteObject byteObject = new ByteObject(b);
            byteObject.setPrev(queue);
            queue.setNext(byteObject);
            queue = queue.getNext();
        }
    }

    public String printLastBytes() {
        int counter = 0;
        ByteObject currPos = queue;
        final byte[] output = new byte[BYTES_READ];
        //Read until BYTES_READ or until start of queue
        while (counter < BYTES_READ && currPos != null) {
            output[BYTES_READ - counter - 1] = currPos.getData();
            currPos = currPos.getPrev();
            counter++;
        }
        //Return BYTES_READ bytes if available, else return read bytes
        return new String(output, BYTES_READ - counter, counter);
    }

    public static void main(String[] args) {
        LastBytesRead lastBytesRead = new LastBytesRead();
        String testString = "test string";
        byte[] testBytes = testString.getBytes();
        for (int i = 0; i < testBytes.length; i++) {
            lastBytesRead.recordByte(testBytes[i]);
        }
        System.out.println(lastBytesRead.printLastBytes());

        lastBytesRead = new LastBytesRead();
        testString = "Lorem ipsum dolor sit amet, ipsum massa, tempor nullam imperdiet, ipsum wisi malesuada eget a, nibh et quis in duis nonummy adipiscing, purus lorem erat nulla ante. Leo torquent arcu facilisis sem, ante vehicula amet libero id tincidunt, vitae fringilla, nullam ligula condimentum nec felis. Sit id id blandit, aliquam sit at mauris adipiscing sit, nec vestibulum, tempus feugiat tortor in vestibulum, eu pulvinar ultricies luctus id faucibus. Dis nonummy. Eros in elementum error fermentum vitae quis.\n" +
                "Sit dolor lobortis. Sagittis feugiat consequuntur praesent sit. Vel duis purus elit, elementum condimentum. Arcu leo sagittis magna quam morbi fusce, aliquam viverra mauris quis blandit. Metus aenean, dolor odio vestibulum vehicula sed. Turpis sem elit diam dolor lacus lacinia, suscipit ipsum leo enim posuere, sed integer amet. Ornare purus ante condimentum, lacus ad, tincidunt sodales a vestibulum auctor. Integer lobortis, porttitor dui lobortis interdum erat nec maecenas.\n" +
                "Non ut nullam metus et eu, vitae urna ipsum ut neque cursus. Sit tellus lectus, natoque blandit netus, tortor taciti, facilisis metus. Vel venenatis, gravida elit rhoncus dignissim diam, vestibulum ut risus sit pede metus, ultrices ipsum fames vulputate risus, orci erat tincidunt feugiat pulvinar ante. Nonummy in aliquam, a tempor, quam commodo nec nunc, sed quisque a nec. Id aliquam sed, ut ornare ipsum etiam accumsan placerat magna, in pede et augue, proin mauris lobortis orci justo in in, auctor rutrum neque mauris. Eros in nam habitasse ut justo velit.\n" +
                "Rhoncus nam placerat vestibulum morbi, rutrum pede aliquam semper volutpat, quia et, lacus rerum lorem volutpat adipiscing malesuada quam, quis ornare fermentum proin. Sed lectus vivamus suspendisse, dictumst ullamcorper laoreet mollis nec, posuere lorem volutpat pede in diam donec. Fringilla arcu vitae sit, vehicula sit laoreet hymenaeos tincidunt, vestibulum aenean pariatur nec sit ipsum. Suspendisse elit. Fusce mauris elementum cras, justo sem nisl proin proin proin amet, a sagittis, luctus a vulputate nisl integer dolor sed, leo corporis leo nonummy facilisis. Cras aliquam amet. Interdum dolor etiam eget aliquam, posuere accumsan massa vestibulum, nisl urna leo vivamus, sed interdum a suspendisse. Tortor tempor etiam arcu ut ac at. Morbi urna, ultricies est amet ullamcorper amet torquent cras, quisque dolor nulla, morbi lorem.";
        testBytes = testString.getBytes();
        for (int i = 0; i < testBytes.length; i++) {
            lastBytesRead.recordByte(testBytes[i]);
        }
        System.out.println(lastBytesRead.printLastBytes());
    }
}
