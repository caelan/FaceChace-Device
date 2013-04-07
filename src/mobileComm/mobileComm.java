package mobileComm;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class mobileComm {
    private BlockingQueue<String> messagesToServer;
    
    
    public mobileComm() throws UnknownHostException, IOException {

        Socket s = new Socket("18.189.22.207", 4444);
        messagesToServer = new LinkedBlockingQueue<String>();
        InputThread inputThread = new InputThread(s, this);
        OutputThread outputThread = new OutputThread(s, messagesToServer);
        inputThread.start();
        outputThread.start();

    }
    
    public void handleMessageIn(String msg) {
        
        //Put some of other code in for guidance
        
        //System.out.println("\nMsgIn:"+msg);
        //String[] tokenGroups = msg.split(groupDelimRE,3);
        //String[] metaTokens = tokenGroups[0].split(itemDelimRE);
        
        //The initial split is still a string, so we need to convert them to ints
        /**String[] numberTokensStrings = tokenGroups[1].split(itemDelimRE);
        int[] numberTokens = new int [numberTokensStrings.length];
        for (int i = 0; i < numberTokensStrings.length; i ++) {
            numberTokens[i] = Integer.parseInt(numberTokensStrings[i]);
        }
        **/
        
        //first split the message into key words
        String[] split = msg.split("\\s+"); 
        
        if(split.length>0){
            
        }
        
        
        
        

    }
    
    //In screens can add code to make them send messages to the server
    
    public void handleMessageOut(String msg){
        messagesToServer.add(msg);
    }



}
