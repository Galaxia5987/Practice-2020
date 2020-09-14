package frc.robot.subsystems.Shooter.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter.Shooter;

public class Shoot extends CommandBase {
    private Shooter shooter;
    private double power;

    /**
     * @param shooter - the Shooter Subsystem
     * @param power - power output (%)
     * Contractor
     */
    public Shoot(Shooter shooter,double power) {
        this.shooter = shooter;
        this.power = power;
    }

    @Override
    public void initialize() {
        this.shooter.setPower(this.power); // calls Shooter's setPower function
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
