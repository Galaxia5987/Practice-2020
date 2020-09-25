package frc.robot.subsystems.drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class Drivetrain extends SubsystemBase {
    private final TalonFX drivetrainMasterRight1 = new TalonFX(1);
    private final TalonFX drivetrainMasterRight2 = new TalonFX(2);
    private final TalonFX drivetrainMasterLeft1 = new TalonFX(3);
    private final TalonFX drivetrainMasterLeft2 = new TalonFX(4);

    public Drivetrain() {
        drivetrainMasterRight1.setInverted(true);
        drivetrainMasterRight2.follow(drivetrainMasterRight1);
        drivetrainMasterLeft1.setInverted(false);
        drivetrainMasterLeft2.follow(drivetrainMasterLeft1);
    }

    public double getSpeedRight() {
        return drivetrainMasterRight1.getSelectedSensorVelocity();
    }

    public double getSpeedLeft() {
        return drivetrainMasterLeft1.getSelectedSensorVelocity();
    }

    public void setPower(double powerRight, double powerLeft) {
        drivetrainMasterRight1.set(ControlMode.PercentOutput,powerRight);
        drivetrainMasterLeft1.set(ControlMode.PercentOutput,powerLeft);
    }

    public void setVelocity(double velocityRight, double velocityLeft) {
        drivetrainMasterRight1.set(ControlMode.Velocity,velocityRight);
        drivetrainMasterLeft1.set(ControlMode.Velocity,velocityLeft);
    }

    @Override
    public void periodic() {

    }

    public double getAcceleration() {
        return Robot.navx.getWorldLinearAccelY()* Constants.g;
    }


}
