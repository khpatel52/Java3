
public class Encryption{
    String message;
    int[] key = {5, 12, -3, 8, -9, 4, 10};
    Integer keyValue;
    String encoded, decoded;
    LinkedUnbndQueue q1;
    LinkedUnbndQueue q2;

    public Encryption(){
        message = "All programmers are playwrights and all computers "
                + "are lousy actors.";
        q1 = new LinkedUnbndQueue();
        q2 = new LinkedUnbndQueue();
        encoded = "";
        decoded = "";
        //insert the key into each of the queues
        for(int i = 0; i < key.length; i++){
            q1.enqueue(new IntElement(key[i]));
            q2.enqueue(new IntElement(key[i]));
        }
    }

    public String encoding(){        
        for(int i = 0; i < message.length(); i++){
            IntElement element = (IntElement)q1.dequeue();
            int x = element.getNum();
            encoded += (char)((int)message.charAt(i) + x);
            q1.enqueue(element);// to reload keys back
        }
        return encoded;
     }

    public String decoding(){
        for(int i =0; i < encoded.length(); i++){
            IntElement element = (IntElement)q2.dequeue();
            int x = element.getNum();
            decoded += (char)((int)encoded.charAt(i) - x);
            q2.enqueue(element);// to reload keys back
        }
        return decoded;
    }
    
}