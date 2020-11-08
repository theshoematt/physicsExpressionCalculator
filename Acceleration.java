package newtonianMechanics;

public class Acceleration implements Vector {
    //REP INVARIANT
    private final double[] a;
    private final String units = "m/s^2";
    
    //CONSTRUCTORS
    public Acceleration() {
        this.a = new double[] {0,0,0};
    }
    
    public Acceleration(double ax) {
        this.a = new double[] {ax,0,0};
    }
    
    public Acceleration(double ax, double ay) {
        this.a = new double[] {ax,ay,0};
    }
    
    public Acceleration(double ax, double ay, double az) {
        this.a = new double[] {ax,ay,az};
    }
    
    //OBSERVERS
    @Override public double[] getComponents() { return a.clone();}
    @Override public double get1() { return a[0];}
    @Override public double get2() { return a[1];}
    @Override public double get3() { return a[2];}
    public String getUnits() { return new String(units);}
    
    //MUTATORS
    @Override public void updateComponents(double ax, double ay, double az) { update1(ax); update2(ay); update3(az);}
    @Override public void update1(double ax) { a[0] = ax;}
    @Override public void update2(double ay) { a[1] = ay;}
    @Override public void update3(double az) { a[2] = az;}
    
    //PRODUCERS
    @Override
    public Vector add(Vector accel) {
        if (accel instanceof Acceleration) {
            return new Velocity(get1()+accel.get1(), get2()+accel.get2(), get3()+accel.get3());
        } else {
            throw new IllegalArgumentException("An Acceleration can only be added to an Acceleration!");
        }
    }

    @Override
    public Vector sub(Vector accel) {
        if (accel instanceof Acceleration) {
            return new Velocity(get1()-accel.get1(), get2()-accel.get2(), get3()-accel.get3());
        } else {
            throw new IllegalArgumentException("An Acceleration can only be added to an Acceleration!");
        }
    }

    @Override
    public Vector scalarProduct(Scalar c) {
        double value = c.getValue();
        String units = c.getUnits();
        
             if (units == "")  { return new Acceleration(value*get1(), value*get2(), value*get3());}
        else if (units == "s") { return new Velocity(value*get1(), value*get2(), value*get3());}
        else { throw new IllegalArgumentException("No object can represent this product.");}
    }

    @Override
    public double dotProduct(Vector n) {
        return (get1()*n.get1()) + (get2()*n.get2()) + (get3()*n.get3());
    }

    @Override
    public Vector crossProduct(Vector n) {
        return null;
    }

    @Override
    public String toString() {
        return "Acceleration: {"+get1()+", "+get2()+", "+get3()+"}";
    }
}
