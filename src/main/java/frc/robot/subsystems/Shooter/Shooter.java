package frc.robot.subsystems.shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Ports;
import frc.robot.subsystems.UnitModel;

public class Shooter extends SubsystemBase {
    private TalonFX master = new TalonFX(Ports.Shooter.MASTER);
    private VictorSPX slave1 = new VictorSPX(Ports.Shooter.SLAVE1);
    private VictorSPX slave2 = new VictorSPX(Ports.Shooter.SLAVE2);
    private final UnitModel UnitModel = new UnitModel(Constants.Shooter.TICKS_PER_ROTATION);

    /**
     * sets slaves to follow master and sets all motors inverted
     * sets PID constants
     */
    public Shooter() {

        master.setInverted(Ports.Shooter.IS_INVERTED_MASTER);

        slave1.follow(master);
        slave1.setInverted(Ports.Shooter.IS_INVERTED_SLAVE1);

        slave2.follow(master);
        slave2.setInverted(Ports.Shooter.IS_INVERTED_SLAVE2);

        master.config_kP(Constants.Shooter.PID_SLOT, Constants.Shooter.KP);
        master.config_kI(Constants.Shooter.PID_SLOT, Constants.Shooter.KI);
        master.config_kD(Constants.Shooter.PID_SLOT, Constants.Shooter.KD);
        master.config_kF(Constants.Shooter.PID_SLOT, Constants.Shooter.KF);
    }

    public double getVelocity() {
        return UnitModel.toVelocity(master.getSelectedSensorVelocity());
    }

    /**
     * @param distance: the target distance.
     * @return whether the shooter is working in the optimal velocity
     */
    public boolean isReady(double distance) {
        double velocityError = getVelocity()/distance;
        return 1.1 > velocityError && velocityError > 0.9;
    }

    /**
     * sets shooter's velocity.
     * @param velocity: the velocity output (m/s).
     */
    public void setVelocity(double velocity) {
        master.set(ControlMode.Velocity, velocity);
    }
}
