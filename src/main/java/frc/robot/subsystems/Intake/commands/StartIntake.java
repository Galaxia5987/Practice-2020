package frc.robot.subsystems.Intake.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake.Intake;

public class StartIntake extends CommandBase{
    private Intake intake;
    
    public StartIntake(Intake i) {
        intake = i;
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
