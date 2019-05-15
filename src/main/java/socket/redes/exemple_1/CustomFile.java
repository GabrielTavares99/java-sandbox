package socket.redes.exemple_1;

import java.io.Serializable;

public class CustomFile implements Serializable {

    private byte[] fileInBytes;
    private String extension;
    private String filename;

    public byte[] getFileInBytes() {
        return fileInBytes;
    }

    public void setFileInBytes(byte[] fileInBytes) {
        this.fileInBytes = fileInBytes;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
