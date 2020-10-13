package frc.robot.subsystems.intake.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.intake.Intake;

/**
 * this command controls the Intake's Piston
 */
public class MovePiston extends CommandBase{
    private Intake intake;
    public MovePiston(Intake i) {
        intake = i;
    }

    @Override
    public void initialize() {
        intake.togglePiston();// calls the Intake's togglePiston function
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
