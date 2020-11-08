package newtonianMechanics;

import java.lang.Math;

public class Vector2D implements Vector {
    
    private final double mag;
    private final double[] comps;
    private final UnitVector dir;
    
    public Vector2D(double i, double j) {
        this.mag = Math.sqrt(Math.pow(i, 2) + Math.pow(j, 2));
        this.comps = new double[] {i,j};
        this.dir = new UnitVector(this);
    }
    
    @Override public double getMag() { return mag;}
    @Override public double[] getComponents() { return comps;}
    @Override public UnitVector getDir() { return dir;}
    
    @Override
    public Vector2D add(Vector a) { 
        double[] acomps = a.getComponents();
        if (acomps.length != 2) { throw new IllegalArgumentException("Can only add vectors with the same dimension.");}
        return new Vector2D(comps[0]+acomps[0], 
                            comps[1]+acomps[1]);
    }
    
    @Override
    public Vector2D minus(Vector a) {
        double[] acomps = a.getComponents();
        if (acomps.length != 2) { throw new IllegalArgumentException("Can only subtract vectors with the same dimension.");}
        return new Vector2D(comps[0]-acomps[0], 
                            comps[1]-acomps[1]);
    }
    
    @Override
    public Vector2D scalarProduct(double c) { 
        return new Vector2D(c*comps[0], 
                            c*comps[1]);
    }
    
    @Override
    public double dotProduct(Vector a) { 
        double[] acomps = a.getComponents();
        if (acomps.length != 2) { throw new IllegalArgumentException("Can only dot product vectors with the same dimension.");}
        return comps[0]*acomps[0]
             + comps[1]*acomps[1]; 
    }
    
    @Override
    public Vector3D crossProduct(Vector a) { 
        double[] acomps = a.getComponents();
        if (acomps.length != 2) { throw new IllegalArgumentException("Can only cross product vectors with the same dimension.");}
        return new Vector3D(0,
                            0, 
                            comps[0]*acomps[1] - comps[1]*acomps[0]);
    }
    
    @Override
    public String toString() {
        return "{"+comps[0]+", "+comps[1]+"}";
    }
}
