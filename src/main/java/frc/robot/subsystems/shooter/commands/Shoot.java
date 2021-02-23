package frc.robot.subsystems.shooter.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.shooter.Shooter;


/**
 * activates the shooter subsystem based on distance.
 */
public class Shoot extends CommandBase {
    private Shooter shooter;
    private double distance;

    /**
     * Command Constructor
     * @param shooter - the Shooter Subsystem
     * @param distance - the target distance
     */
    public Shoot(Shooter shooter,double distance) {
        this.shooter = shooter;
        this.distance = distance;
        addRequirements(shooter);
    }

    /**
     * calculates optimal speed for intake
     */
    private double getOptimalSpeed(){
        return 1.1; //TODO: placeholder
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        SmartDashboard.putNumber("shooter velocity", shooter.getVelocity());
        shooter.setVelocity(getOptimalSpeed());
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        this.shooter.setVelocity(0.0);// sets  the power of the Shooter's motors to 0
    }
}
