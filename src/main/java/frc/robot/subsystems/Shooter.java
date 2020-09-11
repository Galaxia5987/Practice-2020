package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
    private TalonFX main;
    private VictorSPX side1;
    private VictorSPX side2;

    public Shooter(){
        main = new TalonFX(Constants.Shooter.Talon);
        main.setInverted(Constants.Shooter.isInverted);

        side1 = new VictorSPX(Constants.Shooter.victor1);
        side1.follow(main);

        side2 = new VictorSPX(Constants.Shooter.victor2);
        side2.follow(main);
    }

    public void setPower (double power){
        main.set(ControlMode.PercentOutput,power);
    }
}
