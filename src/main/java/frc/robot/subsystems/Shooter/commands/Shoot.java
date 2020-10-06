package frc.robot.subsystems.Shooter.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.Shooter.Shooter;

/**
 * this command activates the shooter subsystem based on power
 */
public class Shoot extends CommandBase {
    private Shooter shooter;
    private double velocity;

    /**
     * Command Constructor
     * @param shooter - the Shooter Subsystem
     * @param velocity - target velocity (m/s)
     */
    public Shoot(Shooter shooter,double velocity) {
        this.shooter = shooter;
        this.velocity = velocity;
    }

    @Override
    public void initialize() {
        this.shooter.setPower(this.velocity); // calls Shooter's setPower function
    }

    @Override
    public void execute() {
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        this.shooter.setPower(0.0);// sets  the power of the Shooter's motors to 0
    }
}
