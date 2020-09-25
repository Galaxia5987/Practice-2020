package frc.robot.subsystems.Shooter;

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
     * this constructor:
     *  -sets motors inverted
     *  -makes slaves to follow master
     *  -sets PID constants
     */
    public Shooter(){

        master.setInverted(Constants.Shooter.IS_INVERTED);

        slave1.follow(master);
        slave1.setInverted(Constants.Shooter.IS_INVERTED);

        slave2.follow(master);
        slave2.setInverted(Constants.Shooter.IS_INVERTED);

        master.config_kP(Constants.Shooter.PID_SLOT,Constants.Shooter.KP);
        master.config_kI(Constants.Shooter.PID_SLOT,Constants.Shooter.KI);
        master.config_kD(Constants.Shooter.PID_SLOT,Constants.Shooter.KD);
        master.config_kF(Constants.Shooter.PID_SLOT,Constants.Shooter.KF);
    }

    /**
     * this function activates Shooter's motors
     * @param power: the power output (%)
     */
    public void setPower (double power){

        master.set(ControlMode.PercentOutput,power);
    }
}
