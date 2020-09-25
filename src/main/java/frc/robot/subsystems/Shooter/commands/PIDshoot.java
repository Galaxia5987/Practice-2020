package frc.robot.subsystems.Shooter.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Shooter.Shooter;

/**
 * this command activates the shooter subsystem based on distance
 */
public class PIDshoot extends CommandBase {
    private Shooter shooter;
    private double distance;
    private double power;

    public PIDshoot(Shooter shooter, double distance, double power) {
        this.shooter = shooter;
        this.distance = distance;
        this.power = power;
    }
}
