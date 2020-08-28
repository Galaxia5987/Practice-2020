package frc.robot.subsystems.Intake.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake.Intake;

public class MoveIntake extends CommandBase{
    private Intake intake;
    public MoveIntake(Intake intake) {
        intake = intake;
    }

    @Override
    public void initialize() {
        intake.togglePiston();
    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
