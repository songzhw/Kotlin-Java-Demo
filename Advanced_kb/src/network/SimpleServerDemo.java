package network;
/*
    implementation 'org.nanohttpd:nanohttpd:2.3.1'
    implementation 'org.nanohttpd:nanohttpd-webserver:2.3.1'
 */
import fi.iki.elonen.NanoHTTPD;

import java.io.IOException;
import java.util.List;
import java.util.Map;

class SimpleServer extends NanoHTTPD {

    public SimpleServer(int port) {
        super(port);
    }

    @Override
    public Response serve(IHTTPSession session) {
        String html = "<html><body> <h1> Hello Nano Http </h1>";

        Map<String, List<String>> parms = session.getParameters();
        if (parms.get("username") == null) {
            html += "<form action='?' method='get'>\n  <p>Your name: <input type='text' name='username'></p>\n" + "</form>\n";
        } else {
            html += "<p>Hello, " + parms.get("username").get(0) + "!</p>";

        }
        html += "</body></html>";
        return newFixedLengthResponse(html);
    }
}

public class SimpleServerDemo {
    public static void main(String[] args) throws IOException {
        SimpleServer server = new SimpleServer(8999);
        server.start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
        System.out.println("szw server is running! Point your browsers to http://localhost:8999");
    }
}
