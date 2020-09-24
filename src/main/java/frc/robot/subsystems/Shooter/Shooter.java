package frc.robot.subsystems.Shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Ports;
import frc.robot.subsystems.UnitModel;

public class Shooter extends SubsystemBase {
    private TalonFX talonFX = new TalonFX(Ports.Shooter.MASTER);
    private VictorSPX victorSPX1 = new VictorSPX(Ports.Shooter.SLAVE1);
    private VictorSPX getVictorSPX2 = new VictorSPX(Ports.Shooter.SLAVE2);
    private final UnitModel UnitModel = new UnitModel(Constants.Shooter.TICKS_PER_ROTATION);

    public Shooter(){
        /**
         * Class constructor
         */
        talonFX.setInverted(Constants.Shooter.IS_INVERTED);

        victorSPX1.follow(talonFX);
        victorSPX1.setInverted(Constants.Shooter.IS_INVERTED);

        getVictorSPX2.follow(talonFX);
        getVictorSPX2.setInverted(Constants.Shooter.IS_INVERTED);

        talonFX.config_kP(Constants.Shooter.PID_SLOT,Constants.Shooter.KP);
        talonFX.config_kI(Constants.Shooter.PID_SLOT,Constants.Shooter.KI);
        talonFX.config_kD(Constants.Shooter.PID_SLOT,Constants.Shooter.KD);
        talonFX.config_kF(Constants.Shooter.PID_SLOT,Constants.Shooter.KF);
    }

    public int getVelocity(){
        return talonFX.getSelectedSensorVelocity();
    }

    public void setPower (double power){
        /**
         * this function activates Shooter's motors
         * @param power: the power output (%)
         */
        talonFX.set(ControlMode.PercentOutput,power);
    }
}
