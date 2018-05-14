import java.text.DecimalFormat;
public class UnsortArray{
    private Data[] a;
    private int next;
    private int size;
    DecimalFormat pattern = new DecimalFormat("##.00");

    public UnsortArray(){
        this(0);
    }
    public UnsortArray(int n){
        if(n<0) n=10;
        a = new Data[n];
        next = 0;
        size = n;
    }
    public boolean insert(double x, double y, double z){//done
        if(next == size) return false;//structure full
        a[next] = new Data(x,y,z);
        if(a[next] == null) return false;//insufficient memory
        next++;
        return true;
        }        
    
      public Data fetch(int targetKey){
        int i = 0;
        while(targetKey != a[i].getID()) i++;
        if(i == next) return null;
        return new Data(a[i]);
        }
    //replaces an item at a specific location with another item
    public void update(int targetKey, Data x){
        Data y = new Data(x);
        int i = 0;
        while(targetKey != a[i].getID()) i++;         
        y.setID(i+1);
        a[i] = y;
    }
    public boolean delete(int targetKey){//done
        int i = 0;
        while(targetKey != a[i].getID()) i++;
        if(i == next) return false;//node not found
        for(int j=i; j<next-1;j++) a[j] = a[j+1];
        next = next - 1;
        a[next] = null;
        return true;
        
    }
    public void details(int n){
        for(int i = 0; i < a.length; i++){
            if(a[i] != null)
                if(a[i].getID() == n){
                    System.out.println(a[i].toString());
            }
        }
        }
    public void details(int n,int z){
        for(int i = 0; i < a.length; i++){
            if(a[i] != null)
                if(a[i].getID() == n){
                    System.out.println(a[i].toString() + " Average Score : "
                            + pattern.format(a[i].averageScore()) + ", Grade: "
                            + a[i].grade());
            }
        }
        }
    public void arrayDetails(){
        for(Data element: a) System.out.println(element);
        
    }
    
    }

