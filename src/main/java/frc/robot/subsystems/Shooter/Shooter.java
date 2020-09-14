package frc.robot.subsystems.Shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
    private TalonFX main; // main motor
    private VictorSPX side1;// side motor 1
    private VictorSPX side2; // side motor 2

    /**
     * Contractor
     */
    public Shooter(){
        main = new TalonFX(Constants.Shooter.Talon);// connect main to it's motor (by constant)
        main.setInverted(Constants.Shooter.isInverted);// set main inverted (by constant)

        side1 = new VictorSPX(Constants.Shooter.victor1);// connect side1 to it's motor (by constant)
        side1.follow(main);// make side1 follow main motor

        side2 = new VictorSPX(Constants.Shooter.victor2);// connect side2 to it's motor (by constant)
        side2.follow(main);// make side2 follow main motor
    }

    /**
     * @param power: the power output (%)
     * this function activates Shooter's motors
     */
    public void setPower (double power){
        main.set(ControlMode.PercentOutput,power);
    }
}
