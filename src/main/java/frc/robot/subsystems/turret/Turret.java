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
    private UnitModel unitModel;

    public Turret() {
        master.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, Constants.TALON_TIMEOUT);
        unitModel = new UnitModel(Constants.Turret.TICKS_PER_DEGREE);
        master.config_kP(0, Constants.Turret.KP, Constants.TALON_TIMEOUT);
        master.config_kI(0, Constants.Turret.KI, Constants.TALON_TIMEOUT);
        master.config_kD(0, Constants.Turret.KD, Constants.TALON_TIMEOUT);
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
        double shortestPosition = Double.MAX_VALUE;
        double position[] = {targetAngle - 360, targetAngle, targetAngle + 360};
        for (double tarPos : position) {
            if (tarPos < Constants.Turret.MINIMUM_POSITION || tarPos > Constants.Turret.MAXIMUM_POSITION)
                continue;
            if (Math.abs(tarPos - getPosition()) < shortestPosition ) {
                shortestPosition = Math.abs(tarPos - getPosition());
                targetPosition = tarPos;
            }
        }
        master.set(ControlMode.Position, unitModel.toTicks(targetPosition));
    }


    public double getSpeed() {
        return unitModel.toVelocity(master.getSelectedSensorVelocity());
    }

    public double getPosition() {
        return unitModel.toUnits(master.getSelectedSensorPosition());
    }

    public void periodic() {
        // This method will be called once per scheduler run
    }
}




