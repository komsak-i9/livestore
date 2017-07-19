package livestore;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author ARIT
 */
public class LiveStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        StoreLoader storeLoader = new StoreLoader(
                "mydb1", "root", "password");
        List<ItemDTO> items = storeLoader.LoadItems();

        createItemService(items);
    }

    public static void createItemService(List<ItemDTO> items) throws IOException {
        String clientSentence;
        String capSentence;

        ServerSocket welcomeSocket = new ServerSocket(8080);

        while (true) {
            Socket conSocket = welcomeSocket.accept();
            BufferedReader fromClient = new BufferedReader (
                new InputStreamReader(conSocket.getInputStream()));
            DataOutputStream toClient = new DataOutputStream(conSocket.getOutputStream());
            clientSentence = fromClient.readLine();
            String s = "Hello,"+ clientSentence+ '\n';
            toClient.writeBytes(s);  
        }
    }
}
