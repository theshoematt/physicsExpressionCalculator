package newtonianMechanics;

public class Constant implements Scalar{
    //REP INVARIANTS
    private final double c;
    private final String units = "";
    
    //CONSTRUCTORS
    public Constant(double c) { this.c = c;}
    
    //OBSERVERS
    @Override public double getValue() { return c;}
    @Override public String getUnits() { return units;}
}
