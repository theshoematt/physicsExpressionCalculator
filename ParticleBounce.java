package newtonianMechanics;

import java.util.ArrayList;

public class ParticleBounce {

    private final Particle particle;
    private final ArrayList<Position> posAtTimeT = new ArrayList<Position>();
    private final ArrayList<Velocity> velAtTimeT = new ArrayList<Velocity>();
    private final Acceleration GRAVITY = new Acceleration(0,0,-9.81);
    private final double TIMESPAN = 10;
    private final Time dt = new Time(.001);
    
    public ParticleBounce(Particle particle) { this.particle = particle;}

    private void getTrajectory() {
        Time t = new Time(0);
        Velocity dv = (Velocity) GRAVITY.scalarProduct(dt);
        Velocity v0 = particle.v;
        Position q0 = particle.q;
        
        while (t.getValue() < TIMESPAN) {
            posAtTimeT.add(q0);
            velAtTimeT.add(v0);
            v0 = (Velocity) v0.add(dv); 
            q0 = (Position) q0.add(v0.scalarProduct(dt));
            t.tick(dt);
        }
    }
    
    public void run() {
        getTrajectory();
        for (int i = 0; i < posAtTimeT.size(); i++) {
            System.out.println(posAtTimeT.get(i).toString()+" "+velAtTimeT.get(i).toString());
        }
    }
    
    public static void main(String[] args) {
        Particle particle = new Particle();
        ParticleBounce pb = new ParticleBounce(particle);
        
        pb.run();
    }
    
}

