package frc.robot.subsystems.drivetrain.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.drivetrain.Drivetrain;

public class SwitchGears extends InstantCommand {
    private Drivetrain drivetrain;
    private boolean initialPiston;

    public SwitchGears(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
        addRequirements(drivetrain);
        initialPiston = drivetrain.getPiston();
    }

    @Override
    public void initialize() {
        drivetrain.togglePiston();
    }




}
