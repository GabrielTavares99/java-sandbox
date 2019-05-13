package socket.redes;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkService {

    public static String getStorageServerIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return "localhost";
        }
    }

}
