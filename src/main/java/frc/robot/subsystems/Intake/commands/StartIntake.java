package frc.robot.subsystems.Intake.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake.Intake;

public class StartIntake extends CommandBase{
    private Intake intake;
    private double power;

    public StartIntake(Intake intake, double power) {
        this.intake = intake;
        this.power = power;
    }

    @Override
    public void initialize() {
        intake.setPower(power);
    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {
        intake.setPower(0.0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
