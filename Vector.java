package newtonianMechanics;

public interface Vector {
    public double getMag();
    public Vector getDir();
    public double[] getComponents();
    
    public Vector add(Vector a);
    public Vector minus(Vector a);
    
    public Vector scalarProduct(double c);
    public double dotProduct(Vector a);
    public Vector crossProduct(Vector a);
}
