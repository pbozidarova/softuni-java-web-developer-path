import javax.xml.crypto.Data;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Server implements Runnable {
    private int port;

    private ServerSocket serverSocket;

    public Server(int port) {
        this.port = port;
    }

    private void readStream(Socket socket) {
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()));
            String line = reader.readLine();
            while (true) {
                if (line == null || line.isEmpty()) {
                    break;
                }
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private byte[] getResponse() {
        StringBuilder sb = new StringBuilder();

        sb.append("HTTP/1.1 200 OK").append(System.lineSeparator());
        sb.append("Host: localhost:8000").append(System.lineSeparator());
        //sb.append("Content-Type: text/plain").append(System.lineSeparator());
        sb.append(System.lineSeparator());
        sb.append("<h1>Hello World!</h1>").append(System.lineSeparator());
        sb.append("<h1>This is My Web Server!</h1>").append(System.lineSeparator());

        return sb.toString().getBytes();

    }

    @Override
    public void run() {
        try {
            this.serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            Socket clientSocket = null;

            this.serverSocket.setSoTimeout(5000);

            while (true) {
                try {

                    clientSocket = this.serverSocket.accept();
                    clientSocket.setSoTimeout(5000);

                    this.readStream(clientSocket);
                    this.writeStream(clientSocket, this.getResponse());


                    while (!clientSocket.isClosed()) {

                        clientSocket.getInputStream().close();
                        clientSocket.getOutputStream().close();
                        clientSocket.close();
                    }
                    break;
                } catch (Exception ignored) {
                    System.out.println("Timeout!");
                }

            }
        } catch (IOException e) {
            System.out.println("Something went wrong!");
            e.printStackTrace();
        }
    }

    private void writeStream(Socket clientSocket, byte[] response) {
        try {
            DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
            outputStream.write(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
