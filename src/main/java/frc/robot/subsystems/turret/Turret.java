package frc.robot.subsystems.turret;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Ports;
import frc.robot.subsystems.UnitModel;

public class Turret extends SubsystemBase {
    private final TalonSRX master = new TalonSRX(Ports.Turret.MASTER);
    private final UnitModel unitModel = new UnitModel(Constants.Turret.TICKS_PER_DEGREE);

    /**
     * Turret Constructor: Config feedback sensor, create new unit model, and config kP,kI and kD.
     */
    public Turret() {
        master.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, Constants.TALON_TIMEOUT);
        master.setSelectedSensorPosition(0);
        master.config_kP(0, Constants.Turret.KP, Constants.TALON_TIMEOUT);
        master.config_kI(0, Constants.Turret.KI, Constants.TALON_TIMEOUT);
        master.config_kD(0, Constants.Turret.KD, Constants.TALON_TIMEOUT);
        master.setInverted(Ports.Turret.MASTER_INVERTED);
    }

    /**
     * Turn the turret to the given angle.
     *
     * @param targetAngle the angle the turret will turn to.
     */
    public void setAngle(double targetAngle) {
        targetAngle %= 360;
        targetAngle += 360;
        targetAngle %= 360;
        double targetPosition = getPosition();
        double shortestDistance = Double.MAX_VALUE;
        double[] position = {targetAngle - 360, targetAngle, targetAngle + 360};
        for (double tarPos : position) {
            if (tarPos < Constants.Turret.MINIMUM_POSITION || tarPos > Constants.Turret.MAXIMUM_POSITION)
                continue;
            if (Math.abs(tarPos - getPosition()) < shortestDistance) {
                shortestDistance = Math.abs(tarPos - getPosition());
                targetPosition = tarPos;
            }
        }
        master.set(ControlMode.Position, unitModel.toTicks(targetPosition));
    }

    /**
     * Gets the speed of the turret [m/s].
     *
     * @return the speed of the turret [m/s].
     */
    public double getSpeed() {
        return unitModel.toVelocity(master.getSelectedSensorVelocity());
    }

    /**
     * Gets the position of the turret in degrees.
     *
     * @return the position of the turret in degrees.
     */
    public double getPosition() {
        return unitModel.toUnits(master.getSelectedSensorPosition());
    }

    /**
     * Checks whether or not the given angle is in the deadzone.
     *
     * @param angle given angle [degrees].
     * @return whether or not the given angle is in the deadzone.
     */
    public boolean isInDeadzone(double angle) {
        return angle >= Constants.Turret.MINIMUM_DEADZONE && angle <= Constants.Turret.MAXIMUM_DEADZONE;
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}




