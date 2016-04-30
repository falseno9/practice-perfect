package readbytes;

/**
 * Created by Kunal on 4/30/2016.
 */
public class ByteObject {

    private ByteObject prev;
    private ByteObject next;
    private Byte data;

    ByteObject(Byte data) {
        this.data = data;
    }

    public ByteObject getPrev() {
        return prev;
    }

    public void setPrev(ByteObject prev) {
        this.prev = prev;
    }

    public ByteObject getNext() {
        return next;
    }

    public void setNext(ByteObject next) {
        this.next = next;
    }

    public Byte getData() {
        return data;
    }

    public void setData(Byte data) {
        this.data = data;
    }
}
