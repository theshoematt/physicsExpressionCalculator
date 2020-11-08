package newtonianMechanics;

public class Velocity implements PhysicsVector {
    //REP VARIANTS: safe from rep exposure but not indirect mutation
    private final Vector v;
    private final String units = "m/s";
    
    //CONSTRUCOTRS
    public Velocity() {
        this.v = new Vector3D(0,0,0);
    }
    
    public Velocity(double vx) {
        this.v = new Vector3D(vx,0,0);
    }
    
    public Velocity(double vx, double vy) {
        this.v = new Vector3D(vx,vy,0);
    }
    
    public Velocity(double vx, double vy, double vz) {
        this.v = new Vector3D(vx,vy,vz);
    }
    
    // OBSERVERS: they do not allow for direct referencing
    @Override public double getMag() { return v.getMag();}
    @Override public double[] getComponents() { return v.getComponents();}
    @Override public Vector getDir() { return v.getDir();}
    @Override public Vector getVector() { return v;}
    @Override public String getUnits() { return units;}
    
    //PRODUCERS
    @Override
    public Vector add(Vector vel) {
        if (vel instanceof Velocity) {
            return new Velocity(get1()+vel.get1(), get2()+vel.get2(), get3()+vel.get3());
        } else {
            throw new IllegalArgumentException("A Velocity can only be added to a Velocity!");
        }
    }

    @Override
    public Vector sub(Vector vel) {
        if (vel instanceof Velocity) {
            return new Velocity(get1()-vel.get1(), get2()-vel.get2(), get3()-vel.get3());
        } else {
            throw new IllegalArgumentException("A Velocity can only be added to a Velocity!");
        }
    }

    @Override
    public Vector scalarProduct(Scalar c) {
        double value = c.getValue();
        String units = c.getUnits();
        
             if (units == "")  { return new Velocity(value*get1(), value*get2(), value*get3());}
        else if (units == "s") { return new Position(value*get1(), value*get2(), value*get3());}
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
        return "Velocity: {"+get1()+", "+get2()+", "+get3()+"}";
    }


    @Override
    public Vector minus(Vector a) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Vector scalarProduct(double c) {
        // TODO Auto-generated method stub
        return null;
    }

    
}
