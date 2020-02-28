package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by ashley.peake on 8/30/2018.
 * Modified by Julia Zhou
 */



@TeleOp (name= "TeleOpSkystone1", group= "Linear Opmode")
public class TeleOpSkystone1 extends LinearOpMode {

    HardwareRoverRuckus Rover = new HardwareRoverRuckus();

    ElapsedTime runtime = new ElapsedTime();

    @Override

    public void runOpMode() {

        telemetry.addData("init pressed", "about to initialize");
        telemetry.update();

        Rover.initializeRobot(hardwareMap);


        telemetry.addData("Status", "Ready to run");
        telemetry.update();

        Rover.rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        Rover.rightBack.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        //TODO; Original Code in TeleOpSkystone1
        while (opModeIsActive()) {

            //Reset Speed Variables
            double LF = 0;
            double RF = 0;
            double LB = 0;
            double RB = 0;

            //Get Joystick Variables
            double Y1 = gamepad1.right_stick_y;
            double X1 = gamepad1.right_stick_x;
            double Y2 = gamepad1.left_stick_y;
            double X2 = gamepad1.left_stick_x;

            //Forward/Back movement
            LF += Y1; RF += Y1; LB += Y1; RB += Y1;

            //Side to side movement
            LF += X1; RF -= X1; LB -= X1; RB += X1;

            //Rotation movement
            LF += X2; RF -= X2; LB += X2; RB -= X2;

            //Clip motor power values to +- 99%
            LF = Math.max (-0.99, Math.min (LF, 0.99));
            RF = Math.max (-0.99, Math.min (RF, 0.99));
            LB = Math.max (-0.99, Math.min (LB, 0.99));
            RB = Math.max (-0.99, Math.min (RB, 0.99));

            if (gamepad1.start) { // drive robot at slower speed for fine adjustments while carrying gold

                // TODO add scale factors back and make them more even across motor controls
                //Setting power to motors
                Rover.leftFront.setPower(-LF);
                Rover.leftBack.setPower(LB);
                Rover.rightFront.setPower(RF);
                Rover.rightBack.setPower(RB);


            }else{

                //Setting power to motors
                Rover.leftFront.setPower(-LF);
                Rover.leftBack.setPower(LB);
                Rover.rightFront.setPower(RF);
                Rover.rightBack.setPower(RB);
            }

            telemetry.addData("fwBack", "|%.3f|", Y1);
            telemetry.addData("strafe", "|%.3f|",  X1);
            telemetry.addData("turn", "|%.3f|", X2);
            telemetry.update();



            /**Julia - try this, likely needs modification.
             * I have declared and initialized scissorLiftB in HardwareRoverRucks
             * The two lifts will move in the same direction together
             */

            if (gamepad2.dpad_down) {
                Rover.liftA(1.0);
                Rover.liftB(1.0);
            } else if (gamepad2.dpad_up) {
                Rover.liftA(-1.0);
                Rover.liftB(-1.0);
            } else {
                Rover.liftA(0);
                Rover.liftB(0);
            }


            if (gamepad1.right_bumper) {
                Rover.pinion(1);
            } else if (gamepad1.left_bumper) {
                Rover.pinion(-1);
            } else {
                Rover.pinion(0);
            }

            if (gamepad2.a) {
                Rover.clawA.setPosition(0.9);
                Rover.clawB.setPosition(0.9);
            } else if (gamepad2.b) {
                Rover.clawA.setPosition(0.5);
                Rover.clawB.setPosition(0.5);
            } else if (gamepad2.y) {
                Rover.clawA.setPosition(0);
                Rover.clawB.setPosition(0);
            }
        }
    }
}











