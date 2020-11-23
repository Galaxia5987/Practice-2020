package frc.robot.subsystems.drivetrain;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj.Solenoid;
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
    private UnitModel highGear = new UnitModel(Constants.Drivetrain.TICKS_PER_METER_HIGH_GEAR);
    private UnitModel lowGear = new UnitModel(Constants.Drivetrain.TICKS_PER_METER_LOW_GEAR);
    private Solenoid piston = new Solenoid(Ports.Drivetrain.SOLENOID);

    /**
     * Invert masterRight & slaveRight motors and set both slaves to follow and set sensor phase.
     */
    public Drivetrain() {
        masterRight.setInverted(Ports.Drivetrain.MASTER_RIGHT_INVERTED);
        masterRight.setSensorPhase(Ports.Drivetrain.MASTER_RIGHT_SENSOR_PHASE);
        slaveRight.follow(masterRight);
        slaveRight.setInverted(Ports.Drivetrain.SLAVE_RIGHT_INVERTED);
        masterLeft.setInverted(Ports.Drivetrain.MASTER_LEFT_INVERTED);
        masterLeft.setSensorPhase(Ports.Drivetrain.MASTER_LEFT_SENSOR_PHASE);
        slaveLeft.follow(masterLeft);
        slaveLeft.setInverted(Ports.Drivetrain.SLAVE_LEFT_INVERTED);
    }

    /**
     * Get the correct unit model dependent on whether it's high gear or low gear.
     *
     * @return high gear or low gear unit model
     */
    public UnitModel getUnitModel() {
        if (getPistonMode()) {
            return highGear;
        } else
            return lowGear;
    }

    /**
     * Get speed of right drivetrain.
     *
     * @return speed of right drivetrain in [meters/second].
     */
    public double getSpeedRight() {
        return getUnitModel().toVelocity(masterRight.getSelectedSensorVelocity());
    }

    /**
     * Get speed of left drivetrain.
     *
     * @return speed of left drivetrain in [meters/second].
     */
    public double getSpeedLeft() {
        return getUnitModel().toVelocity(masterLeft.getSelectedSensorVelocity());
    }

    /**
     * Set power for drivetrain.
     *
     * @param powerRight right power [-1, 1].
     * @param powerLeft  left power [-1, 1].
     */
    public void setPower(double powerRight, double powerLeft) {
        masterRight.set(ControlMode.PercentOutput, powerRight);
        masterLeft.set(ControlMode.PercentOutput, powerLeft);
    }

    /**
     * Set velocity of drivetrain.
     *
     * @param velocityRight right velocity [m/s].
     * @param velocityLeft  left velocity [m/s].
     */
    public void setVelocity(double velocityRight, double velocityLeft) {
        masterRight.set(ControlMode.Velocity, getUnitModel().toTicks100ms(velocityRight));
        masterLeft.set(ControlMode.Velocity, getUnitModel().toTicks100ms(velocityLeft));
    }

    /**
     * Get acceleration of drivetrain.
     *
     * @return acceleration of drivetrain in [m/s^2].
     */
    public double getAcceleration() {
        return Robot.navx.getWorldLinearAccelY() * Constants.G;
    }

    /**
     * sets piston mode to the wanted given mode.
     *
     * @param pistonMode wanted piston mode (HIGH [true] /LOW [false]).
     */
    public void setPistonMode(PistonMode pistonMode) {
        piston.set(pistonMode.getValue());
    }

    /**
     * Get piston mode [extracted, retracted].
     *
     * @return piston mode [extracted, retracted].
     */
    public boolean getPistonMode() {
        return piston.get();
    }


    /**
     * enum for the piston mode, (HIGH = true) (LOW = false).
     */
    public enum PistonMode {
        HIGH(true),
        LOW(false);
        private boolean on;

        PistonMode(boolean on) {
            this.on = on;
        }

        /**
         * Gets the value of the piston.
         *
         * @return the value of the piston in boolean.
         */
        public boolean getValue() {
            return on;
        }
    }

    /**
     * Switch piston mode.
     */
    public void togglePiston() {
        piston.set(!piston.get());
    }

    @Override
    public void periodic() {

    }


}
