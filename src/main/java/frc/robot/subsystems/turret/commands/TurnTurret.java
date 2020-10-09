package frc.robot.subsystems.turret.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.turret.Turret;

public class TurnTurret extends CommandBase {
    private Turret turret;
    private double angle;

    public TurnTurret(Turret turret, double angle) {
        this.turret = turret;
        this.angle = angle;
        addRequirements(turret);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        turret.setAngle(angle);
    }

    @Override
    public boolean isFinished() {
        return Math.abs(turret.getPosition() - angle) < Constants.Turret.TOLERANCE;
    }

    @Override
    public void end(boolean interrupted) {

    }
}
