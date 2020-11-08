package newtonianMechanics;

public class Vector1D implements Vector {
    
    private final double mag;
    private final double[] comps;
    private final UnitVector dir;
    
    public Vector1D(double mag) { 
        this.mag = mag;
        this.comps = new double[] {mag};
        this.dir = new UnitVector(this);
    }
    
    @Override public double getMag() { return mag;}
    @Override public double[] getComponents() { return comps;}
    @Override public Vector getDir() { return dir;}
    
    @Override
    public Vector1D add(Vector a) { 
        double[] acomps = a.getComponents();
        if (acomps.length != 1) { throw new IllegalArgumentException("Can only add vectors with the same dimension.");}
        return new Vector1D(mag+acomps[0]);
    }
    
    @Override
    public Vector1D minus(Vector a) { 
        double[] acomps = a.getComponents();
        if (acomps.length != 1) { throw new IllegalArgumentException("Can only subtract vectors with the same dimension.");}
        return new Vector1D(mag-acomps[0]);
    }
    
    @Override 
    public Vector1D scalarProduct(double c) { return new Vector1D(c*mag);}
    
    @Override
    public double dotProduct(Vector a) { 
        double[] acomps = a.getComponents();
        if (acomps.length != 1) { throw new IllegalArgumentException("Can only dot product vectors with the same dimension.");}
        return mag*acomps[0];
    }
    
    @Override
    public Vector1D crossProduct(Vector a) { throw new IllegalArgumentException("Cross product for 1D Vectors are undefined.");}
    
    @Override
    public String toString() {
        return "{"+comps[0]+"}";
    }
}
