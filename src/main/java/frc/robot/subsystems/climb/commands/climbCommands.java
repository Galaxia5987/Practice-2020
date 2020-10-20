package frc.robot.subsystems.climb.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ExampleSubsystem.ExampleSubsystem;
import frc.robot.subsystems.climb.Climb;

public class climbCommands extends CommandBase {
        private final Climb climb;

        public climbCommands(Climb climb){
            this.climb = climb;
            addRequirements(climb);
        }


        public void initialize(){
            climb.setLeftHight(climb.getLeftHight());
            climb.setRightHight(climb.getRightHight());
        }

        public boolean isFinished(){
            boolean leftSideInPosition = Math.abs(climb.getLeftHight() - climb.getLeftHight()) < Constants.Drivetrain.TICKS_TO_METER;
            boolean rightSideInPosition = Math.abs(climb.getRightHight() - climb.getRightHight()) < Constants.Drivetrain.TICKS_TO_METER;
            return leftSideInPosition && rightSideInPosition;
        }
}
