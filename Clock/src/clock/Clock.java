
package clock;

public class Clock {
    
    private Display hour,min,seg;
    private String period;
    private int type;
    
    public Clock(int type){
        this.type = type;
        if(this.type == 1){
            hour = new Display(24);
            min = new Display(60);
            seg = new Display(60);
        }
        else{            
            hour = new Display(13);
            hour.setValue(12);
            min = new Display(60);
            seg = new Display(60);
            period = "AM";           
        }
    }
    public Clock(int type,int hour,int min){
        this.type = type;
        if(this.type == 1){
            this.hour = new Display(24);
            this.hour.setValue(hour);
            this.min = new Display(60);
            this.min.setValue(min);
            seg = new Display(60);
        }
        else{
            this.hour = new Display(13);
            if(hour > 12) {
                this.hour.setValue(hour-12);
                period = "PM";
            }
            else{
                this.hour.setValue(hour);      
                period = "AM";
            }
            this.min = new Display(60);
            this.min.setValue(min);
            seg = new Display(60);            
        }
    }    
    public String getTime(){
        if(type == 1)
            return hour.getConvertedValue()+":"+min.getConvertedValue()+":"+seg.getConvertedValue();
        else
            return hour.getConvertedValue()+":"+min.getConvertedValue()+":"+seg.getConvertedValue()+" "+period;
    }
    public void tick(){
        seg.increment();
        if(seg.getValue() == 0){
            min.increment();
            if(min.getValue() == 0){
                hour.increment();
                if(hour.getValue() == 12)
                    if(period == "AM")
                        period = "PM";               
                    else
                        period = "AM";
                if(hour.getValue() == 0)
                    hour.setValue(1);                                    
            }
        }
    }
}
