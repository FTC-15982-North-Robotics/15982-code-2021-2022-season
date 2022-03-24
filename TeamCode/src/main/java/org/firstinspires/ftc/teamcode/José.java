package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="José", group="Linear Opmode")
public class José extends LinearOpMode {
        private DcMotor frontLeft;
        private DcMotor frontRight;
        private DcMotor backLeft;
        private DcMotor backRight;

        @Override
        public void runOpMode() {
                frontLeft = hardwareMap.get(DcMotor.class, "front_left");
                frontRight = hardwareMap.get(DcMotor.class, "front_right");
                backLeft = hardwareMap.get(DcMotor.class, "back_left");
                backRight = hardwareMap.get(DcMotor.class, "back_right");

                frontLeft.setDirection(DcMotor.Direction.REVERSE);
                backLeft.setDirection(DcMotor.Direction.REVERSE);
                frontRight.setDirection(DcMotor.Direction.FORWARD);
                backRight.setDirection(DcMotor.Direction.FORWARD);

                telemetry.addData("Initialized", "Ready to start");
                waitForStart();

                while (opModeIsActive()) {
                        double speed;
                        speed = 1;

                        backLeft.setPower(((1 * gamepad1.left_stick_y + gamepad1.left_stick_x) - gamepad1.right_stick_x) * speed);
                        backRight.setPower(((-1 * gamepad1.left_stick_y + gamepad1.left_stick_x) - gamepad1.right_stick_x) * speed);
                        frontLeft.setPower(((1 * gamepad1.left_stick_y - gamepad1.left_stick_x) - gamepad1.right_stick_x) * speed);
                        frontRight.setPower(((-1 * gamepad1.left_stick_y - gamepad1.left_stick_x) - gamepad1.right_stick_x) * speed);

                        telemetry.update();
                }
        }

        public void strafeLeft(double power) {
                frontRight.setPower(power);
                backRight.setPower(power*-1);
                frontLeft.setPower(power*-1);
                backLeft.setPower(power);
        }

        public void strafeRight(double power) {
                frontRight.setPower(power*-1);
                backRight.setPower(power);
                frontLeft.setPower(power);
                backLeft.setPower(power*-1);
        }

        public void backward(double power) {
                frontRight.setPower(power*-1);
                backRight.setPower(power*-1);
                frontLeft.setPower(power*-1);
                backLeft.setPower(power*-1);
        }

        public void forward(double power) {
                frontRight.setPower(power);
                backRight.setPower(power);
                frontLeft.setPower(power);
                backLeft.setPower(power);
        }

        public void spinLeft(double power) {
                frontRight.setPower(power*-1);
                backRight.setPower(power*-1);
                frontLeft.setPower(power);
                backLeft.setPower(power);
        }

        public void spinRight(double power) {
                frontRight.setPower(power);
                backRight.setPower(power);
                frontLeft.setPower(power*-1);
                backLeft.setPower(power*-1);
        }

        public void forward() {
                forward(1);
        }

        public void strafeLeft() {
                strafeLeft(1);
        }

        public void strafeRight() {
                strafeRight(1);
        }

        public void backward() {
                backward(1);
        }

        public void spinLeft() {
                spinLeft(1);
        }

        public void spinRight() {
                spinRight(1);
        }
}
