
package clock;

public class Display {
    
    private int value,limit;
    
    public Display(int limit){
        value = 0;
        this.limit = limit;
    }
    public int getValue(){ return value; }
    public String getConvertedValue(){
        if(value < 10)
            return "0"+value;
        else
            return ""+value;
    }
    public void setValue(int value){
        if(value >= 0 && value < limit)
           this.value = value; 
    }
    public void increment(){
      value = (value+1)%limit;  
    }
}
