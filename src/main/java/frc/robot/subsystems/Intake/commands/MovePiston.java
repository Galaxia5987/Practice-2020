package frc.robot.subsystems.intake.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.intake.Intake;

import java.time.Instant;

/**
 * this command controls the Intake's Piston
 */
public class MovePiston extends InstantCommand {
    private Intake intake;
    public MovePiston(Intake i) {
        intake = i;
        addRequirements(intake);
    }

    @Override
    public void initialize() {
        intake.togglePiston();// calls the Intake's togglePiston function
    }
}
