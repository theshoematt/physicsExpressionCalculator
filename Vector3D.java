package newtonianMechanics;

public class Vector3D implements Vector {
    
    private final double mag;
    private final UnitVector dir;
    private final double[] comps;
    
    public Vector3D(double i, double j, double k) {
        this.mag = Math.sqrt(Math.pow(i, 2) + Math.pow(j, 2) + Math.pow(k, 2));
        this.comps = new double[] {i,j,k};
        this.dir = new UnitVector(this);
    }
    
    @Override public double getMag() { return mag;}
    @Override public UnitVector getDir() { return dir;}
    @Override public double[] getComponents() { return comps;}
    
    @Override
    public Vector3D add(Vector a)   { 
        double[] acomps = a.getComponents();
        if (acomps.length != 3) { throw new IllegalArgumentException("Can only add vectors with the same dimension.");}
        return new Vector3D(comps[0]+acomps[0], 
                            comps[1]+acomps[1], 
                            comps[2]+acomps[2]);
    }
    
    @Override
    public Vector3D minus(Vector a) { 
        double[] acomps = a.getComponents();
        if (acomps.length != 3) { throw new IllegalArgumentException("Can only subtract vectors with the same dimension.");}
        return new Vector3D(comps[0]-acomps[0], 
                            comps[1]-acomps[1], 
                            comps[2]-acomps[2]);    
    }
    
    @Override
    public Vector3D scalarProduct(double c) { 
        return new Vector3D(c*comps[0], 
                            c*comps[1], 
                            c*comps[2]);
    }
    
    @Override
    public double dotProduct(Vector a) { 
        double[] acomps = a.getComponents();
        if (acomps.length != 3) { throw new IllegalArgumentException("Can only dot product vectors with the same dimension.");}
        return comps[0]*acomps[0] 
             + comps[1]*acomps[1]
             + comps[2]*acomps[2];
    }
    
    @Override
    public Vector3D crossProduct(Vector a) { 
        double[] acomps = a.getComponents();
        if (acomps.length != 3) { throw new IllegalArgumentException("Can only cross product vectors with the same dimension.");}
        return new Vector3D(comps[1]*acomps[2] - comps[2]*acomps[1],
                            comps[2]*acomps[0] - comps[0]*acomps[2], 
                            comps[0]*acomps[1] - comps[1]*acomps[0]);
    }
    
    @Override
    public String toString() {
        return "{"+comps[0]+", "+comps[1]+", "+comps[2]+"}";
    }
}
