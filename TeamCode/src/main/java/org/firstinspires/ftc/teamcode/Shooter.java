package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Shooter {

    DcMotor shooterMotor;

    public Shooter(HardwareMap hardwareMap) {
        shooterMotor = hardwareMap.get(DcMotor.class, "shooter");
        shooterMotor.setDirection(DcMotor.Direction.REVERSE);
    }

    public void ShooterON() {
        shooterMotor.setPower(1.0);
    }

    public void ShooterOFF() {
        shooterMotor.setPower(0.0);
    }

    public void ShooterReverse() {
        shooterMotor.setPower(-1.0);
    }
}
