public class Data{
    private static int nextID = 0;
    private int studentID = 0;
    private double score1 = 0;
    private double score2 = 0;
    private double score3 = 0;

    private static int getNextID()
    {
        return ++nextID;
    }

    public Data(){
        this(0,0,0);
    }
    public Data(double x, double y, double z){
        studentID = getNextID();        
        setScore1(x);
        setScore2(y);
        setScore3(z);
    }
     
    public Data(Data a){
        this.studentID = a.studentID;
        this.score1 = a.score1;
        this.score2 = a.score2;
        this.score3 = a.score3;
    }
    public double averageScore(){
        return (getScore1()+getScore2()+getScore3())/3;
    }
    public String grade(){
        if(averageScore() >= 90) return "A";
        else if(averageScore() >= 80) return "B";
        else if(averageScore() >= 70) return "C";
        else if(averageScore() >= 60) return "D";
        else return "F";
    }
    public int getID(){
        return studentID;
    }
    public void setID(int n){
        studentID = n;
    }
    public double getScore1(){
        return score1;
    }
    public double getScore2(){
        return score2;
    }
    public double getScore3(){
        return score3;
    }
    public void setScore1(double n){
        score1 = n;
    }
    public void setScore2(double n){
        score2 = n;
    }
    public void setScore3(double n){
        score3 = n;
    }
    public String toString(){
        return "Student id: " + studentID + ", Score 1: " + score1 +
                ", Score 2: " + score2 + ", Score 3: " + score3;
    }
}