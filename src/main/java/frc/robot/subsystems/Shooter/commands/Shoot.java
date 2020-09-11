package frc.robot.subsystems.Shooter.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter.Shooter;

public class Shoot extends CommandBase {
    private Shooter shooter;
    private int power;
    public Shoot(Shooter shooter,int power) {
        this.shooter = shooter;
        this.power = power;
    }
}
