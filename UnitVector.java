package newtonianMechanics;

public class UnitVector implements Vector {
    
    private final double mag;
    private final double[] comps;
    
    public UnitVector(Vector v) {
        this.mag = calcMag(v.getComponents());
        this.comps = calcComps(v.getComponents(), mag);
    }
    
    private double calcMag(double[] comps) {
        double sqsum = 0;
        for (int a = 0; a < comps.length; a++) { sqsum += Math.pow(comps[a], 2);}
        return Math.sqrt(sqsum);
    }
    
    private double[] calcComps(double[] comps, double mag) {
        double[] mycomps = new double[comps.length];
        for (int a = 0; a < comps.length; a++) { mycomps[a] = comps[a]/mag;}
        return mycomps;
    }
    
    @Override public double getMag() { return mag;}
    @Override public Vector getDir() { return this;}
    @Override public double[] getComponents() { return comps;}

    @Override
    public Vector add(Vector a) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override public Vector minus(Vector a) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override public Vector scalarProduct(double c) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public double dotProduct(Vector a) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Vector crossProduct(Vector a) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public String toString() {
        String s = "{"+comps[0];
        for (int a = 1; a < comps.length; a++) { s += ", "+comps[a];}
        s += "}";
        return s;
    }
}
