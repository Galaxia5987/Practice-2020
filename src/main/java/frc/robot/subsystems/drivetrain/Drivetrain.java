package frc.robot.subsystems.drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Ports;
import frc.robot.Robot;
import frc.robot.subsystems.UnitModel;

/**
 * Build 4 motors, 2 for each side.
 */
public class Drivetrain extends SubsystemBase {
    private final TalonFX masterRight = new TalonFX(Ports.Drivetrain.MASTER_RIGHT);
    private final TalonFX slaveRight = new TalonFX(Ports.Drivetrain.SLAVE_RIGHT);
    private final TalonFX masterLeft = new TalonFX(Ports.Drivetrain.MASTER_LEFT);
    private final TalonFX slaveLeft = new TalonFX(Ports.Drivetrain.SLAVE_LEFT);
    private UnitModel unitModel = new UnitModel(Constants.Drivetrain.TICKS_PER_METER);

    /**
     * Invert masterRight motor and set both slaves to follow.
     */
    public Drivetrain() {
        masterRight.setInverted(true);
        slaveRight.follow(masterRight);
        masterLeft.setInverted(false);
        slaveLeft.follow(masterLeft);
    }

    /**
     * Get speed of right drivetrain.
     *
     * @return speed of right drivetrain in [meters/second].
     */
    public double getSpeedRight() {
        return unitModel.toVelocity(masterRight.getSelectedSensorVelocity());
    }

    /**
     * Get speed of left drivetrain.
     *
     * @return speed of left drivetrain in [meters/second].
     */
    public double getSpeedLeft() {
        return unitModel.toVelocity(masterLeft.getSelectedSensorVelocity());
    }

    /**
     * Set power for drivetrain.
     *
     * @param powerRight right power [(-1) - 1].
     * @param powerLeft  left power [(-1) - 1].
     */
    public void setPower(double powerRight, double powerLeft) {
        masterRight.set(ControlMode.PercentOutput, powerRight);
        masterLeft.set(ControlMode.PercentOutput, powerLeft);
    }

    /**
     * Set velocity of drivetrain.
     *
     * @param velocityRight right velocity [meters/second].
     * @param velocityLeft  left velocity [meters/second].
     */
    public void setVelocity(double velocityRight, double velocityLeft) {
        masterRight.set(ControlMode.Velocity, unitModel.toTicks100ms(velocityRight));
        masterLeft.set(ControlMode.Velocity, unitModel.toTicks100ms(velocityLeft));
    }

    /**
     * Get acceleration of drivetrain.
     *
     * @return acceleration of drivetrain in [meters/seconds^2].
     */
    public double getAcceleration() {
        return Robot.navx.getWorldLinearAccelY() * Constants.g;
    }

    @Override
    public void periodic() {

    }


}
