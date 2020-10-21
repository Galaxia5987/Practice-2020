package frc.robot.subsystems.drivetrain.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Constants;
import frc.robot.subsystems.drivetrain.Drivetrain;

public class SwitchGears extends InstantCommand {
    private Drivetrain drivetrain;

    public SwitchGears(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
        if (drivetrain.getSpeedLeft() > Constants.Drivetrain.MINIMUM_SPEED && drivetrain.getSpeedLeft() > Constants.Drivetrain.MINIMUM_SPEED)
            drivetrain.togglePiston();
    }


}
