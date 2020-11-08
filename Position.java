package newtonianMechanics;

public class Position implements PhysicsVector{
    // REP VARIANTS: safe from rep exposure, but not indirect mutation
    private final Vector r;
    private final String units = "m";
    
    //CONSTRUCTORS
    public Position() { 
        this.r = new Vector3D(0,0,0);
    }
    
    public Position(double x) { 
        this.r = new Vector3D(x,0,0);
    }
    
    public Position(double x, double y) { 
        this.r = new Vector3D(x,y,0);
    }
    
    public Position(double x, double y, double z) {
        this.r = new Vector3D(x,y,z);
    }
    
    
    // OBSERVERS
    @Override public double getMag() { return r.getMag();}
    @Override public double[] getComponents() { return r.getComponents();}
    @Override public Vector getDir() { return r.getDir();}
    @Override public Vector getVector() { return r;}
    @Override public String getUnits() { return units;}
    
    
    // MUTATORS
    
    
    
    //PRODUCERS
    @Override
    public Vector add(Vector pos) {
        if (pos instanceof Position) {
            double[] pcomps = (r.add(((Position) pos).getVector())).getComponents();
            return new Position(pcomps[0], pcomps[1], pcomps[2]);
        } else {
            throw new IllegalArgumentException("A Position can only be added to a Position!");
        }
    }

    @Override
    public Vector minus(Vector pos) {
        if (pos instanceof Position) {
            double[] pcomps = (r.minus(((Position) pos).getVector())).getComponents();
            return new Position(pcomps[0], pcomps[1], pcomps[2]);
        } else {
            throw new IllegalArgumentException("A Position can only be added to a Position!");
        }
    }

    @Override
    public Vector scalarProduct(double c) {
        return scalarProduct(c);
    }

    @Override
    public double dotProduct(Vector n) {
        return r.dotProduct(n);
    }

    @Override
    public Vector crossProduct(Vector n) {
        return r.crossProduct(n);
    }
    
    @Override
    public String toString() {
        return "Position: "+r.toString();
    }

}
