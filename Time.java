package newtonianMechanics;

public class Time implements Scalar{
    //REP (IN)VARIANTS
    private double t;
    private final String units = "s";
    
    //CONSTRUCTORS
    public Time() { this.t = 0;}
    public Time(double t) { this.t = t;}
    
    //OBSERVERS
    @Override public double getValue() { return t;}
    @Override public String getUnits() { return units;} 
    
    //MUTATORS
    public double tick() {
        t += 1;
        return t;
    }
    
    public double tick(double dt) {
        t += dt;
        return t;
    }
    
    public double tick(Time dt) {
        t += dt.getValue();
        return t;
    }
}
