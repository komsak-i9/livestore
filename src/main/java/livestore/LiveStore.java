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
        List<ItemDTO> items = storeLoader.getItems();

        ItemDTO dto = storeLoader.getItem(1);
        System.out.print ("getItem:" + dto.getType());
    }
//
//    public static void createItemService(List<ItemDTO> items) throws IOException {
//        String clientSentence;
//        ServerSocket welcomeSocket = new ServerSocket(80);
//
//        while (true) {
//            Socket conSocket = welcomeSocket.accept();
//            BufferedReader fromClient = new BufferedReader(
//                    new InputStreamReader(conSocket.getInputStream()));
//
//            DataOutputStream toClient = new DataOutputStream(conSocket.getOutputStream());
//  //        System.out.println("fromClient:" + fromClient.readLine());
//            
//            toClient.writeBytes("HTTP/1.1 200 OK\r\n");
//            toClient.writeBytes("Content-Type: text/html\r\n");
//            String html = "<html><body><h1>It works!</h1></body></html>\r\n";
//            
//            toClient.writeBytes(html);
//            toClient.flush();
//            conSocket.close();
////            
////            clientSentence = fromClient.readLine();
////
////            String s = "Hello," + clientSentence + "," 
////                    + "what would you like to buy?\n";
////           
////            for (ItemDTO item : items) {
////                s = s + (item.getType() + ", sellPrice=" +
////                        item.getPrice() * item.
////                                getCost() + '\n');
////            }
////            toClient.writeBytes(s);
////            toClient.flush();
//        }
//    }
}
