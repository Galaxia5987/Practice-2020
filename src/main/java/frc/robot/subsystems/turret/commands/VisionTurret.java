package frc.robot.subsystems.turret.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.turret.Turret;

public class VisionTurret extends CommandBase {

    private Turret turret;

    public VisionTurret(Turret turret) {
        this.turret = turret;
        addRequirements(turret);
    }

    @Override
    public void initialize() {
        setLEDs(true);
    }

    @Override
    public void execute() {
        if(targetSeen())
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

    public boolean targetSeen() {
//        visionModule.targetSeen();
        return true;
    }

    public double getVisionAngle() {
//        visionModule.getVisionAngle() + turret.getPosition();
        return 1;
    }

    public void setLEDs(boolean on) {
//        visionModule.setLEDs(on);
    }



}
