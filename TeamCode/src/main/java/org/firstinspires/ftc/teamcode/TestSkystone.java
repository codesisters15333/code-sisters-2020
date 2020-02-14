//package org.firstinspires.ftc.teamcode;
//
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.util.ElapsedTime;
//
///**
// * Created by ashley.peake on 8/30/2018.
// * Modified by Julia Zhou
// */
//
//
//
//@TeleOp (name= "TeleOpSkystone", group= "Linear Opmode")
//public class TestSkystone extends LinearOpMode {
//
//    HardwareRoverRuckus robot = new HardwareRoverRuckus();
//
//    ElapsedTime runtime = new ElapsedTime();
//
//    @Override
//
//    public void runOpMode() {
//
//        telemetry.addData("init pressed", "about to initialize");
//        telemetry.update();
//
//        robot.initializeRobot(hardwareMap);
//
//
//        telemetry.addData("Status", "Ready to run");
//        telemetry.update();
//
//        waitForStart();
//
//
//        while (opModeIsActive()) {
//
//
//            robot.mechanum(-gamepad1.left_stick_x, gamepad1.left_stick_y, -gamepad1.right_stick_x);
//
//
//            /**Julia - try this, likely needs modification.
//             * I have declared and initialized scissorLiftB in HardwareRoverRucks
//             * The two lifts will move in the same direction together
//             */
//
//            if (gamepad2.dpad_down) {
//                robot.liftA(1.0);
//                robot.liftB(1.0);
//            } else if (gamepad2.dpad_up) {
//                robot.liftA(-1.0);
//                robot.liftB(-1.0);
//            } else {
//                robot.liftA(0);
//                robot.liftB(0);
//            }
//
//
//            if (gamepad1.right_bumper) {
//                robot.pinion(1);
//            } else if (gamepad1.left_bumper) {
//                robot.pinion(-1);
//            } else {
//                robot.pinion(0);
//            }
//            if (gamepad2.a) {
//                robot.handA(.8);
//                robot.handB(.2);
//            } else if (gamepad2.b) {
//                robot.handA(.5);
//                robot.handB(.5);
//            } else if (gamepad2.y) {
//                robot.handA(.1);
//                robot.handB(.9);}
//
//
//
//
//}
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
