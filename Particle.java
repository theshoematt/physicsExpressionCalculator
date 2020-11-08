package newtonianMechanics;

public class Particle {
    public final double mass;
    public final Position q;
    public final Velocity v;
    
    public Particle() {
        this.mass = 0;
        this.q = new Position();
        this.v = new Velocity();
    }
    
    public Particle(double mass) {
        this.mass = mass;
        this.q = new Position();
        this.v = new Velocity();
    }
    public Particle(double mass, Position q) {
        this.mass = mass;
        this.q = q;
        this.v = new Velocity();
    }
    
    public Particle(double mass, Velocity v) {
        this.mass = mass;
        this.q = new Position();
        this.v = v;
    }
    
    public Particle(double mass, Position q, Velocity v) {
        this.mass = mass;
        this.q = q;
        this.v = v;
    }
}
