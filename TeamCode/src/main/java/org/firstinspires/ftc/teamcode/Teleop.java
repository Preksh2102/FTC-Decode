package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Main TeleOP", group = "Linear OpMode")
public class Teleop extends LinearOpMode {

    Drivetrain drivetrain;
    Intake intake;
    Shooter shooter;
    Transfer transfer;
    boolean shooterOn = false;
    boolean shooterButtonWasPressed = false;



    @Override
    public void runOpMode() {

        // Initialize hardware
        drivetrain = new Drivetrain(hardwareMap);
        intake = new Intake(hardwareMap);
        shooter = new Shooter(hardwareMap);
        transfer = new Transfer(hardwareMap);

        // Ready message
        telemetry.addLine("==============================");
        telemetry.addLine("       ROBOT INITIALIZING     ");
        telemetry.addLine("==============================");
        telemetry.addData("Drivetrain", "READY");
        telemetry.addData("Intake", "READY");
        telemetry.addData("Shooter", "READY");
        telemetry.addLine("");
        telemetry.addLine("       ROBOT READY!");
        telemetry.addLine("     Press PLAY to start");
        telemetry.update();

        // Wait for PLAY
        waitForStart();

        if (isStopRequested()) {
            return;
        }

        telemetry.clear();
        telemetry.addLine("TELEOP RUNNING");
        telemetry.update();

        while (opModeIsActive()) {

            // =========================
            // DRIVETRAIN
            // Left Y  = Forward/Backward
            // Left X  = Strafe
            // Right X = Rotate
            // =========================
            drivetrain.drive(
                    gamepad1.left_stick_x,
                    gamepad1.left_stick_y,
                    gamepad1.right_stick_x
            );

            // =========================
            // INTAKE
            // =========================
            if (gamepad1.right_trigger > 0.1) {
                intake.IntakeON();
            }
            else if (gamepad1.right_bumper) {
                intake.IntakeReverse();
            }
            else {
                intake.IntakeOFF();
            }

            // =========================
            // Transfer
            // =========================
            if (gamepad1.left_trigger > 0.1) {
                transfer.transferON();
            }
            else if (gamepad1.left_bumper) {
                transfer.transferReverse();
            }
            else {
                transfer.transferOFF();
            }

            // =========================
            // SHOOTER
            // X = Toggle Shooter ON/OFF
            // =========================
            if (gamepad1.x && !shooterButtonWasPressed) {
                shooterOn = !shooterOn;
            }

            shooterButtonWasPressed = gamepad1.x;

            if (shooterOn) {
                shooter.ShooterON();
            }
            else {
                shooter.ShooterOFF();
            }

        }
    }
}
