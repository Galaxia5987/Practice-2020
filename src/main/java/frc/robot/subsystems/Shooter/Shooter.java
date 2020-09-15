package frc.robot.subsystems.Shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
    private TalonFX talonFX = new TalonFX(Constants.Shooter.TALON);// connect talonFX to it's motor (by constant)
    private VictorSPX victorSPX1 = new VictorSPX(Constants.Shooter.VICTOR1);// connect VictorSPX1 to it's motor (by constant);
    private VictorSPX getVictorSPX2 = new VictorSPX(Constants.Shooter.VICTOR2);// connect VictorSPX2 to it's motor (by constant);
    private final UnitModel rpsUnitModel = new UnitModel(Constants.Shooter.TICKS_PER_ROTATION);

    /**
     * Contractor
     */
    public Shooter(){
        talonFX.setInverted(Constants.Shooter.IS_INVERTED);// set motor inverted (by constant)

        victorSPX1.follow(talonFX);// make side1 follow main motor
        victorSPX1.setInverted(Constants.Shooter.IS_INVERTED);// set motor inverted (by constant)

        getVictorSPX2.follow(talonFX);// make side2 follow main motor
        getVictorSPX2.setInverted(Constants.Shooter.IS_INVERTED);// set motor inverted (by constant)

        side2 = new VictorSPX(Constants.Shooter.VICTOR2);// connect side2 to it's motor (by constant)
        side2.follow(main);// make side2 follow main motor
    }

    /**
     * @param power: the power output (%)
     * this function activates Shooter's motors
     */
    public void setPower (double power){
        talonFX.set(ControlMode.PercentOutput,power);
    }
}
