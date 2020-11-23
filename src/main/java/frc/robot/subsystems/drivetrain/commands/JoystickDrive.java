package frc.robot.subsystems.drivetrain.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.drivetrain.Drivetrain;

/**
 * Define drivetrain.
 */
public class JoystickDrive extends CommandBase {
    private Drivetrain drivetrain;
    private double rightPower;
    private double leftPower;

    /**
     * Build drivetrain and add.
     *
     * @param drivetrain drivetrain.
     */
    public JoystickDrive(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {

    }

    /**
     * Set power of right and left drivetrain.
     */
    @Override
    public void execute() {
        rightPower = RobotContainer.r.getY();
        leftPower = RobotContainer.l.getY();
        drivetrain.setPower(rightPower, leftPower);
    }

    @Override
    public boolean isFinished() {
        return false;
    }


    @Override
    public void end(boolean interrupted) {
        drivetrain.setPower(0, 0);
    }
}
