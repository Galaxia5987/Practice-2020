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
        addRequirements(turret);
        this.visionModule = visionModule;
    }

    public boolean targetSeen() {
        return visionModule.targetSeen();
    }

    public double getVisionAngle() {
        return visionModule.getVisionAngle() + turret.getPosition();
    }

    public void setLEDs(boolean on) {
        visionModule.setLEDs(on);
    }

    @Override
    public void initialize() {
        setLEDs(true);
    }

    @Override
    public void execute() {
        if (targetSeen())
            turret.setAngle(getVisionAngle());
    }

    @Override
    public boolean isFinished() {
        return Math.abs(turret.getPosition() - getVisionAngle()) < Constants.Turret.TOLERANCE;
    }

    @Override
    public void end(boolean interrupted) {
        setLEDs(false);
    }


}
