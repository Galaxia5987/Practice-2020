package frc.robot.subsystems.turret.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.turret.Turret;

public class JoystickTurret extends CommandBase {
    private Turret turret;

    public JoystickTurret(Turret turret) {
        this.turret = turret;
        addRequirements(turret);
    }

    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        System.out.println(turret.getPosition());
        turret.setAngle(RobotContainer.xbox.getX() * Constants.Turret.TURRET_JOYSTICK_DEGREES + turret.getPosition());
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        turret.setAngle(turret.getPosition());
    }
}
