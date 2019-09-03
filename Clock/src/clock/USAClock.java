
package clock;

public class USAClock {
    
    private Display hour,min,seg;
    private String period;
    
    public USAClock(){
        hour = new Display(13);
        min = new Display(60);
        seg = new Display(60);
        period = "AM";
    }
    public USAClock(int hour,int min){
        this.hour = new Display(13);
        if(hour > 12)
            this.hour.setValue(hour-12);
        else
            this.hour.setValue(hour);
        this.min = new Display(60);
        this.min.setValue(min);
        seg = new Display(60);            
    }
    public String getTime(){
        return hour.getConvertedValue()+":"+min.getConvertedValue()+":"+seg.getConvertedValue()+" "+period;
    }
    public void tick(){
        seg.increment();
        if(seg.getValue() == 0){
            min.increment();
            if(min.getValue() == 0){
                hour.increment();
                if(hour.getValue() == 1)
                    if(period == "AM")
                        period = "PM";
                    else
                        period = "AM";
            }
        }
    }
}
