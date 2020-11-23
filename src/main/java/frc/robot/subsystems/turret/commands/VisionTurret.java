package frc.robot.subsystems.turret.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.turret.Turret;
import frc.robot.utilities.VisionModule;

public class VisionTurret extends CommandBase {

    private Turret turret;
    private VisionModule visionModule;

    public VisionTurret(Turret turret, VisionModule visionModule) {
        this.turret = turret;
        this.visionModule = visionModule;
        addRequirements(turret, visionModule);
    }

    public double getVisionAngle() {
        return visionModule.getVisionAngle() + turret.getPosition();
    }

    @Override
    public void initialize() {
        visionModule.setLEDs(true);
    }

    @Override
    public void execute() {
        if (visionModule.targetSeen())
            turret.setAngle(getVisionAngle());
    }

    @Override
    public boolean isFinished() {
        return Math.abs(turret.getPosition() - getVisionAngle()) < Constants.Turret.TOLERANCE;
    }

    @Override
    public void end(boolean interrupted) {
        visionModule.setLEDs(false);
        turret.setAngle(turret.getPosition());
    }


}
