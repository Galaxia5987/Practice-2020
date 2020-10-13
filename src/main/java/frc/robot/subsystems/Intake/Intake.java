package frc.robot.subsystems.intake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Ports;

public class Intake extends SubsystemBase{
    private TalonSRX talonSRX;
    private Solenoid piston;
    private State state;

    /**
     * Constructor
     */
    public Intake(){
        talonSRX = new TalonSRX(Ports.Intake.talonSRX);
        talonSRX.setInverted(Ports.Intake.isInverted);
        piston = new Solenoid(Ports.Intake.piston);
        state = State.CLOSED;
    }

    /**
     * @param power - power output (%)
     * this function sets motor's power
     */
    public void setPower(double power){
        talonSRX.set(ControlMode.PercentOutput,power);
    }

    /**
     * this function activates the piston
     */
    public void openPiston(){
        piston.set(true);
        state = State.OPENED;
    }

    /**
     * this function deactivates the piston
     */
    public void closePiston(){
        piston.set(false);
        state = State.CLOSED;
    }

    /**
     * this function toggles the piston's state (opened --> closed || closed --> opened)
     */
    public void togglePiston(){
        if(state == State.OPENED)
            closePiston();
        else
            openPiston();
    }

    @Override
    public void periodic() {

    }

    
    public enum State{//the piston optional states
        OPENED,
        CLOSED;
    }
}
