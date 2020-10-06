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
        master.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, Constants.Turret.TALON_TIMEOUT);
        unitModel = new UnitModel(Constants.Turret.TICKS_PER_DEGREE);
        master.config_kP(0, Constants.Turret.KP, Constants.Turret.TALON_TIMEOUT);
        master.config_kI(0, Constants.Turret.KI, Constants.Turret.TALON_TIMEOUT);
        master.config_kD(0, Constants.Turret.KD, Constants.Turret.TALON_TIMEOUT);
    }

    public void setAngle(double angle) {
        if (angle > 360) {
            angle = angle - 360;
        }
        if (angle < 0) {
            angle = angle + 360;
        }
        if (angle >= 270 && angle <= 320)
            return;

        double addAngle = 0;
        double myAngle = getPosition();
        double option1 = angle - myAngle; //delta angle is positive clockwise
        double option2 = -myAngle - (360 - angle); //delta angle is positive anti-clockwise
        double option3 = -(myAngle - angle); //delta angle is negative anti-clockwise
        double option4 = 360 - myAngle + angle; //delta angle is negative clockwise
        if (angle > myAngle) {
            if (Math.abs(option1) < Math.abs(option2))
                if(!(angle>320 && myAngle <270))
                    addAngle = option1;
                else
                    addAngle = option2;
            else
                if(angle >320)
                    addAngle = option2;
        } else {
            if (Math.abs(option3) < Math.abs(option4))
                if(!(myAngle>320 && angle <320))
                    addAngle = option3;
                else
                    addAngle = option4;
            else
                if(angle < 270 && myAngle >320)
                    addAngle = option4;
                else
                    addAngle = option4;
        }

        master.set(ControlMode.Position, unitModel.toUnits(addAngle));
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




