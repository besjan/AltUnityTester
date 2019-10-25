package ro.altom.altunitytester;

import java.io.DataInputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class AltBaseSettings {
    public Socket socket;
    public String RequestSeparator;
    public String RequestEnd;
    public PrintWriter out;
    public DataInputStream in;

    public AltBaseSettings(Socket socket, String requestSeparator, String requestEnd, PrintWriter out, DataInputStream in) {
        this.socket = socket;
        RequestSeparator = requestSeparator;
        RequestEnd = requestEnd;
        this.out = out;
        this.in = in;
    }
}
