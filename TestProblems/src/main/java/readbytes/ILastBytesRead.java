package readbytes;

/**
 * Created by Kunal on 4/30/2016.
 */
public interface ILastBytesRead {

    public abstract void recordByte(byte b);

    public abstract String printLastBytes();

}