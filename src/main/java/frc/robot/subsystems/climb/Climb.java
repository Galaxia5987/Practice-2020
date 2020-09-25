package frc.robot.subsystems.climb;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.ports;
import frc.robot.subsystems.UnitModel;

public class Climb extends SubsystemBase {

    private TalonSRX rightMaster = new TalonSRX(ports.Drivetrain.RIGHT_MASTER);
    private VictorSPX rightSlave = new VictorSPX(ports.Drivetrain.RIGHT_SLAVE);
    private TalonSRX leftMaster = new TalonSRX(ports.Drivetrain.LEFT_MASTER);
    private VictorSPX leftSlave = new VictorSPX(ports.Drivetrain.LEFT_SLAVE);
    private UnitModel UnitModel = new UnitModel(Constants.Drivetrain.TICKS_TO_METER);



    public Climb(){
        rightSlave.follow(rightMaster);
        leftSlave.follow(leftMaster);

        rightMaster.config_kP(0, Constants.Drivetrain.PIDF[0]);
        rightMaster.config_kI(0, Constants.Drivetrain.PIDF[1]);
        rightMaster.config_kD(0, Constants.Drivetrain.PIDF[2]);

        leftMaster.config_kP(0, Constants.Drivetrain.PIDF[0]);
        leftMaster.config_kI(0, Constants.Drivetrain.PIDF[1]);
        leftMaster.config_kD(0, Constants.Drivetrain.PIDF[2]);

        rightMaster.setInverted(ports.Drivetrain.right_inverted);
        rightSlave.setInverted(ports.Drivetrain.right_inverted);
        leftMaster.setInverted(ports.Drivetrain.left_inverted);
        leftSlave.setInverted(ports.Drivetrain.left_inverted);

        rightMaster.setSensorPhase(ports.Drivetrain.sensorPhase);
    }

    public void setPower(double rightPower, double leftPower){
        rightMaster.set(ControlMode.PercentOutput, rightPower);
        leftMaster.set(ControlMode.PercentOutput, leftPower);
    }
}
